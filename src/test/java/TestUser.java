import CreateObj.User;
import DAO.DAOFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestUser {
    User user = new User();
    DAOFactory daoFactory = DAOFactory.getInstance();
    @BeforeEach
    public void fillUser(){
        user.setUserName("TestUser");
        user.setUserPassword("123456iuytre");
        user.setUserSex("man");
        user.setUserPhone("53463524");
        user.setUserEmail("ewreht@2FEH");
    }
     @Test
    public void testingAddUserToDB(){
         List<User> beforeAdding = daoFactory.getUserDAORealize().getAllUsers();
         daoFactory.getUserDAORealize().AddUser(user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserPhone(), user.getUserSex());
         List<User> afterAdding = daoFactory.getUserDAORealize().getAllUsers();
         Assertions.assertEquals(beforeAdding.size()+1,afterAdding.size());
     }

     @Test
     public void testingDellUser(){
         List<User> beforeAdding = daoFactory.getUserDAORealize().getAllUsers();
         System.out.println(daoFactory.getUserDAORealize().findUserByUsernameAndPassword("TestUser","123456iuytre"));
         daoFactory.getUserDAORealize().dellUser(daoFactory.getUserDAORealize().findUserByUsernameAndPassword("TestUser","123456iuytre").getUserID());
         List<User> afterAdding = daoFactory.getUserDAORealize().getAllUsers();
         Assertions.assertEquals(beforeAdding.size()-1,afterAdding.size());
     }

}
