<picture>
  <source srcset="docs/images/banner.webp" type="image/webp" />
  <img src="docs/images/banner.png" alt="Aspid.Preview.Scroll — Keyboard scrolling from the project tree" width="100%" />
</picture>

[![JetBrains IDEs on the IntelliJ Platform](docs/images/platform.svg)](#compatibility)
[![Plugin version: 0.2.0](docs/images/version.svg)](build.gradle.kts)

When you browse files with the arrow keys in the **Project** tool window (**Explorer** in Rider), a file may be longer than the editor window, or a line may run past its right edge. If you switch to the editor to scroll, you then have to switch back to the tree to select the next file.

**Aspid.Preview.Scroll** lets you scroll the selected file vertically or horizontally while keyboard focus stays in the tree. When you’ve seen enough, press **↓** to preview the next file.

## Compatibility

Designed for JetBrains IDEs built on the IntelliJ Platform. Verification so far is limited to **Rider 2026.3 on macOS**, where the plugin was built and its six packaged scroll actions were checked.

## Installation

The first release is pending. Once published, you can install the plugin either way:

- **[JetBrains Marketplace](https://plugins.jetbrains.com/search?search=Aspid.Preview.Scroll)** — open **Settings → Plugins → Marketplace**, search for **Aspid.Preview.Scroll**, and select **Install**.
- **[GitHub Releases](https://github.com/VPDPersonal/Aspid.Preview.Scroll/releases)** — download the plugin ZIP from the release assets. Open **Settings → Plugins → ⚙ → Install Plugin from Disk…** and select the ZIP.

To preview files as you move through the tree, open the project tree’s options menu and turn on **Enable Preview Tab**. You can also scroll files already open in regular tabs.

## Shortcuts

| Direction | macOS | Windows (Num Lock on) | Scroll distance |
| --- | --- | --- | --- |
| Up | <kbd>⌘ ⌥ ⇧ ↑</kbd> | <kbd>Ctrl + Alt + Numpad 8</kbd> | 3 lines |
| Down | <kbd>⌘ ⌥ ⇧ ↓</kbd> | <kbd>Ctrl + Alt + Numpad 2</kbd> | 3 lines |
| Left | <kbd>⌘ ⌥ ⇧ ←</kbd> | <kbd>Ctrl + Alt + Numpad 4</kbd> | 3 space widths |
| Right | <kbd>⌘ ⌥ ⇧ →</kbd> | <kbd>Ctrl + Alt + Numpad 6</kbd> | 3 space widths |
| Page up | <kbd>⌘ ⌥ ⇧ Page Up</kbd> | <kbd>Ctrl + Alt + Numpad 9</kbd> | One screen, one line of overlap |
| Page down | <kbd>⌘ ⌥ ⇧ Page Down</kbd> | <kbd>Ctrl + Alt + Numpad 3</kbd> | One screen, one line of overlap |

<details>
<summary>Change a shortcut or resolve a conflict</summary>

Open <b>Settings → Keymap → Plugins → Aspid.Preview.Scroll</b>. Right-click a scroll action and choose <b>Add Keyboard Shortcut</b>. The IDE shows other actions using the same keys. You can also use this to choose keys on a keyboard without a numeric keypad.

</details>

<details>
<summary>Which editor scrolls?</summary>

The plugin uses the open editor for the selected file. If that file has no open text editor, it uses the focused editor, then the currently selected editor. The actions consume their keystrokes even when there is nothing to scroll, to avoid the macOS system beep.

</details>

## Help and support

When reporting a shortcut issue, include your IDE name and version, plugin version, OS, active keymap, and the project view where it happened.

[**Open an issue**](https://github.com/VPDPersonal/Aspid.Preview.Scroll/issues) · [Star on GitHub](https://github.com/VPDPersonal/Aspid.Preview.Scroll)

## Support the project

If this plugin makes browsing code easier, you can support its development on Ko-fi.

<a href="https://ko-fi.com/vpdaspid"><img src="https://vpdpersonal.github.io/VPDPersonal/support/kofi-button.svg#stacked" alt="Tip on Ko-fi" width="100%" height="48" /></a>
