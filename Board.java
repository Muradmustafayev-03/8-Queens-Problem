public class Board {
    private final int size;
    private boolean[][] occupied;

    public Board(int size) {
        this.size = size;
        this.reset();
    }

    public void reset() {
        this.occupied = new boolean[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                occupied[i][j] = false;
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        var line = new Object() {
            public String draw() {
                return "+---".repeat(Math.max(0, size)) + "+\n";
            }
        };
        StringBuilder str = new StringBuilder(line.draw());
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                str.append("|").append((occupied[i][j]) ? " X " : "   ");
            }
            str.append("|\n").append(line.draw());
        }
        return str.toString();
    }

    public void occupy(int row, int col) {
        this.occupied[row][col] = true;
    }

    public void unoccupy(int row, int col) {
        this.occupied[row][col] = false;
    }

    public boolean isOccupied(int row, int col) {
        return this.occupied[row][col];
    }

}
