package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (vertical(board, i) || gorizont(board, i)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
    public static boolean vertical(int[][] board, int point){
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[point][i] == 0) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    public static boolean gorizont(int[][] board, int point){
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][point] == 0) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
