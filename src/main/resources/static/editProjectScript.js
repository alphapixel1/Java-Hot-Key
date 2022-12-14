let selectedKeybind = null;
let keybinds = [];
const get = function (id) {
    return document.getElementById(id)
}
addEventListener("load", (event) => {
    let loader = get("keybindsLoader");
    let rows = [...loader.querySelectorAll("tr")];
    let container = get("keybindContainer");
    for (const row of rows) {
        let name = row.querySelector(".name").innerHTML;
        let keys = [...row.querySelectorAll("li")].map(e => parseInt(e.innerHTML));
        let kb = new Keybind(name, keys);
        container.append(kb.element);
        kb.element.querySelector(".funcName").value = name;
        keybinds.push(kb);
    }

    updateKeybindInput();
    //   loader.parentElement.removeChild(loader);
});

/*window.onload = function () {


}*/


function addKeybind() {
    let kb = new Keybind();
    let container = get("keybindContainer");
    container.append(kb.element);
    keybinds.push(kb);
    updateKeybindInput();
}

function deleteKeybind(keybindElement) {
    get("keybindContainer").removeChild(keybindElement);
    keybinds = keybinds.filter(e => e.element !== keybindElement);
    updateKeybindInput();
}

function editKeybind(keybindElement) {
    selectedKeybind = keybinds.find(e => e.element === keybindElement);
    get("overlay").style.display = "block";
    updateOverlay();
}

function toggleModifier(checkbox) {
    selectedKeybind[checkbox.name] = checkbox.checked;
    updateOverlay();
}

function updateOverlay() {
    get("overlayAlt").checked = selectedKeybind.alt;
    get("overlayControl").checked = selectedKeybind.ctrl;
    get("overlayShift").checked = selectedKeybind.shift;
    get("overlayKeybindText").innerHTML = selectedKeybind.toString();

}

function updateKeybindInput() {
    console.log("updating keybind input")
    get("keybindData").value = keybinds.map(e => e.toQueryString()).join(".~.");
}

function clearKeybind() {
    if (selectedKeybind != null) {
        selectedKeybind.clear();
        updateOverlay();
    }
}

function updateKeybind() {
    selectedKeybind.element.querySelector(".keybindText").innerHTML = selectedKeybind.toString();
    get("overlay").style.display = "none";
    selectedKeybind = null;
    updateKeybindInput();
}

document.addEventListener("keydown", (event) => {
    if (selectedKeybind != null) {
        selectedKeybind.addKey(event);
        updateOverlay();
    }
});

class Keybind {
    constructor(name, keys) {
        let template = get("keybindTemplate");
        this.element = template.content.cloneNode(true).firstElementChild;
        this.element.querySelector(".funcName").onchange=updateKeybindInput;
        if (name == null) {
            this.keys = [];
            this.alt = false;
            this.ctrl = false;
            this.shift = false;
        } else {
            this.keys = keys.filter(e => e >= 0);
            this.ctrl = keys.includes(-1);
            this.alt = keys.includes(-2);
            this.shift = keys.includes(-3);
            this.element.querySelector(".keybindText").innerHTML = this.toString();
        }
    }

    clear() {
        this.keys = [];
        this.alt = false;
        this.ctrl = false;
        this.shift = false;
    }

    addKey(event) {
        if (event.key.length == 1) {
            let k = event.key.toLowerCase().charCodeAt(0);
            if (!isNaN(k) && k > 0 && !this.keys.includes(k))
                this.keys.push(k);
        }
    }

    toString() {
        let modifiers = [];
        if (this.ctrl)
            modifiers.push("Ctrl");
        if (this.alt)
            modifiers.push("Alt");
        if (this.shift)
            modifiers.push("Shift");
        let k = [...modifiers, ...this.keys.map(e => Keybind.getString(e).toUpperCase())];
        if (k.length == 0)
            return "None";
        return k.join(" + ");
    }

    toQueryString() {
        let name = this.elementNameInput().value;
        let k = [...this.keys];
        if (this.ctrl)
            k.push(-1);
        if (this.alt)
            k.push(-2);
        if (this.shift)
            k.push(-3);
        return name + Keybind.delimiter() + k.join(",");
    }

    elementNameInput() {
        return this.element.querySelector(".funcName")
    }

    static delimiter() {
        return "~";
    }

    static getString(code) {
        return String.fromCharCode(code);
    }


}