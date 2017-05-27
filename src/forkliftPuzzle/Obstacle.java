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
        //positions = new ArrayList<Position>();
        //findCollection(position);
    }

    /*private void findCollection(Position position) {
       
        positions.add(position);
        if(size>1){
            for(int i=0; i<size-1;i++){
                if(direction == Direction.HORIZONTAL)
                    positions.add(new Position(positions.get(positions.size()-1).getRow(), positions.get(positions.size()-1).getColumn()+1));
                else
                    positions.add(new Position(positions.get(positions.size()-1).getRow() + 1, positions.get(positions.size()-1).getColumn()));
            }
        }
    }*/

    //mover as peças
    /* public void moveUp() {
        for (Position p : positions)
        p.moveUp();
    }

    public void moveRight() {
        for (Position p : positions)
            p.moveRight();
    }

    public void moveDown() {
        for (Position p : positions)
            p.moveDown();
    }

    public void moveLeft() {
        for (Position p : positions)
            p.moveLeft();
    }*/

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

   /* public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }*/

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
