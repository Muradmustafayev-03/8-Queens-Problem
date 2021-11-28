public interface Piece {
    int getRow();
    int getCol();
    void setRow(int row);
    void setCol(int col);
    boolean canAttack(int row, int col);
    void place(Board board);
    void remove(Board board);
}
