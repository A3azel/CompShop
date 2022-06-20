package DAO.DAOInterface;

import CreateObj.ComputerComponents;

import java.util.ArrayList;

public interface ComputerComponentsDAO {
    ComputerComponents getComputerComponents(String name);
    ComputerComponents getComputerComponentsByID(int id);
    ArrayList<ComputerComponents> getAllComputerComponents();
    ArrayList<ComputerComponents> getAllComputerComponentsByCategory(String category);
    String getCategoryByID(int ID);
    void setCompCount(int ID);
    void setCompComponent(ComputerComponents components, int ID);
    void deleteCompComponentByID(int ID);
}
