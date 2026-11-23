# Contributing to Aspid.PreviewScroll

## Code

- Keep new IntelliJ Platform API calls compatible with the minimum build in [build.gradle.kts](../build.gradle.kts).
- Keep keyboard focus in the Project tool window (Explorer in Rider) when a preview scroll action runs there.

## Tests

Run `buildPlugin` before opening a PR with code changes. For scroll behavior changes, check vertical, horizontal,
and page scrolling on a long file with wide lines. Confirm that the arrow keys still select files after scrolling.
For settings changes, apply both scroll-step values and check that each changes the corresponding scroll distance.

## Docs

- Update the [README](../README.md) when shortcuts, settings, installation, or compatibility change.
- For shortcut bugs, use the README's issue link and include the IDE version, plugin version, OS, active keymap, and reproduction steps.

## Pull request

- Branch from `main`, keep each PR to one logical change, and leave version bumps to release PRs.
- Use a [Conventional Commits](https://www.conventionalcommits.org/) title such as `fix: keep focus in Explorer`, up to 72 characters.
- Describe what changed and how you verified it. For manual tests, include the IDE version and OS.
