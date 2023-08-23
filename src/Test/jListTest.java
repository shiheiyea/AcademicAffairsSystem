package Test;

import javax.swing.*;
import java.awt.*;

public class jListTest extends JFrame{
    public jListTest() {
        String[] str = {"1", "2", "3"};

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(200,100));

        //JList<String> jList = new JList(str);
        JList jList = new JList(new MyListModel());


        scrollPane.add(jList);


        //jList.setBounds(100, 0, 50, 100);
        this.getContentPane().add(scrollPane);

        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

class MyListModel extends AbstractListModel {
    final private String[] str = {"1", "2", "3"};
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Object getElementAt(int index) {
        return str[index];
    }
}
