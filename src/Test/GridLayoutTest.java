package Test;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame {
    public GridLayoutTest(){
        JFrame jFrame = new JFrame(" TestGridLayout ");
        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");

        jFrame.setLayout(new GridLayout(3,2));

        jFrame.add(btn1);
        jFrame.add(btn2);
        jFrame.add(btn3);
        jFrame.add(btn4);
        jFrame.add(btn5);
        jFrame.add(btn6);

        jFrame.pack();//Java函数！ 自动选择一个最优的位置来确定
        jFrame.setVisible(true);
    }
}
