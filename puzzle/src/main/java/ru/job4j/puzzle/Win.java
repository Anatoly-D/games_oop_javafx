package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (monoHorizontal(board, i) || monoVertical(board, i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        for (int i = 0; i < board[row].length - 1; i++) {
            if (board[row][i] != board[row][i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean monoVertical(int[][] board, int column) {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][column] != board[i + 1][column]) {
                return false;
            }
        }
        return true;
    }
}
