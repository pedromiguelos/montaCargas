/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkliftPuzzle;

import agent.Action;
import java.util.ArrayList;
import java.util.LinkedList;


public class Obstacle {

      private int number;
    private int size;
    private Direction direction;
    private int row;
    private int column;

    public Obstacle(int row, int column, int number, int size, Direction direction) {
        
        this.number = number;
        this.direction = direction;
        this.size = size;
        this.row = row;
        this.column = column;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    boolean isHorizontal() {
        return direction == Direction.HORIZONTAL;
    }
    
     boolean isVertical() {
        return direction == Direction.VERTICAL;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
}
