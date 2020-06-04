package common;

import java.util.Scanner;

/**
 * 从控制台读取输入信息的工具类
 */
public class InfoFromConsole {
    private static final Scanner scanner = new Scanner(System.in);
    public static String getString() {
        return scanner.nextLine();
    }
    public static int getInt() {
        return scanner.nextInt();
    }

}
