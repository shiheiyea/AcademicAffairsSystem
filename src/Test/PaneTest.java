package Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaneTest extends JFrame {
    public PaneTest() {
        //创建列表
        JTable table = new JTable();
        //获取列表模型
        table.setModel(new DefaultTableModel());
        //设置表格的选择模式为单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //显示table需要TableModel接口
        DefaultTableModel defaultTableModel = new DefaultTableModel() {//用匿名内部类的方式重写了isCellEditable方法——————妙啊！！！
            @Override
            public boolean isCellEditable(int row, int column) {
                //单元格是否可编辑
                return true;
            }
        };
        //添加列名词条
        defaultTableModel.addColumn("学院");
        defaultTableModel.addColumn("专业");
        defaultTableModel.addColumn("学号");
        defaultTableModel.addColumn("姓名");
        defaultTableModel.addColumn("年级班级");
        defaultTableModel.addColumn("年龄");
        defaultTableModel.addColumn("性别");
        defaultTableModel.addColumn("联系方式");
        defaultTableModel.addColumn("政治面貌");

        //将列名和数据给列表
        table.setModel(defaultTableModel);

        Button button = new Button();
        button.setBounds(0, 100, 100, 50);

        /*JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setRightComponent(new Label("1"));
        jSplitPane.setDividerLocation(120);
        jSplitPane.setDividerSize(0);
        jSplitPane.setBounds(0, 0, 170, 300);*/

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,400,200);

        Container parent = new Container();
        parent.setBounds(0,0,500,300);
        parent.add(scrollPane);


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(1);
                if (e.getSource().equals(button)) {
                    System.out.println(1);
                    parent.remove(scrollPane); // 从父容器中移除ScrollPane
                    parent.revalidate(); // 重新布局父容器
                    parent.repaint(); // 重绘父容器
                }
            }
        });


        this.getContentPane().add(button);
        this.getContentPane().add(parent);

        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
