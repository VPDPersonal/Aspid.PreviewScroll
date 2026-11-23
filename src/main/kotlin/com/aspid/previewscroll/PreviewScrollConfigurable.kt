package com.aspid.previewscroll

import com.intellij.openapi.components.service
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.ui.dsl.builder.bindIntText
import com.intellij.ui.dsl.builder.panel

internal class PreviewScrollConfigurable : BoundConfigurable("Aspid.Preview.Scroll") {
    override fun createPanel() = panel {
        val settings = service<PreviewScrollSettings>()

        row("Scroll step:") {
            intTextField(1..Int.MAX_VALUE)
                .bindIntText(settings::scrollStep)
                .comment("Lines vertically and space widths horizontally per shortcut press.")
        }
    }
}
