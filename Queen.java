public class Queen implements Piece {
    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean canAttack(int row, int col) {
        return row == this.row || col == this.col ||
                (row - this.row) == (col - this.col) ||
                (row - this.row) == -(col - this.col);
    }

    public void place(Board board) {
        board.occupy(this.row, this.col);
    }

    public void remove(Board board) {
        board.unoccupy(this.row, this.col);
    }
}
