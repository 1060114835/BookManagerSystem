package common;

import java.util.LinkedList;

import domain.Reader;

public class ReaderDataStore {
	// 读者存储：必须为static才能实现对象共享
	private static final LinkedList<Reader> readerList = new LinkedList<Reader>();

	// 返回读者集合
	public LinkedList<Reader> getReaderList() {
		return readerList;
	}

}
