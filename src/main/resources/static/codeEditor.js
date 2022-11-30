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
        var outarr = [];
        if (lineCountCache !== lineCount) {
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