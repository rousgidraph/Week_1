package _001.tic_tac_toe;

public class TTT {
    public TTT(){
    board = new char[3][3];
    currentPlayerMark = 'x';
    initializeBoard();
    }

    public boolean placeMark(int row, int col){
        if((row<3)&&(col<3)){
            if(board[row][col] == '-'){
                board[row][col] = currentPlayerMark;
                return true;
            }
        }
        return  false;
    }

    public void initializeBoard() {
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j< 3 ; j++){
                board[i][j] = '-';
            }
        }
    }
    public void printBoard(){
        System.out.println("-----------");
        for(int i = 0 ; i <3 ; i ++ ){
            System.out.print("|");
            for(int j = 0 ; j < 3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-----------");
        }
    }
    public boolean isBoardFull(){
            boolean isFull = false;
            for(int i = 0 ; i < 3;i++){
                for(int j = 0; j<3 ; j++){
                    if(board[i][j]=='-'){
                        isFull = false;
                    }
                }
            }
            return  isFull;
    }
    public char getCurrentPlayerMark(){
     return currentPlayerMark;
    }

    public boolean checkForWin(){
        return (checkRowsForWin()||checkColumnsForWIn()||checkDiagonalsForWin());
    }


    private boolean checkRowsForWin(){
        for(int i = 0; i < 3 ; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWIn(){
        for(int i = 0; i < 3 ; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin(){
        if((checkRowCol(board[0][0],board[1][1],board[2][2])==true)||(checkRowCol(board[2][0],board[1][1],board[0][2]))==true){
            return true;
        }else
            return false;
    }

    private boolean checkRowCol(char c1, char c2, char c3){
        if(!(c1=='-')&&(c1==c2)&&(c2==c3)){
            return true;
        }
        else return false;
    }
    public void changePlayer(){
        if(currentPlayerMark=='x'){
            currentPlayerMark = 'o';
        }else if(currentPlayerMark=='o'){
            currentPlayerMark = 'x';
        }
    }

    private char [][] board;
    private char currentPlayerMark;
}
