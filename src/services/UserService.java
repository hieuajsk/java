package services;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Management<User>{

    public static List<User> userList = new ArrayList<>();

    public static User user;

    static {
        initUser();
    }

    private static void initUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("viet");
        user.setPassword("1234");
        user.setRole("Admin");
        userList.add(user);
    }

    @Override
    public User findById(long id) {
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getId() == id){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public void printList() {
        System.out.printf("%-16s%-26s%-26s%n", "Id:", "User Name:", "Role:");
        for (int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i));
        }
    }

    @Override
    public void updateById(long id, User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id){
                if (user.getUserName() != null)
                    userList.get(i).setUserName(user.getUserName());
                if (user.getPassword() != null)
                    userList.get(i).setPassword(user.getPassword());
            }
        }
    }

    @Override
    public void add(User user) {
        user.setId(userList.size() + 1);
        user.setRole("User");
        userList.add(user);
    }

    @Override
    public void delete(long id) {
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getId() == id){
                userList.remove(i);
                break;
            }
        }
    }

    public boolean checkLogin(String username, String password){
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassword().equals(password)){
                user = userList.get(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkId(long idUser){
        for (int i = 1; i < userList.size(); i++) {
            if (userList.get(i).getId() == idUser)
                return true;

        }
        return false;
    }
}
