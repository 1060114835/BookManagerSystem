package admin;

import reader.ReaderManger;
import reader.ReaderUtil;
import request.CheckUtil;

import java.util.Scanner;

public class AdminUtil {

    private BookManager bookManager;

    private ReaderManger readerManger = new ReaderManger();

    private CheckUtil checkUtil = new CheckUtil();

    public AdminUtil() {
        bookManager = new BookManager();
    }

    //管理员功能
    public void adminMenu() {
        System.out.println("图书管理员端：");
        System.out.println("1-读者信息管理");
        System.out.println("2-图书信息管理");
        System.out.println("3-审核图书管理");
        System.out.println("4-退出图书管理员端");
        System.out.println("请选择：");
    }

    public void enterAdmin(Scanner in) {
        System.out.println("请输入用户名和密码：");
        String name = in.next();
        String password = in.next();
        //检查是否在集合中，这里只是举例
        if (name.equals("admin") && password.equals("123456")) {
            adminMenu();
            while (true) {
                // 根据输入值进入界面
                int type = in.nextInt();
                switch (type) {
                    case 1:
                        //进入读者信息管理
                        readerManger.enterReaderManager(in);
                        adminMenu();
                        break;
                    case 2:
                        //进入图书信息管理
                        bookManager.enterBookManager(in);
                        adminMenu();
                        break;
                    case 3:
                        //进入审核图书管理
                        checkUtil.enterCheck(in);
                        adminMenu();
                        break;
                    case 4:
                        //退出图书管理员端
                        return;
                    default:
                        System.out.println("输入错误!");
                        adminMenu();
                }
            }
        } else {
            System.out.println("输入账号或密码错误，请重试");
        }
    }


}
