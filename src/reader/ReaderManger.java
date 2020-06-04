package reader;

import common.InfoFromConsole;
import common.ReaderDataStore;
import domain.Reader;

import java.util.Scanner;


/**
 * 操作读者信息操作的增删改查
 */
public class ReaderManger extends ReaderDataStore {

    public void enterReaderManager(Scanner in) {
        showMenu();
        while (true) {
            // 根据输入值进入界面
            int type = in.nextInt();
            switch (type) {
                case 1:
                    //添加读者信息
                    addReader();
                    showMenu();
                    break;
                case 2:
                    //删除读者信息
                    removeReader();
                    showMenu();
                    break;
                case 3:
                    //查询读者信息
                    getReader();
                    showMenu();
                    break;
                case 4:
                    //修改读者信息
                    setReader();
                    showMenu();
                    break;
                case 5:
                    //退出读者信息管理
                    return;
                default:
                    System.out.println("输入错误!");
                    showMenu();
            }
        }
    }

    private void showMenu() {
        System.out.println("读者信息管理");
        System.out.println("1-添加读者信息");
        System.out.println("2-删除读者信息");
        System.out.println("3-查询读者信息");
        System.out.println("4-修改读者信息");
        System.out.println("5-退出读者信息管理");
        System.out.println("请选择：");
    }

    private void addReader() {
        Reader reader = new Reader();
        getReaderList().add(reader);
        System.out.println("添加读者成功：该读者的姓名为：" + reader.getName());
    }

    private void removeReader() {
        System.out.println("请输入要删除的读者姓名：");
        String readerName = InfoFromConsole.getString();
        for (int i = 0; i < getReaderList().size(); i++) {
            if (getReaderList().get(i).getName().equals(readerName)) {
                getReaderList().remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("删除失败，输入的读者姓名不存在");
    }

    private void getReader() {
        System.out.println("请输入要查询的读者姓名：");
        String readerName = InfoFromConsole.getString();
        for (int i = 0; i < getReaderList().size(); i++) {
            if (getReaderList().get(i).getName().equals(readerName)) {
                System.out.println("查找成功，查询的读者信息为：");
                System.out.println(getReaderList().get(i));
                return;
            }
        }
        System.out.println("查找失败，输入的读者姓名不存在");
    }

    private void setReader() {
        System.out.println("请输入要修改的读者信息的姓名：");
        String readerName = InfoFromConsole.getString();
        for (int i = 0; i < getReaderList().size(); i++) {
            if (getReaderList().get(i).getName().equals(readerName)) {
                System.out.println("查找成功，您将要修改的读者信息为：");
                System.out.println(getReaderList().remove(i));
                System.out.println("请重新输入读者信息：");
                Reader reader = new Reader();
                getReaderList().add(reader);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("输入的读者姓名不存在");
    }

}
