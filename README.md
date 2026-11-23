<picture>
  <source srcset="docs/images/banner.webp" type="image/webp" />
  <img src="docs/images/banner.png" alt="Aspid.Preview.Scroll — Keyboard scrolling from the Rider project tree" width="100%" />
</picture>

[![IDE: JetBrains Rider](docs/images/rider.svg)](#installation)
[![Plugin version: 0.2.0](docs/images/version.svg)](build.gradle.kts)

When you browse files with the arrow keys in Rider’s **Explorer**, a file may be longer than the editor window, or a line may run past its right edge. If you switch to the editor to scroll, you then have to switch back to the tree to select the next file.

**Aspid.Preview.Scroll** lets you scroll the selected file vertically or horizontally while keyboard focus stays in Explorer. When you’ve seen enough, press **↓** to preview the next file.

## Installation

The first release is pending. Once published, you can install the plugin either way:

- **[JetBrains Marketplace](https://plugins.jetbrains.com/search?search=Aspid.Preview.Scroll)** — in Rider, open **Settings → Plugins → Marketplace**, search for **Aspid.Preview.Scroll**, and select **Install**.
- **[GitHub Releases](https://github.com/VPDPersonal/Aspid.Preview.Scroll/releases)** — download the plugin ZIP from the release assets. In Rider, open **Settings → Plugins → ⚙ → Install Plugin from Disk…** and select the ZIP.

To preview files as you move through the tree, enable **Explorer → ⋮ → Behavior → Enable Preview Tab**. You can also scroll files already open in regular tabs.

## Shortcuts

Hold **⌘ Command + ⌥ Option + ⇧ Shift** on macOS or **Ctrl + Alt** on Windows, then press a key from the table. On Windows, turn on **Num Lock**.

| Direction | macOS | Windows | Scroll distance |
| --- | --- | --- | --- |
| Up / down | <kbd>↑</kbd> / <kbd>↓</kbd> | Numpad **8** / **2** | 3 lines |
| Left / right | <kbd>←</kbd> / <kbd>→</kbd> | Numpad **4** / **6** | 3 space widths |
| Page up / down | <kbd>Page Up</kbd> / <kbd>Page Down</kbd> | Numpad **9** / **3** | One screen, with one line of overlap |

<details>
<summary>Change a shortcut or resolve a conflict</summary>

Open <b>Settings → Keymap → Plugins → Aspid.Preview.Scroll</b>. Right-click a scroll action and choose <b>Add Keyboard Shortcut</b>. Rider shows other actions using the same keys. You can also use this to choose keys on a keyboard without a numeric keypad.

</details>

<details>
<summary>Which editor scrolls?</summary>

The plugin uses the open editor for the selected file. If that file has no open text editor, it uses the focused editor, then the currently selected editor. The actions consume their keystrokes even when there is nothing to scroll, to avoid the macOS system beep.

</details>

## Development

<details>
<summary>Build and test your own changes</summary>

Use **JDK 21** and a local Rider installation. Pass the Rider installation directory to Gradle (on macOS, use the app’s <code>Contents</code> directory).

```sh
./gradlew buildPlugin -PriderHome="/path/to/Rider.app/Contents"
```

On Windows, use <code>gradlew.bat</code> and the directory containing Rider’s <code>bin</code> folder. The ZIP is written to <code>build/distributions/</code>. To try the plugin in a sandboxed Rider instance, run the same command with <code>runIde</code> in place of <code>buildPlugin</code>.

</details>

## Resources

| [Explorer and preview tabs](https://www.jetbrains.com/help/rider/Project_Tool_Window.html) | [Customize keyboard shortcuts](https://www.jetbrains.com/help/rider/Configuring_Keyboard_and_Mouse_Shortcuts.html) |
| --- | --- |
| Configure how Rider displays the selected file. | Find an action, change its keys, or check for conflicts. |

## Help and support

When reporting a shortcut issue, include your Rider and plugin versions, OS, active keymap, and the Explorer view where it happened.

[**Open an issue**](https://github.com/VPDPersonal/Aspid.Preview.Scroll/issues) · [Star on GitHub](https://github.com/VPDPersonal/Aspid.Preview.Scroll)

## Support the project

If this plugin makes browsing code easier, you can support its development on Ko-fi.

<a href="https://ko-fi.com/vpdaspid"><picture><source media="(max-width: 640px)" srcset="https://vpdpersonal.github.io/VPDPersonal/support/kofi-button.svg#stacked" width="100%" height="48" /><img src="https://vpdpersonal.github.io/VPDPersonal/support/kofi-button.svg" alt="Tip on Ko-fi" width="50%" height="48" /></picture></a>
