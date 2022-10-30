# Java-Hot-Key
## Introduction 
Define hotkeys for the mouse and keyboard, remap keys or buttons and autocorrect-like replacements.
## Storyboard
Click The Video 
[![Youtube Storyboard](http://img.youtube.com/vi/3buRxCkH9-M/0.jpg)](https://www.youtube.com/watch?v=3buRxCkH9-M "Video Title")
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

## Class Diagram
![unknown](https://user-images.githubusercontent.com/23407049/189464102-989f8f35-289c-420c-b305-948043375cd0.png)

## JSON Schema
```
{
  name:"project name",  
  keymaps:
  [
    {
      keymap:[17,65],
      functionName:"func_Name"
    }
  ],
  lua:"function func_name(keys)\nDown(Key.A)\nSleep(25)--ms\nUp(Key.A)\nPress(Key.B)\nend"
}
```
Array of keymaps each keymap has an array of keycodes and a function name
and the object also has a string of lua code.
## Scrum Roles
- Product Owner/Scrum Master/DevOps/GitHub Administrator: Andrew Glanz
- Business Logic and Persistence Specialist: Nick Bell
- UI Specialist: Felix and Jack McHugh 
- Test Developer: Reesë Tuttle
## Weekly Meeting

Thursday after 5pm On Discord.

