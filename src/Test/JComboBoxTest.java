package Test;

import javax.swing.*;
import java.awt.*;

public class JComboBoxTest extends JFrame {
    public JComboBoxTest(){
        JComboBox<String> status = new JComboBox<>();
        status.setBounds(0,0,250,100);
        status.addItem(null);
        status.addItem("信息查询");
        status.addItem("成绩查询");

        this.getContentPane().add(status);

        this.setVisible(true);
        this.setSize(500,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
