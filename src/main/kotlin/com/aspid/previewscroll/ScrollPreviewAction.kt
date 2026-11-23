package com.aspid.previewscroll

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.ex.util.EditorUtil
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.TextEditor

/**
 * Scrolls the editor that shows the file selected in a project tree, while the keyboard focus
 * stays on the tree.
 *
 * The action targets the editor opened for the selected file — the preview tab, when it is
 * enabled — and falls back to the focused editor and then to whatever editor is currently
 * selected.
 *
 * It stays enabled whenever a project is open, even when there is nothing to scroll: a disabled
 * action does not consume its key event, and an unconsumed keystroke reaches the macOS responder
 * chain, which answers it with the system beep.
 */
abstract class ScrollPreviewAction(private val unit: ScrollUnit, private val direction: Int) : AnAction() {
    final override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.EDT

    final override fun update(e: AnActionEvent) {
        e.presentation.isEnabled = e.project != null
    }

    final override fun actionPerformed(e: AnActionEvent) {
        e.inputEvent?.consume()

        val editor = findTargetEditor(e) ?: return
        val scrolling = editor.scrollingModel

        scrolling.disableAnimation()
        try {
            when (unit) {
                ScrollUnit.COLUMN -> {
                    val target = getScrollTarget(
                        scrolling.horizontalScrollOffset,
                        EditorUtil.getPlainSpaceWidth(editor),
                        service<PreviewScrollSettings>().horizontalScrollStep,
                    )
                    scrolling.scrollHorizontally(target)
                }
                ScrollUnit.LINE -> {
                    val target = getScrollTarget(
                        scrolling.verticalScrollOffset,
                        editor.lineHeight,
                        service<PreviewScrollSettings>().scrollStep,
                    )
                    scrolling.scrollVertically(target)
                }
                ScrollUnit.PAGE -> {
                    val step = (scrolling.visibleArea.height - editor.lineHeight).coerceAtLeast(editor.lineHeight)
                    scrolling.scrollVertically((scrolling.verticalScrollOffset + direction * step).coerceAtLeast(0))
                }
            }
        } finally {
            scrolling.enableAnimation()
        }
    }

    private fun findTargetEditor(e: AnActionEvent): Editor? {
        val project = e.project ?: return null
        val editors = FileEditorManager.getInstance(project)

        val selectedFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
        val editorForSelection = selectedFile
            ?.let { file -> editors.getEditors(file).filterIsInstance<TextEditor>().firstOrNull() }
            ?.editor

        return editorForSelection ?: e.getData(CommonDataKeys.EDITOR) ?: editors.selectedTextEditor
    }

    private fun getScrollTarget(offset: Int, unitSize: Int, unitCount: Int): Int {
        val step = unitSize.toLong() * unitCount
        return (offset + direction * step).coerceIn(0L, Int.MAX_VALUE.toLong()).toInt()
    }
}

/** The distance a single scroll action covers. */
enum class ScrollUnit {
    /** A few space widths. */
    COLUMN,

    /** A few text lines. */
    LINE,

    /** One visible screen minus a line of overlap. */
    PAGE,
}

class ScrollPreviewDownAction : ScrollPreviewAction(ScrollUnit.LINE, 1)

class ScrollPreviewUpAction : ScrollPreviewAction(ScrollUnit.LINE, -1)

class ScrollPreviewPageDownAction : ScrollPreviewAction(ScrollUnit.PAGE, 1)

class ScrollPreviewPageUpAction : ScrollPreviewAction(ScrollUnit.PAGE, -1)

class ScrollPreviewLeftAction : ScrollPreviewAction(ScrollUnit.COLUMN, -1)

class ScrollPreviewRightAction : ScrollPreviewAction(ScrollUnit.COLUMN, 1)
