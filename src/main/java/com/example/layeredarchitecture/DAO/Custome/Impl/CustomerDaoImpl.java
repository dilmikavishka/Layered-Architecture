package com.example.layeredarchitecture.DAO.Custome.Impl;

import com.example.layeredarchitecture.DAO.Custome.CustomerDao;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()){
            Customer customer = new Customer(
                            rst.getString("id"),
                            rst.getString("name"),
                            rst.getString("address"));
            allCustomers.add(customer);
        }

        return allCustomers;
    }

    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, customerDTO.getId());
        pstm.setString(2, customerDTO.getName());
        pstm.setString(3, customerDTO.getAddress());
        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",entity.getId(),entity.getName(),entity.getAddress());


    }

    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
     /*   Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, customerDTO.getName());
        pstm.setString(2, customerDTO.getAddress());
        pstm.setString(3, customerDTO.getId());
       return pstm.executeUpdate()>0;*/

        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",entity.getName(),entity.getAddress(),entity.getId());

    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();*/

        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);

        return rst.next();

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
       return pstm.executeUpdate()>0;*/

        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    public String generateId() throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("id");
            return id;
        }
        return null;
    }


    public Customer search (String newValue) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, newValue + "");
        ResultSet rst = pstm.executeQuery();*/

      ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);

        while(rst.next()){
            String name = rst.getString("name");
            String address = rst.getString("address");

            Customer customer = new Customer(newValue + "" ,name,address);
            return customer;
        }
        return null;
    }

}
