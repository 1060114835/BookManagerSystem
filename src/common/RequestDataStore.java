package common;

import domain.Book;
import request.BookRequest;

import java.util.LinkedList;

public class RequestDataStore {

    // 请求存储:必须为static才能实现对象共享
    private static final LinkedList<BookRequest> requestList = new LinkedList<>();

    // 返回图书集合
    public LinkedList<BookRequest> getRequestList() {
        return requestList;
    }
}
