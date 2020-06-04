package admin;

import java.util.LinkedList;
import java.util.Scanner;

import common.BookDataStore;
import common.InfoFromConsole;
import domain.Book;
import domain.Reader;

/**
 * 图书管理
 */
public class BookManager extends BookDataStore implements IBookManager {


    public void enterBookManager(Scanner in) {
        bookManagerMenu();
        while (true) {
            // 根据输入值进入界面
            int type = in.nextInt();
            switch (type) {
                case 1:
                    //查询
                    getBook();
                    bookManagerMenu();
                    break;
                case 2:
                    //添加
                    addBook();
                    bookManagerMenu();
                    break;
                case 3:
                    //删除
                    removeBook();
                    bookManagerMenu();
                    break;
                case 4:
                    //修改
                    setBook();
                    bookManagerMenu();
                    break;

                case 5:
                    //退出
                    return;
                default:
                    System.out.println("输入错误!");
                    ;
                    bookManagerMenu();
            }
        }
    }

    public void bookManagerMenu() {
        System.out.println("图书信息管理：");
        System.out.println("1-查询");
        System.out.println("2-添加");
        System.out.println("3-删除");
        System.out.println("4-修改");
        System.out.println("5-退出");
        System.out.println("请选择：");
    }


    private void removeBook() {
        System.out.println("请输入要删除的图书名：");
        String bookName = InfoFromConsole.getString();
        for (int i = 0; i < getBookList().size(); i++) {
            if (getBookList().get(i).getName().equals(bookName)) {
                getBookList().remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("删除失败，输入的读者名不存在");
    }

    private void getBook() {
        for (int i = 0; i < getBookList().size(); i++) {
            System.out.println(getBookList().get(i));
        }

    }

    private void setBook() {
        System.out.println("请输入要修改的图书的名：");
        String bookName = InfoFromConsole.getString();
        for (int i = 0; i < getBookList().size(); i++) {
            if (getBookList().get(i).getName().equals(bookName)) {
                System.out.println("查找成功，您将要修改的图书信息为：");
                System.out.println(getBookList().remove(i));
                System.out.println("请重新输入图书信息：");
                Book book = new Book();
                getBookList().add(book);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("输入的读者名不存在");
    }


    @Override
    public void addBook() {
        Book book = new Book();
        getBookList().add(book);
        System.out.println("添加图书成功：该图书的名为：" + book.getName());
    }
}
