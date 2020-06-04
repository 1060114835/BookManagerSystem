package reader;

import admin.BookManager;
import common.InfoFromConsole;
import domain.Book;
import domain.Reader;
import request.BookRequest;
import request.RequestManger;

import java.util.Scanner;


/**
 * 读者页面的管理工具类
 */
public class ReaderUtil {

    private final BookManager bookManager = new BookManager();

    private final ReaderManger readerManger = new ReaderManger();

    private Reader currentReader;

    private final RequestManger requestManger = new RequestManger();

    //管理员功能
    public void readerMenu() {
        System.out.println("图书读者端：");
        System.out.println("1-查询个人信息");
        System.out.println("2-查询个人借阅情况");
        System.out.println("3-图书借阅申请");
        System.out.println("4-图书归还申请");
        System.out.println("5-退出");
        System.out.println("请选择：");
    }

    public void enterReaderManager(Scanner in) {
        System.out.println("请输入您的姓名和密码：");
        String name = in.next();
        String password = in.next();
        //检查是否在集合中，这里只是举例
        boolean isSuccess = false;
        for (int i = 0; i < readerManger.getReaderList().size(); i++) {
            if (readerManger.getReaderList().get(i).getName().equals(name)
                    && readerManger.getReaderList().get(i).getPassword().equals(password)) {
                System.out.println("登录成功");
                currentReader = readerManger.getReaderList().get(i);
                isSuccess = true;
            }
        }
        if (isSuccess) {
            readerMenu();
            while (true) {
                // 根据输入值进入界面
                int type = in.nextInt();
                switch (type) {
                    case 1:
                        //查询个人信息
                        queryReaderInfo();
                        readerMenu();
                        break;
                    case 2:
                        //查询当前借阅信息
                        queryBorrowInfo();
                        readerMenu();
                        break;
                    case 3:
                        //进入审核图书管理
                        borrowBook();
                        readerMenu();
                        break;
                    case 4:
                        //图书归还申请
                        returnBook();
                        readerMenu();
                        break;
                    case 5:
                        //退出读者客户端
                        return;
                    default:
                        System.out.println("输入错误!");
                        readerMenu();
                }
            }
        } else {
            System.out.println("登录失败，请重试");
        }
    }

    private void queryReaderInfo() {
        System.out.println(currentReader);
    }

    private void queryBorrowInfo() {
        if (currentReader.getCurrentBorrowBooks().size() != 0) {
            System.out.println("您当前的借阅列表");
            for (int i = 0; i < currentReader.getCurrentBorrowBooks().size(); i++) {
                System.out.println(currentReader.getCurrentBorrowBooks().get(i));
            }
        } else {
            System.out.println("您当前没有借阅的图书");
        }
    }

    private void borrowBook() {
        System.out.println("当前图书馆内的图书列表：");
        for (int i = 0; i < bookManager.getBookList().size(); i++) {
            System.out.println(bookManager.getBookList().get(i).getName());
        }
        System.out.println("请输入您要借阅的图书名");
        Book book;
        String name = InfoFromConsole.getString();
        for (int i = 0; i < bookManager.getBookList().size(); i++) {
            if (bookManager.getBookList().get(i).getName().equals(name)) {
                book = bookManager.getBookList().get(i);
                BookRequest request = new BookRequest(book.getName(), book.getId(),
                        BookRequest.RequestType.BORROW, BookRequest.Status.UNCHECK, currentReader);
                requestManger.addRequest(request);
                System.out.println("发起借阅申请成功");
                currentReader.getCurrentBorrowBooks().add(book);
                return;
            }
        }
        System.out.println("发起借阅失败，输入的图书名不存在");
    }

    private void returnBook() {
        if (currentReader.getCurrentBorrowBooks().size() == 0) {
            System.out.println("您没有借阅的图书，无需归还");
            return;
        }
        System.out.println("您当前的借阅名单：");
        for (int i = 0; i < currentReader.getCurrentBorrowBooks().size(); i++) {
            System.out.println(currentReader.getCurrentBorrowBooks().get(i).getName());
        }

        System.out.println("请输入您要归还的图书名");
        Book book;
        String name = InfoFromConsole.getString();
        for (int i = 0; i < bookManager.getBookList().size(); i++) {
            if (bookManager.getBookList().get(i).getName().equals(name)) {
                book = bookManager.getBookList().get(i);
                BookRequest request = new BookRequest(book.getName(), book.getId(),
                        BookRequest.RequestType.RETURN, BookRequest.Status.UNCHECK, currentReader);
                requestManger.addRequest(request);
                System.out.println("发起归还申请成功");
                currentReader.getCurrentBorrowBooks().remove(book);
                return;
            }
        }
        System.out.println("发起归还失败，输入的图书名不存在");
    }
}
