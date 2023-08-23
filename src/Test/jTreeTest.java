package Test;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class jTreeTest extends JFrame {


    public jTreeTest() {
        DefaultMutableTreeNode InformationManagement = new DefaultMutableTreeNode("信息管理");
        DefaultMutableTreeNode CheckYourStudentStatus = new DefaultMutableTreeNode("查看学籍");
        /*DefaultMutableTreeNode InformationQuery = new DefaultMutableTreeNode("查询信息");
        DefaultMutableTreeNode PasswordModification = new DefaultMutableTreeNode("修改密码");
        DefaultMutableTreeNode CourseSelection = new DefaultMutableTreeNode("选课");*/

        JTree jTree = new JTree(InformationManagement);

        //InformationManagement.add(CheckYourStudentStatus);

        this.getContentPane().add(jTree);

        /*JTree tree;
        // 定义几个初始节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
        DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

        // 通过add()方法建立树节点之间的父子关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);
        // 以根节点创建树
        tree = new JTree(root);
        // 创建一个DefaultTreeCellRender对象
        DefaultTreeCellRenderer cellRender = new DefaultTreeCellRenderer();
        // 设置非选定节点的背景色。
        cellRender.setBackgroundNonSelectionColor(new Color(220, 220, 220));
        // 设置节点在选中状态下的背景颜色。
        cellRender.setBackgroundSelectionColor(new Color(140, 140, 140));
        // 设置选中状态下节点的边框颜色。
        cellRender.setBorderSelectionColor(Color.BLACK);
        // 设置处于折叠状态下非叶子节点的图标。
        cellRender.setClosedIcon(new ImageIcon("icon/close.gif"));
        // 设置节点文本的字体。
        cellRender.setFont(new Font("SansSerif", Font.BOLD, 16));
        // 设置叶子节点的图标。
        cellRender.setLeafIcon(new ImageIcon("icon/leaf.png"));
        // 设置处于展开状态下非叶子节点的图标。
        cellRender.setOpenIcon(new ImageIcon("icon/open.gif"));
        // 设置绘制非选中状态下节点文本的颜色。
        cellRender.setTextNonSelectionColor(new Color(255, 0, 0));
        // 设置绘制选中状态下节点文本的颜色。
        cellRender.setTextSelectionColor(new Color(0, 0, 255));
        tree.setCellRenderer(cellRender);
        // 设置是否显示根节点的“展开/折叠”图标,默认是false
        tree.setShowsRootHandles(true);
        // 设置节点是否可见,默认是true
        tree.setRootVisible(true);
        this.add(new JScrollPane(tree));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);*/

        DefaultTreeCellRenderer defaultTreeCellRenderer = new DefaultTreeCellRenderer();
        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 处理鼠标点击事件
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // 左键点击
                    TreePath path = jTree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        Object node = path.getLastPathComponent();
                        if (node == InformationManagement) {
                            System.out.println("1");
                            // 处理节点点击事件
                        }

                    }
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    // 右键点击
                    // 显示右键菜单
                }
            }
        });
        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
