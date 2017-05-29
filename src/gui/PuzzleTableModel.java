package gui;

import forkliftPuzzle.ForkliftPuzzleEvent;
import forkliftPuzzle.ForklifttPuzzleState;
import javax.swing.table.AbstractTableModel;
import forkliftPuzzle.ForkliftPuzzleListener;

public class PuzzleTableModel extends AbstractTableModel implements ForkliftPuzzleListener{

    private ForklifttPuzzleState puzzle;

    public PuzzleTableModel(ForklifttPuzzleState puzzle) {
        if(puzzle == null){
            throw new NullPointerException("Puzzle cannot be null");
        }
        this.puzzle = puzzle;
        this.puzzle.addListener(this);
    }

    public int getColumnCount() {
        return puzzle.getNumLines();
    }

    public int getRowCount() {
        return puzzle.getNumColumns();
    }

    public Object getValueAt(int row, int col) {
        return new Integer(puzzle.getTileValue(row, col));
    }

    public void puzzleChanged(ForkliftPuzzleEvent pe){
        fireTableDataChanged();
        try{
            Thread.sleep(500);
        }catch(InterruptedException ignore){
        }
    }

    public void setPuzzle(ForklifttPuzzleState puzzle){
        if(puzzle == null){
          throw new NullPointerException("Puzzle cannot be null");
        }
        this.puzzle.removeListener(this);
        this.puzzle = puzzle;
        puzzle.addListener(this);
        fireTableDataChanged();
    }
}
