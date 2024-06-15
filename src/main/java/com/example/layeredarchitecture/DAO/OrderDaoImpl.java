package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public class OrderDaoImpl {
    public String generateId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        if (rst.next()){
            String oid = rst.getString("oid");
            return oid;
        }
        return null;
    }

    public boolean existId(String orderId) throws SQLException, ClassNotFoundException {
       Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);

        return stm.executeQuery().next();

    }

    public int isSave(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement  stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderDTO.getOrderId());
        stm.setDate(2, Date.valueOf(orderDTO.getOrderDate()));
        stm.setString(3, orderDTO.getCustomerId());

        return stm.executeUpdate();
    }
}
