public class Main {
    public static void main(String[] args) {
        int size = 8;
        Board board = new Board(size);
        Queen[] queens = new Queen[size];

       recursivePlacing(0, 0, queens, board);
    }

    public static boolean tryPlace(int start_row, int col, Piece[] pieces, Board board) {
        pieces[col] = new Queen();
        pieces[col].setCol(col);

        for (int row = start_row; row < board.getSize(); row++) {
            boolean attacked = false;
            for (int i = 0; i < col; i++) {
                if (pieces[i].canAttack(row, col)) {
                    attacked = true;
                    break;
                }
            }
            if (!attacked) {
                pieces[col].setRow(row);
                pieces[col].place(board);
                return true;
            }
        }
        return false;
    }

    public static void recursivePlacing(int start_row, int col, Piece[] pieces, Board board) {
        if (col == board.getSize()) {
            System.out.println(board);
            return;
        }

        boolean placed = tryPlace(start_row, col, pieces, board);

        if (placed) {
            recursivePlacing(0, col+1, pieces, board);
        }
        else {
            pieces[col-1].remove(board);
            recursivePlacing(pieces[col-1].getRow() + 1, col-1, pieces, board);
        }
    }
}
