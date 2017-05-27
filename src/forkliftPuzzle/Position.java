/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkliftPuzzle;

/**
 *
 * @author Pedro
 */
class Position {
    private int row;
    private int column;
    
        public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void moveUp() {
        row--;
    }

    public void moveRight() {
        column++;
    }

    public void moveDown() {
        row++;
    }

    public void moveLeft() {
        column--;
    }


}
