package game;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    private char[][] gameBoard;
    private boolean gameOnGoing = true;

    //constructor of GameBoard.
    public GameBoard() {
        gameBoard = new char[3][3];

        int Iterator=1;
        for (int i = 0; i<3; i++) {
         for (int j = 0; j<3; j++){
            char val=Integer.toString(Iterator).charAt(0);
            gameBoard[i][j]=val;
            Iterator++;
        }
       }
    }


    //To display gameBoard .
    public void displayBoard() {
          for (int row = 0; row < gameBoard.length; row++)
        {   
            for (int column = 0; column < 3; column++)
            {   
                switch (column)
                {
                    case 0:
                        System.out.print(" " + gameBoard[row][column] + " | ");
                        break;
                    case 1:
                        System.out.print(gameBoard[row][column] + " | ");
                        break;
                    case 2:
                        System.out.println(gameBoard[row][column]);
                        break;
                }
            }
            if (row < 2)
            {
                System.out.println("-----------");
            }
        }
    }

    //to return game status.
    public boolean gameStatus() {
        return gameOnGoing;
    } 

    //take user input and makeMove
    public void askPlayer(char player) {
        Scanner keyboard = new Scanner(System.in);
        int n;
             
            System.out.printf("Player %s, please enter the position: ",player);
            n = keyboard.nextInt();
          try{
             makeMove(player,n);
        }
        catch(Exception e){
            System.out.println("Unable to make move");
            throw e;
        }
        

    }  

    public void checkForWinner() {
        //check over row 
        for (int row =0; row < gameBoard.length; row++) {
            if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2]
                    && gameBoard[row][0] != ' ') {
                System.out.print("The winner is " + gameBoard[row][0] + "!");
                gameOnGoing = false;
            }

        }

        //check over column 
        for (int col=0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col]
                    && gameBoard[0][col] != ' ') {
                System.out.print("The winner is " + gameBoard[0][col] + "!");
                gameOnGoing = false;
            }

        }

        //check over diagonals
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]
                && gameBoard[0][0] != ' ') {
            System.out.print("The winner is " + gameBoard[0][0] + "!");
            gameOnGoing = false;
        }

        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2]
                && gameBoard[2][0] != ' ') {
            System.out.print("The winner is " + gameBoard[2][0] + "!");
            gameOnGoing = false;
        }
    }

    public boolean makeMove(char player, int n) {
               switch (n){
                    case 1:
                    gameBoard[0][0] = player;
                    break;
                    case 2:
                    gameBoard[0][1] = player;
                    break;
                    case 3:
                    gameBoard[0][2] = player;
                    break;
                    case 4:
                    gameBoard[1][0] = player;
                    break;
                    case 5:
                    gameBoard[1][1] = player;
                    break;
                    case 6:
                    gameBoard[1][2] = player;
                    break;
                    case 7:
                    gameBoard[2][0] = player;
                    break;
                    case 8:
                    gameBoard[2][1] = player;
                    break;
                    case 9:
                    gameBoard[2][2] = player;
                    break;
                }    
                return true;
    
    } 
}