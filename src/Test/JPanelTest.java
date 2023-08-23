package Test;

import javax.swing.*;
import java.awt.*;

public class JPanelTest extends JFrame{
    public JPanelTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // 创建组件
        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // 创建GridBagConstraints对象
        GridBagConstraints constraints = new GridBagConstraints();

        // 设置组件在网格中的位置和大小
        constraints.gridx = 0; // x轴位置
        constraints.gridy = 0; // y轴位置
        constraints.gridwidth = 1; // 宽度
        constraints.gridheight = 1; // 高度
        constraints.fill = GridBagConstraints.BOTH; // 组件填充方式

        // 添加组件到面板
        panel.add(label1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(button1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(label2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(button2, constraints);

        this.add(panel);
        this.pack();

        this.setSize(500, 300);
        this.setVisible(true);
    }
}
