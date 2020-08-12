package proxypatten;

import adapter.WebAdapter;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        WebAdapter webAdapter = new WebAdapter();
        Server server = new WebSeverProxy(webAdapter);
        ServerSubject serverSubject = new ServerSubject(server);
        serverSubject.add(new User());


        while (true) {
            System.out.println("請輸入想要查詢的名稱");
            serverSubject.request(input.next());
        }
    }
}
