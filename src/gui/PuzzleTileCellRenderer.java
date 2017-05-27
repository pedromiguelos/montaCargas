package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import utils.ImageLoader;

public class PuzzleTileCellRenderer extends JLabel implements TableCellRenderer {
    
    public PuzzleTileCellRenderer() {
        setBackground(Color.WHITE);
        setOpaque(true);
        setFont(new Font("Monospaced", Font.BOLD, 49));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
    

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus, int row,
            int column) {
        
        ImageLoader loader = ImageLoader.getLoader();

        switch (((Integer) value).intValue()) {
            case 0:
                setIcon(loader.getIcon(Properties.EMPTY_IMAGE));
                break;
            case 1:
                setIcon(loader.getIcon(Properties.IMAGE_FORKLIFT));
                if(column == 5)
                     setIcon(loader.getIcon(Properties.IMAGE_DOOR));
                break;
            case 2:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLH + Properties.IMAGE_SUFFIX));
                break;
            case 3:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLV + Properties.IMAGE_SUFFIX));
                break;
            case 4:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLH + "2" + Properties.IMAGE_SUFFIX));
                break;
            case 5:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLV + "2" + Properties.IMAGE_SUFFIX));
                break;
            case 6:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLH + "3" + Properties.IMAGE_SUFFIX));
                break;
            case 7:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLV + "3" + Properties.IMAGE_SUFFIX));
                break;
            case 8:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLH + "4" + Properties.IMAGE_SUFFIX));
                break;
            case 9:
                setIcon(loader.getIcon(Properties.IMAGE_PREFIXWALLV + "4" + Properties.IMAGE_SUFFIX));
                break;
        }
                
        return this;
    }
}
