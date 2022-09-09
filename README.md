# Java-Hot-Key
## Introduction 
Define hotkeys for the mouse and keyboard, remap keys or buttons and autocorrect-like replacements.
## Storyboard

## Functional Requirements
### Requirement 1: Key mapping.
#### Scenario

User wants to remap their keybinds

#### Dependencies

User wants to remap a key

#### Assumptions

User has java

#### Examples
1.1
**Given** A Key

**When** Key is pressed

**Then** JLua code runs that can simulate key presses.

1.2
**Given** a new project is created

**When** add keymap is clicked

**Then** A keymap appears on the list of keymaps

### Requirement 2: Cloud Storage.
#### Scenario

User wants to store keymaps and lua in the cloud

#### Dependencies

User has a 

#### Assumptions

User has a google account

#### Examples
1.1
**Given** User has a google account

**When** Host Autohotkey Project is clicked

**Then** Code is hosted on firebase

1.2
**Given** User has a google account

**When** google sign in button is clicked

**Then** User is signed in.

1.3
**Given** User is signed in

**When** User clicks cloud tab

**Then** User is shown a list of their hosted projects

