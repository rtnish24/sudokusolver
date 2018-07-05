package com.example.sudokusolver;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private boolean solved = false;
    private Cell activeCell;
    private Cell[][] grid;

    public Grid(int[][] inputArray){
        this.grid = new Cell[9][9];
        boolean startingPointIsSet = false;
        //fill in cell properties, find starting active cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.grid[row][col] = new Cell();
                this.grid[row][col].setColumn(col);
                this.grid[row][col].setRow(row);
                grid[row][col].setValue(inputArray[row][col]);
                if (inputArray[row][col] != 0) {
                    grid[row][col].setIsStarter(true);
                }
                else{
                    while(!startingPointIsSet){
                        activeCell = grid[row][col];
                        startingPointIsSet = true;
                    }
                }
            }
        }
    }

    public void solve(){
        while (!solved){
            //backtrack case
            if (activeCell.getValue() == 9){
                grid[activeCell.getRow()][activeCell.getColumn()].setValue(0);
                decrementActiveCell();
                solve();
            }
            else{
                grid[activeCell.getRow()][activeCell.getColumn()].setValue(activeCell.getValue() + 1);
                if (noErrors()){
                    incrementActiveCell();
                    solve();
                }
                else{
                    solve();
                }
            }
        }
    }

    public boolean noErrors(){
        boolean result = true;
        List<Cell> cellsToCheck = new ArrayList<>();
        for (int toCheck = 0; toCheck < 9; toCheck++) {
            //add row to check
            if (!(activeCell.getColumn() == toCheck)) {
                cellsToCheck.add(grid[activeCell.getRow()][toCheck]);
            }
            //add column to check
            if (!(activeCell.getRow() == toCheck)) {
                cellsToCheck.add(grid[toCheck][activeCell.getColumn()]);
            }
        }
        //add section to check
        int sectionRow = 0;
        int sectionColumn = 0;
        sectionRow = activeCell.getRow() - (activeCell.getRow()%3);
        sectionColumn = activeCell.getColumn() - (activeCell.getColumn()%3);
        for (int c = 0; c < 3; c++){
            for (int d = 0; d < 3; d++){
                if (!((c + sectionRow) == activeCell.getRow() && (d + sectionColumn) == activeCell.getColumn())) {
                    cellsToCheck.add(grid[c + sectionRow][d + sectionColumn]);
                }
            }
        }
        //check for repeated numbers
        for (Cell cell: cellsToCheck){
            if (cell.getValue() == activeCell.getValue()) {
                result = false;
                return result;
            }
        }
        return result;
    }

    public void incrementActiveCell(){
        if (activeCell.getColumn() == 8){
            if (activeCell.getRow() == 8){
                solved = true;
                return;
            }
            else{
                activeCell = grid[activeCell.getRow() + 1][0];
            }
        }
        else{
            activeCell = grid[activeCell.getRow()][activeCell.getColumn() + 1];
        }
        if (activeCell.getIsStarter()){
            incrementActiveCell();
        }
    }

    public void decrementActiveCell(){
        if (activeCell.getColumn() == 0){
            activeCell = grid[activeCell.getRow() - 1][8];
        }
        else{
            activeCell = grid[activeCell.getRow()][activeCell.getColumn() - 1];
        }
        if (activeCell.getIsStarter()){
            decrementActiveCell();
        }
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                result += grid[i][j].getValue();
                if (j !=8 ){
                    result += " | ";
                }
            }
            result += "\n";
        }
        return result;
    }
    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
