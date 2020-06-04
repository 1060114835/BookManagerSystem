package domain;


import common.InfoFromConsole;

import java.util.Objects;

/**
 * 图书实体类，定义图书存储数据
 */
public class Book {
    //图书名
    private final String name;
    //图书编号，设置图书编号为自增
    private static int index = 100001;
    private final int id;
    //图书价格，单位：分
    private final String price;
    //是否借阅
    private boolean onLoan;
    //还书时间，格式：“2019-2-2”
    private String returnBookTime;
    //读者
    private Reader reader;

    public Book(String name, String price) {
        this.name = name;
        this.price = price;
        id = index;
        index++;
    }

    public Book(){
        System.out.println("请依次输入图书的名字和价钱，输入一条信息摁一下回车：");
        name = InfoFromConsole.getString();
        price = InfoFromConsole.getString();
        id = index;
        index++;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public static int getIndex() {
        return index;
    }

    public int getId() {
        return id;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public String getReturnBookTime() {
        return returnBookTime;
    }

    public Reader getReader() {
        return reader;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public void setReturnBookTime(String returnBookTime) {
        this.returnBookTime = returnBookTime;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price='" + price + '\'' +
                '}';
    }
}
