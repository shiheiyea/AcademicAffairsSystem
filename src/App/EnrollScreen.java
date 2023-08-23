package App;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class EnrollScreen extends JFrame implements MouseListener {
    //所有学生数据
    static TreeSet<Student> allStudentAlreadyRegistered = new TreeSet<>((o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));
    static TreeSet<Student> allStudentNotRegistered = new TreeSet<>((o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));

    static {
        HashSet<User> allUser = LoginScreen.allUser;
        for (User user : allUser) {
            allStudentAlreadyRegistered.add(user.getStu());
        }
        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("大学物理", "60");
        hm2.put("高等数学", "60");
        hm2.put("大学日语Ⅱ", "88");
        Student stu2 = new Student(
                "计算机学院",
                "软件工程",
                "22215120001",
                "白鸽",
                "软工0班",
                "19",
                "保密",
                "987654321",
                "团员",
                hm2);
        allStudentNotRegistered.add(stu2);
    }
    //账号文本
    JLabel userNameLabel = new JLabel("账号");
    //账号文本框
    JTextField userNameTextField = new JTextField();
    //密码文本
    JLabel passwordLabel = new JLabel("密码");
    //密码文本框
    JTextField passwordTextField = new JTextField();
    //再次输入密码文本
    JLabel againPasswordLabel = new JLabel("再次输入密码");
    //再次输入密码文本框
    JTextField againPasswordTextField = new JTextField();
    //学号文本
    JLabel stuLabel = new JLabel("学号");
    //学号文本框
    JTextField stuTextField = new JTextField();
    //确定按钮
    JButton jButton = new JButton("确定");
    public EnrollScreen() {
        //初始化界面
        initJFame();
        //组件初始化
        initView();
    }

    private void initView() {
        //文本窗口大小
        userNameLabel.setBounds(50, 75, 150, 36);
        passwordLabel.setBounds(50, 115, 150, 36);
        againPasswordLabel.setBounds(25, 155, 150, 36);
        stuLabel.setBounds(50, 195, 150, 36);

        //添加文本
        this.getContentPane().add(userNameLabel);
        this.getContentPane().add(passwordLabel);
        this.getContentPane().add(againPasswordLabel);
        this.getContentPane().add(stuLabel);
        this.getContentPane().add(passwordLabel);

        //文本框大小
        userNameTextField.setBounds(120, 80, 175, 25);
        passwordTextField.setBounds(120, 120, 175, 25);
        againPasswordTextField.setBounds(120,160, 175, 25);
        stuTextField.setBounds(120,200, 175, 25);

        //添加文本框
        this.getContentPane().add(userNameTextField);
        this.getContentPane().add(passwordTextField);
        this.getContentPane().add(stuTextField);
        this.getContentPane().add(againPasswordTextField);

        //按钮窗口
        jButton.setBounds(125, 300, 100, 25);

        //增加鼠标监听
        jButton.addMouseListener(this);

        //添加按钮
        this.getContentPane().add(jButton);
    }

    private void initJFame() {
        //定制长宽高
        this.setSize(350, 500);
        //界面标题
        this.setTitle("注册");
        //界面顶置
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //用xy轴加入组件
        this.setLayout(null);
        //关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //打开界面
        this.setVisible(true);
    }

    public static User contains(HashSet<User> all, String UserName) {
        for (User user : all) {
            if (user.getName().equals(UserName)) {
                return user;
            }
        }
        return null;
    }

    public static Student contains(TreeSet<Student> all, String stuNumber) {
        for (Student stu : all) {
            if (stu.getNumber().equals(stuNumber)) {
                return stu;
            }
        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(jButton)) {
            System.out.println("确定");
            //获取文本框文本
            String userName = userNameTextField.getText();
            String password = passwordTextField.getText();
            String againPassword = againPasswordTextField.getText();
            String stuNumber = stuTextField.getText();

            System.out.println(password);
            System.out.println(againPassword);

            if (contains(LoginScreen.allUser, userName) != null) {

                InformationScreen.showJDialog("该用户名不可用");
            }
            else if (!againPassword.equals(password)) {

                //调用informationScreen的窗口
                InformationScreen.showJDialog("两次密码不一致");

            } else if (contains(allStudentAlreadyRegistered,stuNumber) != null) {

                InformationScreen.showJDialog("该学号已被注册");

            }else {
                Student student = contains(allStudentNotRegistered,stuNumber);
                if (student == null) {

                    InformationScreen.showJDialog("学号不存在");

                } else {

                    //注册成功
                    System.out.println("注册成功");
                    //添加用户
                    LoginScreen.allUser.add(new User(userName, password, student , null));
                    //注册添加
                    allStudentAlreadyRegistered.add(student);
                    //未注册删除
                    allStudentNotRegistered.remove(student);
                    //
                    InformationScreen.showJDialog("注册成功");
                    //关闭当前界面
                    this.setVisible(false);
                    //打开登录界面
                    new LoginScreen();
                }
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}