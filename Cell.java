package com.example.sudokusolver;

public class Cell {
    private int row;
    private int column;
    private boolean isStarter = false;
    private int value;

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setStarter(boolean starter) {
        isStarter = starter;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
