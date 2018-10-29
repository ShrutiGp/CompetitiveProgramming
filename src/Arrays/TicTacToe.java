package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private static final char X = 1;
    private static final int O = 0;
    private static int currentPlayer = X;
    private static int board[][] = new int[3][3];
    static int moves=0;

    static void showBoard() {
        for(int i = 0; i<board.length; i++) {
            System.out.println(board[i][0] + "  " + board[i][1] + "  " + board[i][2]);
        }
    }

    static void enterValues(int x, int y) {
        if(x < 0 || x > 2 || y<0 || y>2) {
            System.out.println("Invalid entry");
            return;
        }
        if(board[x][y] != -1) {
            System.out.println("Board position occupied");
            return;
        }
        board[x][y] = currentPlayer;
        moves++;
    }

    static boolean checkRow(int row) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer);
    }

    static boolean checkColumn(int col) {
        return  (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer);
    }

    static boolean checkDiagonal(int row, int col) {
        return (row == col && board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2] == currentPlayer)||
                (row+col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    static boolean checkWinner(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonal(row, col);
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int winner = -1;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = -1;
            }
        }

        do {
            System.out.println("Player " + currentPlayer + " turn : ");
            int coords[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            enterValues(coords[0], coords[1]);
            showBoard();
            if(checkWinner(coords[0], coords[1])) {
                System.out.println("Winner is : " + currentPlayer);
                winner = currentPlayer;
            }
            currentPlayer = 1-currentPlayer;

        }while(winner == -1 && moves < 9);

        if(winner == -1) {
            System.out.print("Tie");
        }

    }
}
