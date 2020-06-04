package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * 读者实体类，定义了读者的基本属性
 */
public class Reader {
    private String name;

    private String age;

    private String male;
    //密码
    private String password;

    private List<Book> currentBorrowBooks = new ArrayList<>();

    public Reader(String name, String age, String male, String password) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.password = password;
    }

    /**
     * 通过键盘输入的信息构造一个Reader对象
     */
    public Reader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入读者信息：姓名、年龄、性别、密码，输入一条信息摁一下回车");
        name = scanner.nextLine();
        age = scanner.nextLine();
        male = scanner.nextLine();
        password = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String isMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getCurrentBorrowBooks() {
        return currentBorrowBooks;
    }

    public String getMale() {
        return male;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male=" + male +
                ", password=" + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return name.equals(reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
