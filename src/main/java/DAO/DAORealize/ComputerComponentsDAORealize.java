package DAO.DAORealize;

import CreateObj.ComputerComponents;
import DAO.DAOFactory;
import DAO.DAOInterface.ComputerComponentsDAO;
import HelpDAO.DAOHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComputerComponentsDAORealize implements ComputerComponentsDAO {

    private static final String GET_COMPUTER_COMPONENTS_BY_NAME= "SELECT * FROM ComputerComponents WHERE computer_components_name = ?";
    private static final String GET_COMPUTER_COMPONENTS_BY_ID= "SELECT * FROM ComputerComponents WHERE ID = ?";
    private static final String GET_ALL_COMPUTER_COMPONENTS = "SELECT * FROM ComputerComponents";
    private static final String GET_ALL_COMPUTER_COMPONENTS_BY_CATEGORY = "SELECT * FROM ComputerComponents WHERE computer_components_category_ID = (SELECT ID FROM Category WHERE category = ?)";
    private static final String GET_CATEGORY_BY_ID = "SELECT category FROM Category WHERE ID = ?";
    private static final String SET_COUNT = "UPDATE ComputerComponents SET computer_components_count = computer_components_count-1 WHERE ID = ?";
    private static final String DELL_COMPUTER_COMPONENTS_BY_ID = "DELETE FROM ComputerComponents WHERE ID = ?";
    private static final String UPDATE_COMPUTER_COMPONENTS = "UPDATE ComputerComponents SET computer_components_category_ID = (SELECT ID FROM Category WHERE category = ?)," +
            "computer_components_name = ?, computer_components_description = ?, computer_components_URL = ?," +
            " computer_components_prise = ?, computer_components_count = ? WHERE ID = ?";


    private static final String ID = "ID";
    private static final String CATEGORY_ID = "computer_components_category_ID";
    private static final String COMP_NAME = "computer_components_name";
    private static final String COMP_DESCRIPTION =  "computer_components_description";
    private static final String COMP_URL =  "computer_components_URL";
    private static final String COMP_PRISE = "computer_components_prise";
    private static final String COMP_COUNT = "computer_components_count";


    @Override
    public ComputerComponents getComputerComponents(String name) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(GET_COMPUTER_COMPONENTS_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return helpToAdd(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return null;
    }

    @Override
    public ComputerComponents getComputerComponentsByID(int id) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(GET_COMPUTER_COMPONENTS_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return helpToAdd(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return null;
    }

    @Override
    public ArrayList<ComputerComponents> getAllComputerComponents() {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ArrayList<ComputerComponents>  componentsArrayList = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(GET_ALL_COMPUTER_COMPONENTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                componentsArrayList.add(helpToAdd(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return componentsArrayList;
    }

    @Override
    public ArrayList<ComputerComponents> getAllComputerComponentsByCategory(String category) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ArrayList<ComputerComponents>  componentsArrayList = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(GET_ALL_COMPUTER_COMPONENTS_BY_CATEGORY);
            preparedStatement.setString(1,category);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                componentsArrayList.add(helpToAdd(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return componentsArrayList;
    }

    @Override
    public String getCategoryByID(int ID) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String category = "";

        try {
            preparedStatement = con.prepareStatement(GET_CATEGORY_BY_ID);
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                category = rs.getString("category");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return category;
    }

    @Override
    public void setCompCount(int ID) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(SET_COUNT);
            preparedStatement.setInt(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setCompComponent(ComputerComponents components, int ID) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(UPDATE_COMPUTER_COMPONENTS);
            preparedStatement.setString(1,components.getComponentCategory());
            preparedStatement.setString(2,components.getComponentName());
            preparedStatement.setString(3,components.getComponentDescription());
            preparedStatement.setString(4,components.getComponentPhotoURL());
            preparedStatement.setBigDecimal(5,components.getComponentPrise());
            preparedStatement.setInt(6,components.getComponentCount());
            preparedStatement.setInt(7,ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
    }

    @Override
    public void deleteCompComponentByID(int ID) {
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement(DELL_COMPUTER_COMPONENTS_BY_ID);
            preparedStatement.setInt(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }

    }

    public ComputerComponents helpToAdd(ResultSet rs) throws SQLException {
        ComputerComponents components = new ComputerComponents();
            int compID = rs.getInt(ID);
            int categoryID = rs.getInt(CATEGORY_ID);
            String compCompName = rs.getString(COMP_NAME);
            String compCategory = getCategoryByID(categoryID);
            String compDescription = rs.getString(COMP_DESCRIPTION);
            String compURL = rs.getString(COMP_URL);
            BigDecimal compPrise = rs.getBigDecimal(COMP_PRISE);
            int compCount = rs.getInt(COMP_COUNT);
            components.setComponentID(compID);
            components.setComponentName(compCompName);
            components.setComponentCategory(compCategory);
            components.setComponentDescription(compDescription);
            components.setComponentPhotoURL(compURL);
            components.setComponentPrise(compPrise);
            components.setComponentCount(compCount);
            return components;
    }
}
