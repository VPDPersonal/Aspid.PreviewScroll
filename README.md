# Aspid.Preview.Scroll

Scrolls the editor of the file selected in Rider's project trees without moving the keyboard
focus out of the tree.

With **Enable Preview Tab** turned on, select a file in the tree and scroll its preview.
The shortcuts also work with regularly opened files.

## Shortcuts

Hold **Command + Option + Shift** on macOS or **Ctrl + Alt** on Windows and press the key below.
Windows shortcuts use the numeric keypad with Num Lock on.

| Scroll | macOS | Windows | Step |
|---|---|---|---|
| Up / Down | ↑ / ↓ | Numpad 8 / 2 | 3 lines |
| Left / Right | ← / → | Numpad 4 / 6 | 3 space widths |
| Page up / down | Page Up / Page Down | Numpad 9 / 3 | One screen with one line of overlap |

Rebind them in **Settings → Keymap → Plugins → Aspid.Preview.Scroll**.

## How it works

Each action resolves the editor for the tree's selected file through `FileEditorManager` and
scrolls it with `ScrollingModel`, animation off. When the tree has no usable selection the action
falls back to the focused editor and then to the currently selected one.

The actions stay enabled whenever a project is open, even with nothing to scroll, and consume
their input event. A disabled action leaves its keystroke unconsumed; on macOS an unconsumed
keystroke reaches the responder chain, which answers it with the system beep — the intermittent
beep this plugin is meant to end.

## Build

```bash
JAVA_HOME=/path/to/jdk-21 ./gradlew buildPlugin   # -> build/distributions/*.zip
JAVA_HOME=/path/to/jdk-21 ./gradlew runIde        # sandboxed Rider with the plugin
```

`gradle.properties` points `riderHome` at the local Rider installation the plugin is built against.
