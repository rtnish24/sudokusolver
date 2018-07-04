package com.example.sudokusolver;

public class Grid {
    private boolean solved;
    private Cell activeCell;
    private Cell[][] grid;

    public Grid(int[][] inputArray){
        this.grid = new Cell[9][9];
        boolean startingPointIsSet = false;
        //fill in cell properties, find starting active cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.grid[row][col].setColumn(col);
                this.grid[row][col].setRow(row);
                this.grid[row][col].setValue(inputArray[row][col]);
                if (inputArray[row][col] != 0) {
                    this.grid[row][col].setIsStarter(true);
                }
                while (!startingPointIsSet){
                    if (!this.grid[row][col].getIsStarter()){
                        this.activeCell = this.grid[row][col];
                        startingPointIsSet = true;
                    }
                }
            }
        }
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
