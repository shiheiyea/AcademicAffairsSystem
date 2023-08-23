package Test;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ButtonGroupTest extends JFrame {
    Container container = this.getContentPane();
    //将一个图片变为图标
    //单选框
    JRadioButton radiobutton01 = new JRadioButton("单选框1");
    JRadioButton radiobutton02 = new JRadioButton("单选框2");
    JRadioButton radiobutton03 = new JRadioButton("单选框3");

    public ButtonGroupTest() {
        //由于单选框只能选择一个，需要分组---一个组中只能选择一个
        /*ButtonGroup ground = new ButtonGroup();
        ground.add(radiobutton01);
        ground.add(radiobutton02);
        ground.add(radiobutton03);

        container.add(radiobutton01, BorderLayout.CENTER);
        container.add(radiobutton02, BorderLayout.NORTH);
        container.add(radiobutton03, BorderLayout.SOUTH);*/

        this.getContentPane().add(radiobutton01);

        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}