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

function modalWindow() {
// Get the modal
    var modal = document.getElementById("myModal");
// Get the button that opens the modal
    var btn = document.getElementById("myBtn");
// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
    btn.onclick = function () {
        modal.style.display = "block";
    }

// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

// When the user clicks anywhere outside the modal, close it
    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
}