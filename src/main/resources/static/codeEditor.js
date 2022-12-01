function codeEditor() {
    // grab elements
    var codeEditor = document.getElementById('codeEditor');
    var lineCounter = document.getElementById('lineCounter');

    // add event listener for scrolling
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

    // cache lineCount
    var lineCountCache = 0;

    // adds live line population
    function line_counter() {
        var lineCount = codeEditor.value.split('\n').length;
        var outarr = [];
        if (lineCountCache !== lineCount) {
            for (var x = 0; x < lineCount; x++) {
                outarr[x] = (x + 1) + '.';
            }
            lineCounter.value = outarr.join('\n');
        }
        lineCountCache = lineCount;
    }

    // final event listener that calls line_counter()
    codeEditor.addEventListener('input', () => {
        line_counter();
    });
}