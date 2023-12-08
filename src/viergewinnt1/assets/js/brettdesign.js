function Zellen(){
    var board = document.getElementById('game-board');
    for (var i = 0; i < 4; i++) {
        for (var j = 0; j < 4; j++) {
            var cell = document.createElement('div');
            cell.className = 'cell';
            cell.style.top = i * 100 + 'px';
            cell.style.left = j * 100 + 'px';
            board.appendChild(cell);
        }
    }
}

const los  = document.getElementById('los');
los.addEventListener ('click', Zellen, true)

// var board = document.getElementById('game-board');
// for (var i = 0; i < 4; i++) {
//     for (var j = 0; j < 4; j++) {
//         var cell = document.createElement('div');
//         cell.className = 'cell';
//         cell.style.top = i * 100 + 'px';
//         cell.style.left = j * 100 + 'px';
//         board.appendChild(cell);
//     }
// }