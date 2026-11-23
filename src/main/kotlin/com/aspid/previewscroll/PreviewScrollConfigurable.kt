package com.aspid.previewscroll

import com.intellij.openapi.components.service
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.ui.dsl.builder.bindIntText
import com.intellij.ui.dsl.builder.panel

internal class PreviewScrollConfigurable : BoundConfigurable("Aspid.PreviewScroll") {
    override fun createPanel() = panel {
        val settings = service<PreviewScrollSettings>()

        row("Vertical scroll step:") {
            intTextField(1..Int.MAX_VALUE)
                .bindIntText(settings::scrollStep)
                .comment("Lines per shortcut press.")
        }

        row("Horizontal scroll step:") {
            intTextField(1..Int.MAX_VALUE)
                .bindIntText(settings::horizontalScrollStep)
                .comment("Space widths per shortcut press.")
        }
    }
}
