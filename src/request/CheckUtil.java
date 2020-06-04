package request;

import common.InfoFromConsole;
import sun.misc.Request;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CheckUtil {

    private RequestManger requestManger = new RequestManger();

    //管理员功能
    public void checkMenu() {
        System.out.println(" 审核图书管理：");
        System.out.println("1-当前申请列表");
        System.out.println("3-审核图书管理");
        System.out.println("3-退出审核图书管理");
        System.out.println("请选择：");
    }

    public void enterCheck(Scanner in) {
        checkMenu();
        while (true) {
            // 根据输入值进入界面
            int type = in.nextInt();
            switch (type) {
                case 1:
                    //当前申请列表
                    queryApplyList();
                    checkMenu();
                    break;
                case 2:
                    //审核图书管理
                    checkRequest();
                    checkMenu();
                    break;
                case 3:
                    //退出
                    return;
                default:
                    System.out.println("输入错误!");
                    checkMenu();
            }
        }
    }

    private void queryApplyList() {
        if (requestManger.getRequestList().size() == 0)
            System.out.println("当前请求列表为空");
        for (int i = 0; i < requestManger.getRequestList().size(); i++) {
            System.out.println(requestManger.getRequestList().get(i));
        }
    }

    private void checkRequest() {
        System.out.println("请输入请求编号");
        int id = InfoFromConsole.getInt();
        BookRequest currentRequest = null;
        for (int i = 0; i < requestManger.getRequestList().size(); i++) {
            if (requestManger.getRequestList().get(i).getId() == id) {
                currentRequest = requestManger.getRequestList().get(i);
            }
        }

        if (currentRequest == null) {
            System.out.println("输入的编号不存在，请重试：");
            return;
        }

        currentRequest.setStatus(BookRequest.Status.CHECK);

        //开启一个线程来监听当前图书是否超时
        if (currentRequest.getType().equals(BookRequest.RequestType.BORROW)) {
            System.out.println("请输入当前图书的还书时间，单位：ms");
            long s = InfoFromConsole.getInt();

            BookRequest finalCurrentRequest = currentRequest;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(finalCurrentRequest.getName() + "已超时");
                }
            }, s);
        }
        System.out.println("核查成功");

    }

}
