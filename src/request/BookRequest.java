package request;

import java.util.LinkedList;

import common.BookDataStore;
import domain.Book;
import domain.Reader;
import reader.IBookRequest;
import sun.misc.Request;


/**
 * 图书的请求类,包含对图书的一个请求：借阅或还书的基本信息
 */
public class BookRequest extends BookDataStore implements IBookRequest {
    public enum RequestType {BORROW, RETURN}

    public enum Status {CHECK, UNCHECK}

    private static int index = 2222;
    //请求编号
    private final int id;
    //请求的图书名字
    private final String name;
    //请求的图书编号
    private final int bookId;
    //当次请求的类型
    private RequestType type;
    //请求的状态：审核或未审核
    private Status status;
    //发起这次请求的读者
    private Reader reader;

    public BookRequest(String name, int bookId, RequestType type, Status status, Reader reader) {
        this.id = index;
        this.name = name;
        this.bookId = bookId;
        this.type = type;
        this.status = status;
        this.reader = reader;
        index++;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public static int getIndex() {
        return index;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBookId() {
        return bookId;
    }

    public RequestType getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public Reader getReader() {
        return reader;
    }

    public void borrowRequest() {
        LinkedList<Book> bookList = getBookList();
        System.out.println(bookList.size());

    }

    @Override
    public void returnRequest(Book book) {

    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookId=" + bookId +
                ", type=" + type +
                ", status=" + status +
                ", reader=" + reader +
                '}';
    }
}
