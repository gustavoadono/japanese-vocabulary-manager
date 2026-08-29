# Japanese Vocabulary Manager

A command line application written in Java for managing Japanese vocabulary.

The project focuses on **core Java**, object oriented design, collections, packages, validation, and separation of responsibilities.

## Project Idea

The application manages vocabulary entries containing:

```text
Japanese
Romaji
Meaning
```

Users can add, list, search, and remove vocabulary entries through a terminal interface.

Application state is stored in memory and is lost when the application terminates.

## Rules

### Vocabulary Entry

All fields are required.

A Japanese entry may contain any combination of Japanese writing systems:

```text
Kanji
Hiragana
Katakana
Kanji + Hiragana
Kanji + Katakana
Hiragana + Katakana
```

There is no character count restriction.

Examples:

```text
猫
ねこ
食べる
飲み物
テレビ
```

### Uniqueness

The `japanese` field is the unique key of an entry.

Two entries are considered duplicates only when their `japanese` strings are exactly equal.

`romaji` and `meaning` do not determine uniqueness.

Different Japanese representations may coexist.

```text
猫 / neko / cat
ねこ / neko / cat
```

Both entries are valid.

Different words with the same reading are also valid.

```text
暑い / atsui / hot weather
熱い / atsui / hot to the touch
```

Duplicate:

```text
猫 / neko / cat
猫 / neko / feline
```

A removed entry may be registered again.

### Search

Search checks the `japanese`, `romaji`, and `meaning` fields.

Romaji and meaning searches are case insensitive.

Japanese search uses exact string matching.

Partial matching is not required.

### List Order

Entries are displayed in **insertion order**.

## Data

The application may start with:

| Japanese | Romaji     | Meaning       |
| -------- | ---------- | ------------- |
| `ねこ`     | `neko`     | `cat`         |
| `いぬ`     | `inu`      | `dog`         |
| `みず`     | `mizu`     | `water`       |
| `ごはん`    | `gohan`    | `rice / meal` |
| `たべる`    | `taberu`   | `to eat`      |
| `のみもの`   | `nomimono` | `drink`       |
| `がっこう`   | `gakkou`   | `school`      |
| `せんせい`   | `sensei`   | `teacher`     |

Starting with an empty vocabulary is also valid.

## Flow

```text
Start
  ↓
Menu
  ├── Add
  ├── List
  ├── Search
  ├── Remove
  └── Exit
```

## Requirements

### Menu

```text
1. Add word
2. List words
3. Search word
4. Remove word
0. Exit
```

### Add

Create a vocabulary entry after validating all required fields and checking the uniqueness rule.

### List

Display all registered entries in insertion order.

If the vocabulary is empty:

```text
No words found.
```

### Search

Search by Japanese, romaji, or meaning.

If no entry matches:

```text
Word not found.
```

### Remove

Remove an entry using its `japanese` value.

If the entry does not exist:

```text
Word not found.
```

### Input Validation

The application must handle:

```text
Empty required fields
Duplicate entries
Invalid menu options
Non existent words
```

Recoverable input errors must not terminate the application.

## Project Structure

```text
japanese-vocabulary-manager/
└── src/
    └── main/
        └── java/
            └── com/
                └── gustavoadono/
                    └── vocabulary/
                        ├── Main.java
                        ├── model/
                        │   └── Word.java
                        ├── service/
                        │   └── VocabularyService.java
                        └── ui/
                            └── ConsoleApplication.java
```

```text
model    → domain objects
service  → vocabulary logic
ui       → console interaction
```

Implementation must be written from scratch using the **Java Standard Library**.

