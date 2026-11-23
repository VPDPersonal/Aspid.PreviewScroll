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

> [!TIP]
> To preview each file as you move through the project tree, turn on **Enable Preview Tab** in the tree’s options menu.
> If you prefer to open files on demand, leave that option off. In Rider’s default macOS keymap, select a file and press <kbd>⌘ Enter</kbd> (**Show Source**) to open it with keyboard focus still in the tree. The scroll shortcuts work in regular tabs too.

## Shortcuts

| Action in Keymap | macOS | Windows | Default scroll distance |
| --- | --- | --- | --- |
| Scroll Preview Up | <kbd>⌘ ⌥ ⇧ ↑</kbd> | <kbd>Ctrl + Alt + Shift + ↑</kbd> | 3 lines |
| Scroll Preview Down | <kbd>⌘ ⌥ ⇧ ↓</kbd> | <kbd>Ctrl + Alt + Shift + ↓</kbd> | 3 lines |
| Scroll Preview Left | <kbd>⌘ ⌥ ⇧ ←</kbd> | <kbd>Ctrl + Alt + Shift + ←</kbd> | 3 space widths |
| Scroll Preview Right | <kbd>⌘ ⌥ ⇧ →</kbd> | <kbd>Ctrl + Alt + Shift + →</kbd> | 3 space widths |
| Scroll Preview Page Up | <kbd>⌘ ⌥ ⇧ Page Up</kbd> | <kbd>Ctrl + Alt + Shift + Page Up</kbd> | One screen, one line of overlap |
| Scroll Preview Page Down | <kbd>⌘ ⌥ ⇧ Page Down</kbd> | <kbd>Ctrl + Alt + Shift + Page Down</kbd> | One screen, one line of overlap |

Rebind these actions in **Settings → Keymap → Plugins → Aspid.Preview.Scroll**.

Set **Scroll step** in **Settings → Tools → Aspid.Preview.Scroll**. The value applies to all projects in the IDE and controls how many lines or space widths each arrow shortcut scrolls. Apply a change to use it immediately.

## Help and support

When reporting a shortcut issue, include your IDE name and version, plugin version, OS, active keymap, and the project view where it happened.

[**Open an issue**](https://github.com/VPDPersonal/Aspid.Preview.Scroll/issues) · [Star on GitHub](https://github.com/VPDPersonal/Aspid.Preview.Scroll)

## Support the project

If this plugin makes browsing code easier, you can support its development on Ko-fi.

<a href="https://ko-fi.com/vpdaspid"><img src="https://vpdpersonal.github.io/VPDPersonal/support/kofi-button.svg#stacked" alt="Tip on Ko-fi" width="100%" height="48" /></a>
