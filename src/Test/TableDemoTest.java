package Test;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableDemoTest extends JFrame {

    public TableDemoTest() {

        JPanel panel = new JPanel(new BorderLayout());

        // 创建JTable对象，并设置TableModel
        JTable table = new JTable();

        // 创建TableModel对象，实现其中的方法
        DefaultTableModel model = new DefaultTableModel();
        //对模型的列添加词条
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("");

        //按钮
        TableCellRenderer tableCellRenderer = new TableCellRenderer() {
            JButton jButton = new JButton();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                jButton.setText((value == null) ? "" : value.toString());
                return jButton;
            }
        };

        DefaultCellEditor defaultCellEditor = new DefaultCellEditor(new JCheckBox()) {
            JButton jButton = new JButton();
            String label;
            private boolean isPushed;


            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                if (isSelected) {
                    jButton.setForeground(table.getSelectionForeground());
                    jButton.setBackground(table.getSelectionBackground());
                } else {
                    jButton.setForeground(table.getForeground());
                    jButton.setBackground(table.getBackground());
                }

                label = (value == null) ? "" : value.toString();
                jButton.setText("选择");
                isPushed = true;
                return jButton;
            }

            public Object getCellEditorValue() {
                if (isPushed) {
                    //在这里可以添加按钮点击后的操作
                    System.out.println("点击");
                    JOptionPane.showMessageDialog(null, label + " is clicked");
                }
                isPushed = false;
                return label;
            }

            public boolean stopCellEditing() {
                isPushed = false;
                return super.stopCellEditing();
            }

            protected void fireEditingStopped() {
                super.fireEditingStopped();
            }
        };

        /*
        table.getColumnModel()      获取表格模型
        getColumn(1)                获取第一列的模型
        setCellRenderer             显示该列的数据。可以自定义渲染器来改变单元格的外观和显示方式。
        setCellEditor               编辑器决定了如何在表格中编辑该列的数据。可以自定义编辑器来实现特定的编辑功能。
        table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox()));
        */
        // 将集合数据转化为TableModel中的数据
        List<TestUser> list = new ArrayList<>();
        list.add(new TestUser(1, "Tom"));
        list.add(new TestUser(2, "Jerry"));
        for (TestUser user : list) {
            Object[] rowData = {user.getId(), user.getName(), "选择"};
            model.addRow(rowData);
        }


        // 将TableModel设置给JTable
        table.setModel(model);

        table.getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
        table.getColumnModel().getColumn(2).setCellEditor(defaultCellEditor);

        //添加
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        setVisible(true);


    }
}
