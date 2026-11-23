package com.aspid.previewscroll

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
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
                    val step = EditorUtil.getPlainSpaceWidth(editor) * COLUMNS_PER_STEP
                    scrolling.scrollHorizontally((scrolling.horizontalScrollOffset + direction * step).coerceAtLeast(0))
                }
                ScrollUnit.LINE -> {
                    val step = editor.lineHeight * LINES_PER_STEP
                    scrolling.scrollVertically((scrolling.verticalScrollOffset + direction * step).coerceAtLeast(0))
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

    private companion object {
        const val COLUMNS_PER_STEP = 3
        const val LINES_PER_STEP = 3
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
