function codeEditor() {
    var codeEditor = document.getElementById('codeEditor');
    var lineCounter = document.getElementById('lineCounter');

    codeEditor.addEventListener('scroll', () => {
        lineCounter.scrollTop = codeEditor.scrollTop;
        lineCounter.scrollLeft = codeEditor.scrollLeft;
    });

    codeEditor.addEventListener('keydown', (e) => {
        let {keyCode} = e;
        let {value, selectionStart, selectionEnd} = codeEditor;
        if (keyCode === 9) {  // TAB = 9
            e.preventDefault();
            codeEditor.value = value.slice(0, selectionStart) + '\t' + value.slice(selectionEnd);
            codeEditor.setSelectionRange(selectionStart + 2, selectionStart + 2)
        }
    });

    var lineCountCache = 0;

    function line_counter() {
        var lineCount = codeEditor.value.split('\n').length;
        var outarr = new Array();
        if (lineCountCache != lineCount) {
            for (var x = 0; x < lineCount; x++) {
                outarr[x] = (x + 1) + '.';
            }
            lineCounter.value = outarr.join('\n');
        }
        lineCountCache = lineCount;
    }

    codeEditor.addEventListener('input', () => {
        line_counter();
    });
}

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

function openModal() {
    const modal = document.getElementById("myModal");

    modal.style.display = "block";
}

function resetModal() {
    const modalContent = document.getElementById("modal-content");
    let closeSpan = document.createElement("span");
    closeSpan.setAttribute("class", "close");
    closeSpan.innerText = '×';

    modalContent.innerHTML = '';
    modalContent.appendChild(closeSpan);
    modalWindow();
}

function viewKeybindsModal() {
    const modalContent = document.getElementById("modal-content");

    let pElement = document.createElement("p");
    let text = document.createTextNode("Implement Thymeleaf in here to pull existing keybinds");

    resetModal()
    pElement.appendChild(text);
    modalContent.appendChild(pElement);
    openModal();
}

function helpModal() {
    const modalContent = document.getElementById("modal-content");

    resetModal()

    let mainHeading = document.createElement("h3");
    mainHeading.innerText = "Getting Started with Java Hot Key";

    let firstParagraph = document.createElement("p");
    firstParagraph.innerText = "Java Hot Key uses Lua to define key functions. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

    let luaReferenceHeading = document.createElement("h4");
    luaReferenceHeading.innerText = "Lua Reference";

    let luaReferenceParagraph = document.createElement("p");
    luaReferenceParagraph.innerText = "Below you can find a link to a Lua programming book!";

    let luaReferenceLink = document.createElement("a");
    luaReferenceLink.setAttribute("href", "https://www.lua.org/pil/contents.html");
    luaReferenceLink.setAttribute("target", "_blank");
    luaReferenceLink.setAttribute("rel", "noopener noreferrer")
    luaReferenceLink.innerText = "Programming in Lua (first edition)";

    modalContent.appendChild(mainHeading);
    modalContent.appendChild(firstParagraph);
    modalContent.appendChild(luaReferenceHeading);
    modalContent.appendChild(luaReferenceParagraph);
    modalContent.appendChild(luaReferenceLink);

    openModal();
}

function modalWindow() {
    const modal = document.getElementById("myModal");
    const span = document.getElementsByClassName("close")[0];

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