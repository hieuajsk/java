package mainmenu;

import model.Room;
import model.User;
import services.UserService;

import java.util.Scanner;

public class UserMain {

    public static UserService userService = new UserService();

    public static Scanner scanner = new Scanner(System.in);

    public static void login(){
        while (true){
            System.out.println("Tên Đăng Nhập: ");
            String username = scanner.nextLine();
            System.out.println("Mật Khẩu: ");
            String password = scanner.nextLine();
            boolean check = userService.checkLogin(username, password);
            if (check){
                System.out.println("Đăng Nhập Thành Công.");
                System.out.println("Xin Chào" + UserService.user.getUserName());
                try {
                    choiceRoomService();
                    choiceManagement();
                    break;
                } catch (Exception e){
                    choiceRoomService();
                    choiceManagement();
                }
            } else {
                System.out.println("Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng.");
            }
        }
    }

    public static void choiceRoomService() {
        System.out.println("Mời Chọn.");
        System.out.println("1. Quản Lý Phòng.");
        System.out.println("2. Quản Lý Khách Hàng.");
        System.out.println("3. Quay Lại Đăng Nhập.");
        System.out.println("4. Quay Lại Đăng Kí.");
    }

    public static void choiceManagement(){
        Scanner scanner1 = new Scanner(System.in);
        int choice = scanner1.nextInt();
        switch (choice){
            case 1: {
                RoomMain.addNewRoom();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                UserMain.login();
            }
            case 4: {
                UserMain.register();
            }
            case 0: {
                System.exit(0);
            }
            default: {
                System.out.println("Có Lỗi Xảy Ra.");
            }
        }
    }

    public static void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tên Đăng Nhập: ");
        String username = scanner.nextLine();
        System.out.println("Mật Khẩu: ");
        String password = scanner.nextLine();
        User user = new User(username, password);
        userService.add(user);
        userService.printList();
    }
}
