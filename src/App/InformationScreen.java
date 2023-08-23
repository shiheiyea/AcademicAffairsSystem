package App;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class InformationScreen extends JFrame {
    static TreeSet<Curriculum> allCourse = new TreeSet<>((o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));
    static Student stu = null;
    static User User = null;

    //创建容器放面板
    private final Container container = new Container();

    //创建面板
    private final JScrollPane scrollPane = new JScrollPane();
    //JScrollPane无法直接添加组件只能添加滚动组件

    static {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("数据结构与算法", "100");
        hm.put("高等数学", "99");
        hm.put("大学日语Ⅱ", "88");
        stu = new Student(
                "计算机学院",
                "软件工程",
                "22215120000",
                "黑夜",
                "软工0班",
                "18",
                "保密",
                "12345678910",
                "群众",
                hm);
        allCourse.add(new Curriculum(
                "沈瑞琳",
                "01",
                "数据结构与算法",
                "必修",
                "80",
                "56",
                "24",
                "5",
                "2022-2023-2",
                "2023.6.17",
                "9:00—11:30",
                "H111",
                "2小时"
        ));
        allCourse.add(new Curriculum(
                "沈瑞琳",
                "02",
                "程序设计基础",
                "必修",
                "80",
                "56",
                "24",
                "5",
                "2022-2023-2",
                "未定",
                "未定",
                "未定",
                "未定"
        ));
        allCourse.add(new Curriculum(
                "马娅妮",
                "05",
                "高等数学",
                "必修",
                "80",
                "56",
                "24",
                "5",
                "2022-2023-2",
                "未定",
                "未定",
                "未定",
                "未定"
        ));
        allCourse.add(new Curriculum(
                "彭靖",
                "04",
                "大学日语Ⅱ",
                "必修",
                "80",
                "56",
                "24",
                "5",
                "2022-2023-2",
                "未定",
                "未定",
                "未定",
                "未定"
        ));
        allCourse.add(new Curriculum(
                "黄依琴",
                "03",
                "大学物理",
                "必修",
                "80",
                "56",
                "24",
                "5",
                "2022-2023-2",
                "未定",
                "未定",
                "未定",
                "未定"
        ));
        allCourse.add(new Curriculum(
                "徐积文",
                "07",
                "离散数学",
                "必修",
                "80",
                "56",
                "24",
                "5",
                "2022-2023-2",
                "未定",
                "未定",
                "未定",
                "未定"
        ));
        User = new User("123", "123546", stu, "image\\帅.png");
    }

    public InformationScreen(User user) {
    //public informationScreen() {
        //数据初始化
        User = user;
        stu = user.getStu();
        //窗口初始化
        initJFrame();
        //菜单初始化
        //initJMenuBar();
        //容器初始化
        initContainer();
        //树初始化
        initJTree();
        //是否打开界面
        this.setVisible(true);
    }

    //界面初始化
    private void initJFrame() {
        //定制长宽高
        this.setSize(1000, 600);
        //界面标题
        this.setTitle("信息管理");
        //界面顶置
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //用xy轴加入组件
        this.setLayout(null);
        //关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //容器初始化
    private void initContainer() {
        //设置容器绝对布局
        container.setLayout(null);
        //容器大小
        container.setBounds(170, 0, 820, 600);
        //设置面板的位置和大小
        scrollPane.setBounds(0, 0, 830, 600);
        //文本
        JLabel jLabel = new JLabel("欢迎使用教务管理系统");
        /*
        第一个参数：familyName是字体类型，例如宋体、仿宋、Times New Roman等;
        第二个参数：style是字体风格，例如斜体字、加粗等；
            官方提供4种固定值，如下：
                Font.PLAIN（普通）
                Font.BOLD（加粗）
                Font.ITALIC（斜体）
                Font.BOLD + Font.ITALIC（粗斜体）
        第三个参数：size是字体大小，其默认单位为pt（磅），数字越大、字就越大（例如12pt字比10pt的字要大）。
        */
        //设置字体
        jLabel.setFont(new Font(null, Font.BOLD, 16));
        //字体水平居中
        //jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //字体垂直居中
        //jLabel.setVerticalAlignment(SwingConstants.CENTER);
        //字体设置
        jLabel.setBounds(310, 210, 200, 100);
        //添加到容器
        container.add(jLabel);
        //容器添加到界面
        this.getContentPane().add(container);
    }

    //菜单初始化
    private void initJMenuBar() {
        //创建菜单
        JMenuBar jMenuBar = new JMenuBar();

        //条目添加到选项
        JMenuItem jMenuItem = new JMenuItem("退出");

        //选项添加菜单
        jMenuBar.add(jMenuItem);

        jMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("退出");
                InformationScreen.super.setVisible(false);
                new LoginScreen();
            }
        });

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //菜单树
    private void initJTree() {
        //创建树的节点
        DefaultMutableTreeNode InformationManagement = new DefaultMutableTreeNode("信息管理");
        DefaultMutableTreeNode CheckYourStudentStatus = new DefaultMutableTreeNode("查看学籍");
        DefaultMutableTreeNode InformationQuery = new DefaultMutableTreeNode("信息查询");
        DefaultMutableTreeNode CourseGradeInquiry = new DefaultMutableTreeNode("课程成绩查询");
        DefaultMutableTreeNode CourseInformationInquiry = new DefaultMutableTreeNode("课程信息查询");
        DefaultMutableTreeNode ExamInformationInquiry = new DefaultMutableTreeNode("考试信息查询");
        DefaultMutableTreeNode UserInformationUpdates = new DefaultMutableTreeNode("用户信息更新");
        DefaultMutableTreeNode PasswordModification = new DefaultMutableTreeNode("修改密码");
        DefaultMutableTreeNode CourseSelection = new DefaultMutableTreeNode("选课");
        //给根添加节点
        InformationManagement.add(CheckYourStudentStatus);
        InformationManagement.add(InformationQuery);
        InformationManagement.add(UserInformationUpdates);
        InformationManagement.add(PasswordModification);
        InformationManagement.add(CourseSelection);
        //添加到信息查询
        InformationQuery.add(CourseGradeInquiry);
        InformationQuery.add(CourseInformationInquiry);
        InformationQuery.add(ExamInformationInquiry);
        //创建树
        JTree jTree = new JTree(InformationManagement);
        //设置是否显示根节点的“展开/折叠”图标,默认是false
        jTree.setShowsRootHandles(true);
        //创建树的鼠标监听
        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //处理鼠标点击事件
                if (SwingUtilities.isLeftMouseButton(e)) {
                    //左键点击
                    TreePath path = jTree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        // 处理节点点击事件
                        if (path.getLastPathComponent().equals(CheckYourStudentStatus)) {
                            System.out.println("学籍查询");
                            CheckYourStudentStatusAndUserInformationUpdatesDemo(true);
                        } else if (path.getLastPathComponent().equals(CourseGradeInquiry)) {
                            System.out.println("课程成绩查询");
                            CourseGradeInquiryList();
                        } else if (path.getLastPathComponent().equals(CourseInformationInquiry)) {
                            System.out.println("课程信息查询");
                            CourseInformationInquiryList();
                        } else if (path.getLastPathComponent().equals(ExamInformationInquiry)) {
                            System.out.println("考试信息查询");
                            ExamInformationList();
                        } else if (path.getLastPathComponent().equals(UserInformationUpdates)) {
                            System.out.println("用户信息更新");
                            CheckYourStudentStatusAndUserInformationUpdatesDemo(false);
                        } else if (path.getLastPathComponent().equals(PasswordModification)) {
                            System.out.println("修改密码");
                            PasswordModificationDemo();
                        } else if (path.getLastPathComponent().equals(CourseSelection)) {
                            System.out.println("选课");
                            CourseSelectionList();
                        }

                    }
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    // 右键点击
                    // 显示右键菜单
                    System.out.println("双击");
                }
            }
        });
        //创建面板
        JScrollPane jScrollPane = new JScrollPane(jTree);

        //设置滚动面板的位置和大小
        jScrollPane.setBounds(0, 0, 170, 600);

        //将面板添加到界面
        this.getContentPane().add(jScrollPane);
    }

    //成绩查询列表
    private void CourseGradeInquiryList() {
        //清空容器
        container.removeAll();

        //创建列表
        JTable table = new JTable();

        //获取列表模型
        table.setModel(new DefaultTableModel());

        //通过渲染器将列表里的字体居中
        //创建渲染器对象
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        //设置字体居中
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        //使列表使用渲染器  columnClass - 设置此columnClass的默认单元格渲染器
        table.setDefaultRenderer(Object.class, centerRenderer);

        //设置表格的选择模式为单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //显示table需要TableModel接口
        DefaultTableModel defaultTableModel = new DefaultTableModel() {//用匿名内部类的方式重写了isCellEditable方法——————妙啊！！！
            @Override
            public boolean isCellEditable(int row, int column) {
                //单元格是否可编辑
                return false;
            }
        };

        //添加列名词条
        defaultTableModel.addColumn("学号");
        defaultTableModel.addColumn("姓名");
        defaultTableModel.addColumn("年级班级");
        defaultTableModel.addColumn("课程名称");
        defaultTableModel.addColumn("总成绩");

        //将数据添加到列名下
        Set<Map.Entry<String, String>> entries = stu.getHm().entrySet();
        entries.forEach((entry) -> {
            String key = entry.getKey();
            String value = entry.getValue();
            String[] s = {
                    stu.getNumber(),
                    stu.getName(),
                    stu.getSquad(),
                    key,
                    value,
            };
            defaultTableModel.addRow(s);
        });

        //将列名和数据给列表
        table.setModel(defaultTableModel);

        //清空当前面板里的内容
        scrollPane.getViewport().removeAll();

        //将列表添加到面板里
        scrollPane.setViewportView(table);

        //将面板放入容器里
        container.add(scrollPane);
        //组件更新
        ComponentUpdates();
    }

    //课程查询列表
    private void CourseInformationInquiryList() {
        //清空容器
        container.removeAll();

        //创建列表
        JTable table = new JTable();

        //获取列表模型
        //table.setModel(new DefaultTableModel());

        //通过渲染器将列表里的字体居中
        //创建渲染器对象
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        //设置字体居中
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        //使列表使用渲染器  columnClass - 设置此columnClass的默认单元格渲染器
        table.setDefaultRenderer(Object.class, centerRenderer);

        //设置表格的选择模式为单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //显示table需要TableModel接口
        DefaultTableModel defaultTableModel = new DefaultTableModel() {//用匿名内部类的方式重写了isCellEditable方法——————妙啊！！！
            @Override
            public boolean isCellEditable(int row, int column) {
                //单元格是否可编辑
                return false;
            }
        };

        //添加列名词条
        defaultTableModel.addColumn("课程编号");
        defaultTableModel.addColumn("课程名称");
        defaultTableModel.addColumn("课程类别");
        defaultTableModel.addColumn("总学时");
        defaultTableModel.addColumn("理论学时");
        defaultTableModel.addColumn("实验学时");
        defaultTableModel.addColumn("学分");
        defaultTableModel.addColumn("开课学期");

        //将数据添加到列名下
        for (Curriculum curriculum : allCourse) {
            HashMap<String, String> hm = stu.getHm();
            if (hm.containsKey(curriculum.getName())) {
                String[] s = {
                        curriculum.getNumber(),
                        curriculum.getName(),
                        curriculum.getCourseCategory(),
                        curriculum.getTotalHours(),
                        curriculum.getTheoreticalHours(),
                        curriculum.getLabHours(),
                        curriculum.getCredits(),
                        curriculum.getStartOfTheSemester(),
                };
                defaultTableModel.addRow(s);
            }
        }

        //将列名和数据给列表
        table.setModel(defaultTableModel);

        //清空当前面板里的内容
        scrollPane.getViewport().removeAll();

        //将列表添加到面板里
        scrollPane.setViewportView(table);

        //将面板放入容器里
        container.add(scrollPane);

        //组件更新
        ComponentUpdates();
    }

    //考试查询列表
    private void ExamInformationList() {
        //清空容器内容
        container.removeAll();

        //创建列表
        JTable table = new JTable();

        //获取列表模型
        table.setModel(new DefaultTableModel());

        //通过渲染器将列表里的字体居中
        //创建渲染器对象
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        //设置字体居中
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        //使列表使用渲染器  columnClass - 设置此columnClass的默认单元格渲染器
        table.setDefaultRenderer(Object.class, centerRenderer);

        //设置表格的选择模式为单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //显示table需要TableModel接口
        DefaultTableModel defaultTableModel = new DefaultTableModel() {//用匿名内部类的方式重写了isCellEditable方法——————妙啊！！！
            @Override
            public boolean isCellEditable(int row, int column) {
                //单元格是否可编辑
                return false;
            }
        };

        //添加列名词条
        defaultTableModel.addColumn("开考日期");
        defaultTableModel.addColumn("考试时间");
        defaultTableModel.addColumn("地点");
        defaultTableModel.addColumn("考试科目");
        defaultTableModel.addColumn("考试时长");

        //将数据添加到列名下
        for (Curriculum curriculum : allCourse) {
            HashMap<String, String> hm = stu.getHm();
            if (hm.containsKey(curriculum.getName())) {
                String[] s = {
                        curriculum.getExamDate(),
                        curriculum.getExamTime(),
                        curriculum.getTestLocation(),
                        curriculum.getName(),
                        curriculum.getExamLength(),
                };
                defaultTableModel.addRow(s);
            }
        }

        //将列名和数据给列表
        table.setModel(defaultTableModel);

        //清空当前面板里的内容
        scrollPane.getViewport().removeAll();

        //将列表添加到面板里
        scrollPane.setViewportView(table);

        //将面板放入容器里
        container.add(scrollPane);

        //组件更新
        ComponentUpdates();
    }

    //选课列表
    private void CourseSelectionList() {
        //清空容器内容
        container.removeAll();

        //通过渲染器将列表里的字体居中
        //创建渲染器对象
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        //设置字体居中
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        //显示table需要TableModel接口
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //单元格是否可编辑
                //使按钮可以被选中
                return column == 6;
            }
        };

        //添加列名词条
        defaultTableModel.addColumn("课程编号");
        defaultTableModel.addColumn("课程名称");
        defaultTableModel.addColumn("教师");
        defaultTableModel.addColumn("理论课时");
        defaultTableModel.addColumn("实验学时");
        defaultTableModel.addColumn("学分");
        defaultTableModel.addColumn("");

        //将数据添加到列名下
        for (Curriculum curriculum : allCourse) {
            HashMap<String, String> hm = stu.getHm();
            if (!hm.containsKey(curriculum.getName())) {
                String[] s = {
                        curriculum.getNumber(),
                        curriculum.getName(),
                        curriculum.getTeacherName(),
                        curriculum.getTheoreticalHours(),
                        curriculum.getLabHours(),
                        curriculum.getCredits(),
                        "选择"
                };
                defaultTableModel.addRow(s);
            }
        }

        //创建列表
        JTable table = new JTable(defaultTableModel) {
            //重写getCellRenderer， 重新定义第6列的编辑方式
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 6) {
                    return new ButtonRenderer();
                }
                return super.getCellRenderer(row, column);
            }
            //重写getCellEditor， 重新定义第6列的编辑方式
            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                if (column == 6) {
                    return new ButtonEditor(new JCheckBox(), this);
                }
                return super.getCellEditor(row, column);
            }
        };

        //使列表使用渲染器  columnClass - 设置此columnClass的默认单元格渲染器
        table.setDefaultRenderer(Object.class, centerRenderer);

        //设置表格的选择模式为单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //清空当前面板里的内容
        scrollPane.getViewport().removeAll();

        //将列表添加到面板里
        scrollPane.setViewportView(table);

        //将面板放入容器里
        container.add(scrollPane);

        //组件更新
        ComponentUpdates();
    }

    //修改密码
    private void PasswordModificationDemo() {
        //清空容器
        container.removeAll();
        //文本
        JLabel PasswordLabel = new JLabel("设置新的密码");
        JLabel againPasswordLabel = new JLabel("再次确认新的密码");
        //文本框
        JTextField PasswordTextField = new JTextField();
        JTextField againPasswordTextField = new JTextField();
        //按钮
        JButton jButton = new JButton("确定");
        //按钮窗口大小
        jButton.setBounds(350, 300, 100, 25);
        //文本窗口大小
        PasswordLabel.setBounds(270, 100, 150, 50);
        againPasswordLabel.setBounds(260, 200, 150, 50);
        //文本框窗口大小
        PasswordTextField.setBounds(375, 115, 175, 25);
        againPasswordTextField.setBounds(375, 215, 175, 25);
        //给按钮添加鼠标监听
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println("确定");
                //获取文本框内容
                String Password = PasswordTextField.getText();
                String againPassword = againPasswordTextField.getText();

                if (Password.length() == 0 || againPassword.length() == 0) {

                    showJDialog("输入不能为空");

                } else if (Password.equals(againPassword)) {

                    //修改密码
                    User.setPassword(Password);

                    showJDialog("修改成功");

                    //通过父子关系关闭当前界面
                    InformationScreen.super.setVisible(false);

                    //打开登录界面
                    new LoginScreen();
                } else {

                    showJDialog("两次密码不一致");
                }
            }
        });
        //将按钮放入容器里
        container.add(jButton);
        //将文本放入容器里
        container.add(PasswordLabel);
        container.add(againPasswordLabel);
        //将文本框放入容器里
        container.add(PasswordTextField);
        container.add(againPasswordTextField);
        //容器重新绘制
        container.revalidate();
        container.repaint();
    }

    //查看学籍
    private void CheckYourStudentStatusAndUserInformationUpdatesDemo(boolean flag) {
        //清空容器
        container.removeAll();

        //文本
        JLabel stuNumber = new JLabel("学号：" + stu.getNumber());
        JLabel stuName = new JLabel("姓名：" + stu.getName());
        JLabel stuAge = new JLabel("年龄：" + stu.getAge());
        JLabel stuGender;
        JLabel stuInstitute = new JLabel("院系名称：" + stu.getInstitute());
        JLabel stuSpecialized = new JLabel("专业：" + stu.getSpecialized());
        JLabel stuSquad = new JLabel("班级：" + stu.getSquad());
        JLabel stuPoliticalLandscape = new JLabel("政治面貌：" + stu.getPoliticalLandscape());
        JLabel stuPhoneNumber;

        if (flag) {
            stuGender = new JLabel("性别：" + stu.getGender());
            stuPhoneNumber = new JLabel("联系方式：" + stu.getPhoneNumber());
        } else {
            stuGender = new JLabel("性别：");
            stuPhoneNumber = new JLabel("联系方式：");
            //创建文本框
            JTextField stuGenderField = new JTextField();
            JTextField stuPhoneNumberField = new JTextField();

            stuGenderField.setText(stu.getGender());
            stuPhoneNumberField.setText(stu.getPhoneNumber());

            //文本框窗口设置
            stuGenderField.setBounds(690, 140, 100, 25);
            stuPhoneNumberField.setBounds(360, 140, 100, 25);

            //正则表达式
            String regex = "男|女|保密";

            //创建按钮校验输入是否正确
            JButton jButton = new JButton("确认修改");

            //按钮大小
            jButton.setBounds(400, 500, 100, 25);

            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("确认修改");

                    //获取文本框内容
                    String Gender = stuGenderField.getText();
                    String PhoneNumber = stuPhoneNumberField.getText();

                    System.out.println(Gender.matches(regex));
                    if (Gender.matches(regex)) {
                        //更新数据
                        stu.setGender(Gender);
                        stu.setPhoneNumber(PhoneNumber);

                        showJDialog("更新成功");

                    } else {

                        showJDialog("性别太怪了吧");
                    }
                }
            });

            //文本框添加
            container.add(stuGenderField);
            container.add(stuPhoneNumberField);

            //按钮添加
            container.add(jButton);
        }

        //头像
        JLabel image = new JLabel(new ImageIcon(User.getPhoto()));

        //文本窗口
        stuNumber.setBounds(300, 25, 150, 50);
        stuName.setBounds(500, 25, 150, 50);
        stuAge.setBounds(650, 25, 150, 50);
        stuInstitute.setBounds(300, 75, 150, 50);
        stuSpecialized.setBounds(500, 75, 150, 50);
        stuSquad.setBounds(650, 75, 150, 50);
        stuPhoneNumber.setBounds(300, 125, 150, 50);
        stuPoliticalLandscape.setBounds(500, 125, 150, 50);
        stuGender.setBounds(650, 125, 150, 50);

        //头像窗口
        image.setBounds(25, 25, 240, 300);

        //文本字体调整
        stuNumber.setFont(new Font(null, Font.PLAIN, 13));
        stuName.setFont(new Font(null, Font.PLAIN, 13));
        stuAge.setFont(new Font(null, Font.PLAIN, 13));
        stuGender.setFont(new Font(null, Font.PLAIN, 13));
        stuInstitute.setFont(new Font(null, Font.PLAIN, 13));
        stuSpecialized.setFont(new Font(null, Font.PLAIN, 13));
        stuSquad.setFont(new Font(null, Font.PLAIN, 13));
        stuPhoneNumber.setFont(new Font(null, Font.PLAIN, 13));
        stuPoliticalLandscape.setFont(new Font(null, Font.PLAIN, 13));

        //文本添加
        container.add(stuNumber);
        container.add(stuName);
        container.add(stuAge);
        container.add(stuGender);
        container.add(stuInstitute);
        container.add(stuSpecialized);
        container.add(stuSquad);
        container.add(stuPhoneNumber);
        container.add(stuPoliticalLandscape);

        //头像添加
        container.add(image);

        //组件更新
        ComponentUpdates();
    }

    //容器组件更新
    private void ComponentUpdates() {
        //确保容器的布局是最新的
        container.revalidate();

        //确保容器及其子组件的显示是最新的
        container.repaint();

        //确保滚动面板的布局是最新的
        scrollPane.revalidate();

        //确保滚动面板及其子组件的显示是最新的
        scrollPane.repaint();
    }

    //弹窗
    public static void showJDialog(String content) {
        //弹窗对象
        JDialog jDialog = new JDialog();

        //弹窗里的文字对象
        JLabel jLabel = new JLabel(content);

        //弹窗大小
        jDialog.setSize(175, 100);

        //文字窗口
        jLabel.setSize(150, 50);

        //文字位置  让文本标签居中  设置水平对齐
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //让弹框置顶
        jDialog.setAlwaysOnTop(true);

        //让弹框居中
        jDialog.setLocationRelativeTo(null);

        //取消默认放置
        jDialog.setLayout(null);

        //弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);

        //把文字添加到界面
        jDialog.getContentPane().add(jLabel);

        //弹窗可见
        jDialog.setVisible(true);
    }

}

// 自定义按钮渲染器
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //返回用于绘制单元格的组件。此方法用于在绘制之前适当地配置渲染器
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

// 自定义按钮编辑器
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //该方法用于在表格中编辑单元格的值
        //5个变量作用分别为：
        //table                     调用的列表
        //isSelected                跟踪按钮是否被点击
        //value                     参数表示当前单元格的值。如所定义的选择按钮的text
        //row                       行
        //column                    列
        //使点击的反馈更有趣
        /*if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }*/
        //获取文本
        label = (value == null) ? "" : value.toString();
        //给按钮设置文本
        button.setText(label);
        //点击后
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        //返回编辑器的当前值， 添加了isPushed后可以对进行点击的操作
        //被点击后操作
        if (isPushed) {
            // 在此处添加按钮点击后的操作
            System.out.println("选课成功");
            //弹窗
            InformationScreen.showJDialog("选课成功");
            //获取按钮被点击后所在的行
            int row = table.getSelectedRow();
            //获取该行该列的值
            Object CurriculumName = table.getModel().getValueAt(row, 1);
            //获取学生的值
            HashMap<String, String> hm = InformationScreen.stu.getHm();
            //加入课程
            hm.put((String) CurriculumName, null);
            //给学生重新赋值
            InformationScreen.stu.setHm(hm);
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        //用于停止编辑, 并返回以指示编辑已停止。
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        //用于通知所有已注册的监听器，表示编辑已停止
        super.fireEditingStopped();
    }
}
