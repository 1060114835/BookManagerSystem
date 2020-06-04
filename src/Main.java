import java.util.Scanner;

import admin.AdminUtil;
import reader.ReaderUtil;

public class Main {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AdminUtil adminUtil = new AdminUtil();
		ReaderUtil readerUtil = new ReaderUtil();
		
		// 展示主界面
		menu();
		
		while (true) {
			// 根据输入值进入界面
			int type = in.nextInt();
			switch (type) {
			case 1:
				//进入管理员端
				adminUtil.enterAdmin(in);
				menu();
				break;
			case 2:
				//进入读者端
				readerUtil.enterReaderManager(in);
				System.out.println("读者");
				menu();
				break;
			case 3:
				System.out.println("欢迎再次使用");
				return;
			default:
				System.out.println("输入错误");
				menu();
				
			}
		}
	}
	public static void menu(){
		System.out.println("欢迎使用校园图书管理系统");
		System.out.println("请根据输入类型进行登录：");
		System.out.println("1-管理员");
		System.out.println("2-读者");
		System.out.println("3-退出");
		System.out.println("请选择：");
	}
	
}
