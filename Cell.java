package com.example.sudokusolver;

public class Cell {
    private int row;
    private int column;
    private boolean isStarter = false;
    private int value;

    public Cell(){
        this.value = 0;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setIsStarter(boolean starter) {
        isStarter = starter;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean getIsStarter(){
        return this.isStarter;
    }

    public int getValue() {
        return value;
    }



}
