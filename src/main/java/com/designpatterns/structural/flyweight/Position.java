package com.designpatterns.structural.flyweight;

public class Position {
    private int row;
    private int column;
    
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public int getRow() { return row; }
    public int getColumn() { return column; }
    
    public Position withOffset(int rowOffset, int columnOffset) {
        return new Position(row + rowOffset, column + columnOffset);
    }
    
    @Override
    public String toString() {
        return String.format("[%d,%d]", row, column);
    }
}
