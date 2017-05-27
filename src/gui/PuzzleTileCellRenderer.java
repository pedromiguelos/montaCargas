package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import utils.ImageLoader;

public class PuzzleTileCellRenderer extends JLabel implements TableCellRenderer {

    private ArrayList<Position> listaPending = new ArrayList<Position>();
    private int forkListRow = -1;
    public PuzzleTileCellRenderer() {
        setBackground(Color.WHITE);
        setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus, int row,
            int column) {
        
        ImageLoader loader = ImageLoader.getLoader();
        setText("");
        
        if(row == forkListRow && column == 5){
            setIcon(loader.getIcon(Properties.IMAGE_DOOR));
            return this;
        }
        int valor = ((Integer) value).intValue();
        
        //As pecas pares acima do 4, 6 e 8 as pecas estao na msm linha!
        Position found = null;
        for (Position position : listaPending) { //Percorre a lista das posicoes marcadas cujos blocos ainda nao terminaram
            if(position.equals(row, column))
                found = position;
        }
        if( found != null){
            setIcon(loader.getIcon(found.path));
            listaPending.remove(found);
            
            return this;
        }
        
        switch(valor){
            case 0:
                setIcon(loader.getIcon(Properties.EMPTY_IMAGE));
                break;
            case 1:
                setIcon(loader.getIcon(Properties.IMAGE_FORKLIFT));
                forkListRow = row;
                break;
            case 2:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLHOR + Properties.IMAGE_SUFFIX));
                break;
            case 3:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLVER + Properties.IMAGE_SUFFIX));
                break;
            case 4:
                listaPending.add(new Position(row, column+1, Properties.IMAGE_PREFIXWALLHOR + "2" + Properties.IMAGE_SUFFIX));//Add the position that hes waiting for
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLHOR + "2_1" + Properties.IMAGE_SUFFIX));
                break;
            case 5:
                listaPending.add(new Position(row+1, column, Properties.IMAGE_PREFIXWALLVER + "2" + Properties.IMAGE_SUFFIX));
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLVER + "2_1" + Properties.IMAGE_SUFFIX));
                break;
            case 6:
                listaPending.add(new Position(row, column+1, Properties.IMAGE_PREFIXWALLHOR + "3" + Properties.IMAGE_SUFFIX));
                listaPending.add(new Position(row, column+2, Properties.IMAGE_PREFIXWALLHOR + "3" + Properties.IMAGE_SUFFIX));
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLHOR + "3_1" + Properties.IMAGE_SUFFIX));
                break;
            case 7:
                listaPending.add(new Position(row+1, column, Properties.IMAGE_PREFIXWALLVER + "3" + Properties.IMAGE_SUFFIX));
                listaPending.add(new Position(row+2, column, Properties.IMAGE_PREFIXWALLVER + "3" + Properties.IMAGE_SUFFIX));
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLVER + "3_1" + Properties.IMAGE_SUFFIX));
                break;
            case 8:
                listaPending.add(new Position(row, column+1, Properties.IMAGE_PREFIXWALLHOR + "4" + Properties.IMAGE_SUFFIX));
                listaPending.add(new Position(row, column+2, Properties.IMAGE_PREFIXWALLHOR + "4" + Properties.IMAGE_SUFFIX));
                listaPending.add(new Position(row, column+3, Properties.IMAGE_PREFIXWALLHOR + "4" + Properties.IMAGE_SUFFIX));
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLHOR + "4_1" + Properties.IMAGE_SUFFIX));
                break;
            case 9:
                listaPending.add(new Position(row+1, column, Properties.IMAGE_PREFIXWALLVER + "4" + Properties.IMAGE_SUFFIX));
                listaPending.add(new Position(row+2, column, Properties.IMAGE_PREFIXWALLVER + "4" + Properties.IMAGE_SUFFIX));
                listaPending.add(new Position(row+3, column, Properties.IMAGE_PREFIXWALLVER + "4" + Properties.IMAGE_SUFFIX));
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLVER + "4_1" + Properties.IMAGE_SUFFIX));
        }
        
        return this;
    }

    private static class Position {
        public int row;
        public int column;
        public String path;
        public Position(int row, int column, String path) {
            this.path = path;
            this.row = row;
            this.column = column;
        }

        public boolean equals(Position pos) {
            return (pos.row == this.row && pos.column == this.column) ? true: false;
        }
        
        public boolean equals(int row, int column) {
            return (row == this.row && column == this.column) ? true: false;
        }
        
    }
}
