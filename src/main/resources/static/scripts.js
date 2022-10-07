function lightModeToggle() {
    const element = document.body;
    element.classList.toggle("light-mode");
    const button = document.getElementsByClassName("button6")[0];
    if (element.classList.contains("light-mode")) {
        button.innerHTML = "Dark Mode";
    } else {
        button.innerHTML = "Light Mode";
    }
}

function keybindPopup() {
    const element = document.getElementById("keybind-popup");
    element.classList.toggle("hidden");
}