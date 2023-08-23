package App;

import org.w3c.dom.Text;

import javax.lang.model.element.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;

public class LoginScreen extends JFrame implements MouseListener {
    static HashSet<User> allUser = new HashSet<>();
    //static ArrayList<User> allAdministrator = new ArrayList<>();

    static {
        HashMap<String, String> hm1 = new HashMap<>();
        hm1.put("数据结构与算法", "100");
        hm1.put("高等数学", "99");
        hm1.put("大学日语Ⅱ", "88");

        Student stu1 = new Student(
                "计算机学院",
                "软件工程",
                "22215120000",
                "黑夜",
                "软工0班",
                "18",
                "保密",
                "12345678910",
                "群众",
                hm1);
        allUser.add(new User("123", "123456", stu1, "image\\帅.png"));
    }

    static int flag = 0;

    //账号文本
    JLabel userNameLabel = new JLabel("账号");
    //账号文本框
    JTextField userNameTextField = new JTextField();
    //密码文本
    JLabel passwordLabel = new JLabel("密码");
    //密码文本框
    JTextField passwordTextField = new JTextField();
    //登录按钮
    JButton LoginButton = new JButton("登录");
    //注册按钮
    JButton EnrollButton = new JButton("注册");
    //忘记密码按钮
    JButton ForgotPasswordButton = new JButton("忘记密码");
    //存放单选按钮的组
    ButtonGroup ground = new ButtonGroup();
    //用户按钮
    JRadioButton UserRadioButton = new JRadioButton("用户");
    //管理员按钮
    //JRadioButton AdministratorRadioButton = new JRadioButton("管理员");

    public LoginScreen() {
        //初始化界面
        initJFrame();
        //初始化组件
        initView();
        //是否打开界面
        this.setVisible(true);
    }

    private void initJFrame() {
        //定制长宽高
        this.setSize(722, 470);
        //界面标题
        this.setTitle("登录");
        //界面顶置
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //用xy轴加入组件
        this.setLayout(null);
        //关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initView() {
        //文本窗口大小
        userNameLabel.setBounds(235, 100, 150, 36);
        passwordLabel.setBounds(235, 140, 150, 36);

        //添加文本
        this.getContentPane().add(userNameLabel);
        this.getContentPane().add(passwordLabel);

        //文本框大小
        userNameTextField.setBounds(275, 105, 175, 25);
        passwordTextField.setBounds(275, 145, 175, 25);

        //添加文本框
        this.getContentPane().add(userNameTextField);
        this.getContentPane().add(passwordTextField);

        //按钮大小
        LoginButton.setBounds(280, 185, 60, 25);
        EnrollButton.setBounds(380, 185, 60, 25);
        ForgotPasswordButton.setBounds(315, 250, 100, 20);
        UserRadioButton.setBounds(280, 225, 50, 25);
        //AdministratorRadioButton.setBounds(375, 225, 70, 25);

        //按钮设置透明
        ForgotPasswordButton.setContentAreaFilled(false);
        //按钮去除边框
        ForgotPasswordButton.setBorderPainted(false);

        //单选按钮设置为透明
        UserRadioButton.setOpaque(false);
        //AdministratorRadioButton.setOpaque(false);

        //将单选按钮加入组中
        ground.add(UserRadioButton);
        //ground.add(AdministratorRadioButton);

        //增加鼠标监听
        LoginButton.addMouseListener(this);
        UserRadioButton.addMouseListener(this);
        EnrollButton.addMouseListener(this);
        //AdministratorRadioButton.addMouseListener(this);
        ForgotPasswordButton.addMouseListener(this);

        //添加按钮
        this.getContentPane().add(LoginButton);
        this.getContentPane().add(EnrollButton);
        this.getContentPane().add(ForgotPasswordButton);
        this.getContentPane().add(UserRadioButton);
        //this.getContentPane().add(AdministratorRadioButton);

        //背景图片设置
        JLabel background = new JLabel(new ImageIcon("image\\Longin.png"));

        //设置窗口大小
        background.setBounds(0, 0, 722, 434);

        //把背景图片添加到界面当中
        this.getContentPane().add(background);
    }

    //登录查找用户数据
    public static User contains(HashSet<User> all, String UserName, String PassWord) {
        for (User user : all) {
            if (user.getName().equals(UserName) && user.getPassword().equals(PassWord)) {
                return user;
            }
        }
        return null;
    }
    //用弹窗报告
    private void showJDialog(String content) {
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

    private void ForgotPasswordButtonJDialog() {
        //弹窗对象
        JDialog jDialog = new JDialog();

        //弹窗大小
        jDialog.setSize(350, 400);

        //文本
        JLabel userNameLabel = new JLabel("账号");
        JLabel passwordLabel = new JLabel("请输入密码");
        JLabel againPasswordLabel  = new JLabel("再次输入密码");

        //文本框
        JTextField userNameTextField = new JTextField();
        JTextField passwordTextField = new JTextField();
        JTextField againPasswordTextField = new JTextField();

        //重置按钮
        JButton reset = new JButton("重置");

        //文本窗口大小
        userNameLabel.setBounds(45, 75, 150, 36);
        passwordLabel.setBounds(30, 115, 150, 36);
        againPasswordLabel.setBounds(25, 155, 150, 36);

        //文本框大小
        userNameTextField.setBounds(120,80, 175,25);
        passwordTextField.setBounds(120, 120, 175, 25);
        againPasswordTextField.setBounds(120,160, 175, 25);

        //按钮窗口
        reset.setBounds(125, 200, 100, 25);

        //把文字添加到界面
        jDialog.getContentPane().add(userNameLabel);
        jDialog.getContentPane().add(passwordLabel);
        jDialog.getContentPane().add(againPasswordLabel);

        //把文本框添加到界面
        jDialog.getContentPane().add(userNameTextField);
        jDialog.getContentPane().add(passwordTextField);
        jDialog.getContentPane().add(againPasswordTextField);

        //添加按钮
        jDialog.getContentPane().add(reset);

        //增加鼠标监听
        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String userName = userNameTextField.getText();
                String password = passwordTextField.getText();
                String againPassword = againPasswordTextField.getText();
                if (userName.length() == 0 && password.length() == 0 && againPassword.length() == 0) {

                    showJDialog("账号或密码不能为空");
                }
                else if (!password.equals(againPassword)) {

                    showJDialog("两次密码不一致");
                } else {
                    //获取对象
                    User user =  EnrollScreen.contains(allUser, userName);
                    if (user == null) {

                        showJDialog("账号不存在");
                    } else {
                        //修改密码
                        user.setPassword(password);

                        for (User user1 : allUser) {
                            System.out.println(user1);
                        }

                        //关闭弹窗
                        showJDialog("修改成功");

                        jDialog.setVisible(false);
                    }
                }
            }
        });

        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //取消默认放置
        jDialog.setLayout(null);
        //弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        //弹窗可见
        jDialog.setVisible(true);
    }

    //鼠标点击
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == UserRadioButton) {

            System.out.println("用户登录");
            flag = 1;

        } /*else if (e.getSource() == AdministratorRadioButton) {

            System.out.println("管理员登录");
            flag = 2;

        }*/ else if (e.getSource() == ForgotPasswordButton) {

            System.out.println("忘记密码");

            ForgotPasswordButtonJDialog();

        } else if (e.getSource() == LoginButton) {
            System.out.println("登录");

            //获取文本框内容
            String UserName = userNameTextField.getText();
            String PassWord = passwordTextField.getText();

            if (UserName.length() == 0 || PassWord.length() == 0) {//判断账号或密是否为空

                System.out.println("账号或密码不能为空");
                showJDialog("账号或密码不能为空");

            } else if (flag == 0) {

                System.out.println("未选择登录方式");
                showJDialog("请选择登录方式");

            } else if (flag == 1) {//判断账号密码是否正确

                User user = contains(allUser, UserName, PassWord);

                if (user != null) {

                    System.out.println("登录成功");

                    //关闭登录界面
                    this.setVisible(false);

                    //打开使用界面
                    new InformationScreen(user);
                } else {
                    System.out.println("账号或密码错误");

                    //弹窗
                    showJDialog("账号或密码错误");
                }
            }
        } else if (e.getSource().equals(EnrollButton)) {

            System.out.println("注册");

            //关闭当前界面
            this.setVisible(false);
            //打开注册界面
            new EnrollScreen();

        }/*else if (flag == 2 && contains(allAdministrator, userInfo)) {

                System.out.println("登录成功");
                //关闭登录界面
                this.setVisible(false);

            } else {

                System.out.println("账号或密码错误");
                showJDialog("账号或密码错误");

            }*/
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
