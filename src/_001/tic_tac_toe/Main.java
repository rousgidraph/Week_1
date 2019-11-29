package _001.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        TTT game = new TTT();
        game.initializeBoard();
        System.out.println("Tic_Tac_Toe!");
        do{
            System.out.println("Current board Layout");
            game.printBoard();
            int row,col;
            do{
                System.out.println("Player "+game.getCurrentPlayerMark()+" , enter an empty row and column to place your mark! ");
                row = reader.nextInt();
                col = reader.nextInt();
            }
            while(!game.placeMark((row),(col)));
            game.changePlayer();
        }
        while(!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin())
        {
            System.out.println("The game was a tie!");
        }
        else
        {
            System.out.println("Current board layout: ");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark())+" Wins!");
        }


    }
}
