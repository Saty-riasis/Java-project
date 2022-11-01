import game.GameBoard;

public class main {

    public static void main(String[] args) {
        GameBoard ttt = new GameBoard();
        ttt.displayBoard();

        int turn = 1;

        while (ttt.gameStatus() && turn < 10) {
            if (turn % 2 == 0)
                ttt.askPlayer('O');
            else
                ttt.askPlayer('X');
            turn++;

            System.out.print("\033[H\033[2J");  
            System.out.flush();
            ttt.displayBoard();
            ttt.checkForWinner();

            if (turn == 10)
                System.out.print("TIE!\n");
        }

    }

}

