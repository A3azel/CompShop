package DAO.DAORealize;

import CreateObj.User;
import DAO.DAOFactory;
import DAO.DAOInterface.UserDAO;
import HelpDAO.DAOHelper;

import java.sql.*;
import java.util.ArrayList;

public class UserDAORealize implements UserDAO {
    public UserDAORealize(){

    }

    public static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM USERData WHERE user_name = ? AND user_password = ?";
    public static final String GET_ALL_USERS = " SELECT * FROM USERData";
    public static final String GET_USER = "SELECT * FROM USERData WHERE user_name = ?";
    public static final String ADD_USER = "INSERT INTO USERData(user_name,user_password,user_email,user_phone,user_sex_ID, user_status_ID) VALUES(?,?,?,?,(SELECT ID FROM UserSex WHERE user_sex = ?),(SELECT ID FROM UserStatus WHERE user_status = ?))";
    public static final String DELL_USER = "DELETE FROM USERData WHERE ID = ?";
    public static final String GET_USER_STATUS = "SELECT user_status FROM UserStatus WHERE ID = ?";
    //public static final String GET_USER_STATUS = "SELECT user_status FROM UserStatus AS A WHERE ID IN(SELECT user_status_ID FROM  USERData AS A1 WHERE A.ID = A1.user_status_ID) HAVING user_status_ID = ?";
    public static final String GET_USER_SEX = "SELECT user_sex FROM UserSex WHERE ID = ?";
    // ! public static final String FIND_BY_EMAIL= "SELECT * FROM USERData WHERE user_email = ?";
   // public static final String GET_USER_ID = "SELECT ID FROM USERData WHERE user_name = ?";
    public static final String MAKE_AN_ADMIN = "UPDATE USERData SET user_status_ID = 2 where ID = ?";

    public static final String UPDATE_PASSWORD ="UPDATE USERData SET user_password = ? where ID = ?";
    public static final String UPDATE_AGE = "UPDATE USERData SET user_age = ? where ID = ?";
    public static final String UPDATE_SEX = "UPDATE USERData SET user_sex_ID = (SELECT ID FROM UserSex WHERE user_sex = ?) where ID = ?";
    //public static final String UPDATE_AGE_AND_SEX = "UPDATE USERData SET user_age = ?, user_sex_ID = ? where ID = ?";

    public static final String FIELD_ID = "ID";
    public static final String FIELD_USERNAME = "user_name";
    public static final String FIELD_PASSWORD= "user_password";
    public static final String FIELD_EMAIL = "user_email";
    public static final String FIELD_PHONE = "user_phone";
    public static final String FIELD_AGE = "user_age";
    public static final String FIELD_SEX_ID = "user_sex_ID";
    public static final String FIELD_STATUS_ID = "user_status_ID";
    public static final String FIELD_SEX = "user_sex";
    public static final String FIELD_STATUS = "user_status";


    public User getUser(String userName){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        User user = new User();
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            preparedStatement = con.prepareStatement(GET_USER);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int userID = resultSet.getInt(FIELD_ID);
                String userEmail = resultSet.getString(FIELD_EMAIL);
                String userPhone = resultSet.getString(FIELD_PHONE);
                String userPassword = resultSet.getString(FIELD_PASSWORD);
                int statusID = resultSet.getInt(FIELD_STATUS_ID);
                int userSexID = resultSet.getInt(FIELD_SEX_ID);
                String userStatus = getUserStatus(statusID);
                int age = resultSet.getInt(FIELD_AGE);
                String userSex = getUserSex(userSexID);

                user.setUserID(userID);
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setUserEmail(userEmail);
                user.setUserPhone(userPhone);
                user.setUserStatus(userStatus);
                user.setUserAge(age);
                user.setUserSex(userSex);

                return user;
            }
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            DAOHelper.rollback(con);
        }finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return null;
    }

    @Override
    public User findUserByUsernameAndPassword(String userName,String userPassword){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            preparedStatement = con.prepareStatement(FIND_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = new User();
                int userID = resultSet.getInt(FIELD_ID);
                String userEmail = resultSet.getString(FIELD_EMAIL);
                String userPhone = resultSet.getString(FIELD_PHONE);
                String userStatus = getUserStatus(userID);
                int age = resultSet.getInt(FIELD_AGE);
                String userSex = getUserSex(userID);

                user.setUserID(userID);
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setUserEmail(userEmail);
                user.setUserPhone(userPhone);
                user.setUserStatus(userStatus);
                user.setUserAge(age);
                user.setUserSex(userSex);
                return user;
            }
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            DAOHelper.rollback(con);
        }finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return user;
    }

    @Override
    public ArrayList<User> getAllUsers(){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ArrayList<User> userArrayList= new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(GET_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                int userID = rs.getInt(FIELD_ID);
                int statusID = rs.getInt(FIELD_STATUS_ID);
                int userSexID = rs.getInt(FIELD_SEX_ID);
                String userName = rs.getString(FIELD_USERNAME);
                String userPassword = rs.getString(FIELD_PASSWORD);
                String userEmail = rs.getString(FIELD_EMAIL);
                String userPhone = rs.getString(FIELD_PHONE);
                String userStatus = getUserStatus(statusID);
                int age = rs.getInt(FIELD_AGE);
                String userSex = getUserSex(userSexID);

                user.setUserID(userID);
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setUserEmail(userEmail);
                user.setUserPhone(userPhone);
                user.setUserStatus(userStatus);
                user.setUserAge(age);
                user.setUserSex(userSex);
                userArrayList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return userArrayList;
    }

    @Override
    public void AddUser(String userName,String userPassword,String userEmail,String userPhone,String userSex){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(ADD_USER);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            preparedStatement.setString(3,userEmail);
            preparedStatement.setString(4,userPhone);
            preparedStatement.setString(5,userSex);
            preparedStatement.setString(6,"user");

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
    }

    @Override
    public void dellUser(int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(DELL_USER);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }

    }

    @Override
    public String getUserStatus(int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String status = "";

        try {
            preparedStatement = con.prepareStatement(GET_USER_STATUS);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                status = resultSet.getString(FIELD_STATUS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return status;
    }

    @Override
    public String getUserSex(int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String userSex = "";

        try {
            preparedStatement = con.prepareStatement(GET_USER_SEX);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                userSex = resultSet.getString(FIELD_SEX);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return userSex;
    }

    @Override
    public void makeAnAdministrator(int id) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(MAKE_AN_ADMIN);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
    }

    @Override
    public boolean findInDB(String userName,String userPassword){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        boolean result = false;

        try {
            preparedStatement = con.prepareStatement(FIND_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return result;

    }


////////////////////////////////////////////////////////////////////////

    @Override
    public void updatePassword(String password, int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(UPDATE_PASSWORD);
            preparedStatement.setString(1,password);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
    }

    @Override
    public void updateAge(int age,int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(UPDATE_AGE);
            preparedStatement.setInt(1,age);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }

    }

    @Override
    public void updateSex(String userSex, int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(UPDATE_SEX);
            preparedStatement.setString(1,userSex);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }

    }


    ////////////////////////////////////////////////////////////////////////






}
