# AGENTS.md

Instructions for any AI coding agent working in this repository (Claude, Copilot, Cursor,
Codex, etc). See `README.md` for human-facing setup and onboarding; this file is the dense,
agent-facing ruleset.

## What this repository is

Code and slides for the Quarkus Club Book Club: a technical reading group that goes through one
book, one Item (or chapter) at a time. Every session ships a reveal.js deck (Portuguese and
English) plus Quarkus/Java code that compiles and is tested, proving every claim the slides make.

## Language split

- **Slides are bilingual, both required**: every session ships `index.html` (Portuguese, the
  language the sessions are actually held in) and `en.html` (English) - including speaker notes.
  Neither is a stub or a partial translation; see "Slide conventions" below for the parity rule.
- **Everything else is English**: README, commit messages, code (class/method/package names,
  `@DisplayName` strings, Javadoc). Never write Portuguese outside the two slide decks.

## Code conventions

- Java 25, Quarkus 3.33 (LTS). Package convention:
  `club.quarkusclub.bookclub.<book>.chapterNN.itemNN.<concept>`.
- No inline `//` comments. Javadoc only when something is genuinely non-obvious (a hidden
  constraint, a workaround, a business rule) - never to restate what a well-named identifier
  already says.
- Tests use JUnit 5 + AssertJ, with a class-level `@DisplayName` naming the property under test
  and a method-level `@DisplayName` in plain English describing the scenario. See any existing
  `*Test.java` for the exact shape (e.g. `reflexivity/PlayerTest.java`).
- Every concept slide is paired with a `.code.small` slide showing the **test** that proves it,
  not just the implementation. If you add a class, add its test, and add both slides.
- `EqualsVerifier` and `AssertJ` are already dependencies where relevant; prefer them over hand
  rolled equivalents.

## Slide conventions

- `assets/deck.css` is a contract, shared verbatim with `quarkusclub/workshops`. Compose
  `<section>` elements from its existing classes; never add per-deck CSS or new classes without
  updating that shared contract deliberately (and consciously diverging from workshops).
- `index.html` (Portuguese) and `en.html` (English) must stay **structurally identical**: same
  number of `<section>` elements, same order, same `data-src` paths. Verify with
  `grep -c '<section' index.html en.html` after editing either one.
- Code slides fetch straight from the real project files via `data-src` - never inline code that
  isn't the actual compiled source.
- Check Portuguese diacritics carefully when writing or editing `index.html` prose; missing
  accentuation is a real, previously-hit bug in this repo, not a hypothetical one.

## Attribution: no AI mentions, ever

This repository actively rejects AI attribution, both locally and in CI:

- `.githooks/commit-msg` blocks any commit whose message mentions an AI tool (Claude, Copilot,
  Cursor, ChatGPT, Codex, Gemini, etc.), carries a `Co-authored-by:` trailer naming one, or has a
  `Generated with ...` / 🤖 footer.
- `.github/workflows/attribution-ai-guard.yml` runs the same check in CI against every push and
  pull request, and additionally scans the PR title and description.

Do not add `Co-Authored-By:` lines, "Generated with" footers, session IDs, or any other AI
self-reference to commits, branches, PR titles, or PR descriptions in this repository - it will be
rejected, and there is no override.

## Adding a session

Full checklist in `README.md` under "Adding a session". In short: new Maven module under
`<book>/chapter-NN/item-NN/`, add it to `<book>/pom.xml`, write `slides/index.html` and `en.html`
in parallel, add a row to the Sessions table in `README.md`.

## Environment

JDK 25 is pinned two ways, use whichever you already have: `mise.toml` (mise) or `.sdkmanrc`
(SDKMAN). Neither is required to read or edit the slides, only to build and test the code.
