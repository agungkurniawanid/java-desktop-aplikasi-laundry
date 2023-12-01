package codingImageDashboardAdmin;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class colorBackgroundJTable implements TableCellRenderer {

    DefaultTableCellRenderer renderer;

    public colorBackgroundJTable(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        renderer.setBackground(Color.BLACK);
        renderer.setForeground(Color.WHITE);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
