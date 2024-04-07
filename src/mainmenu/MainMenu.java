package mainmenu;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Đăng Nhập.");
            System.out.println("2. Đăng Ký.");
            System.out.println("0. Thoát Chương Trình.");
            switch (scanner.nextInt()){
                case 1: {
                    UserMain.login();
                    break;
                }
                case 2: {
                    UserMain.register();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Mời Nhập Lại.");
                }
            }
        }
    }
}
