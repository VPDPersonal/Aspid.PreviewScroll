package com.aspid.previewscroll

import com.intellij.openapi.components.BaseState
import com.intellij.openapi.components.RoamingType
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.SimplePersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@Service(Service.Level.APP)
@State(
    name = "AspidPreviewScrollSettings",
    storages = [Storage("aspid-preview-scroll.xml", roamingType = RoamingType.DISABLED)],
)
internal class PreviewScrollSettings :
    SimplePersistentStateComponent<PreviewScrollSettings.SettingsState>(SettingsState()) {

    var scrollStep: Int
        get() = state.scrollStep.takeIf { it > 0 } ?: DEFAULT_SCROLL_STEP
        set(value) {
            state.scrollStep = value
        }

    var horizontalScrollStep: Int
        get() = state.horizontalScrollStep.takeIf { it > 0 } ?: DEFAULT_HORIZONTAL_SCROLL_STEP
        set(value) {
            state.horizontalScrollStep = value
        }

    class SettingsState : BaseState() {
        var scrollStep by property(DEFAULT_SCROLL_STEP)
        var horizontalScrollStep by property(DEFAULT_HORIZONTAL_SCROLL_STEP)
    }

    private companion object {
        const val DEFAULT_SCROLL_STEP = 3
        const val DEFAULT_HORIZONTAL_SCROLL_STEP = 10
    }
}
