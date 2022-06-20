package DAO.DAOInterface;

import CreateObj.User;

import java.util.ArrayList;

public interface UserDAO {
    User getUser(String userName);
    User findUserByUsernameAndPassword(String userName, String userPassword);
    ArrayList<User> getAllUsers();
    void AddUser(String userName,String userPassword,String userEmail,String userPhone,String userStatus);
    void dellUser(int id);
    String getUserStatus(int id);
    boolean findInDB(String userName,String userPassword);
    void updatePassword(String password, int id);
    void updateAge(int age,int id);
    void updateSex(String userSex, int id);
    String getUserSex(int id);
    void makeAnAdministrator(int id);
}
