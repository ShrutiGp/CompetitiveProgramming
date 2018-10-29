package Sudoku;

public class BacktrackSudoku {

    private static final int SUDOKU_LENGTH = 9;
    private static int sudo[][];
    static void printBoard() {
        for(int i = 0; i<SUDOKU_LENGTH; i++) {
            for(int j=0; j< SUDOKU_LENGTH; j++) {
                System.out.print(sudo[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean backtrackSolve() {

        int x=-1, y=-1; // coordinates of place with 0 value in sudoku (empty)
        boolean emptyFound = false;

        for(int i = 0; i<SUDOKU_LENGTH && !emptyFound; i++) {
            for(int j=0; j<SUDOKU_LENGTH && !emptyFound; j++) {
                if(sudo[i][j] == 0) {
                    x = i;
                    y = j;
                    emptyFound = true;
                }
            }
        }
        if(!emptyFound) {
            return true;
        }
        for(int i = 1; i<=9; i++) {
            if(checkIfProperPlace(x, y, i)) {
                sudo[x][y] = i;
                if(backtrackSolve()) {
                    return true;
                }
                sudo[x][y] = 0; // failed
            }
        }
        return false;
    }

    static boolean checkIfProperPlace(int row, int col, int num) {
        //check for row
        for(int i=0; i<SUDOKU_LENGTH; i++) {
            if(sudo[row][i] == num)
                return false;
        }

        //check for column
        for(int i=0; i<SUDOKU_LENGTH;i++){
            if(sudo[i][col] == num)
                return false;
        }

        //check for the 3x3 box
        int rowStart = row - (row%3);
        int colStart = col - (col%3);
        for(int i = rowStart; i < rowStart+3; i++) {
            for(int j = colStart; j<colStart+3; j++) {
                if(sudo[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        sudo = new int [][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(!backtrackSolve())
            System.out.println("This sudoku cannot be solved");
        else
            printBoard();
    }
}