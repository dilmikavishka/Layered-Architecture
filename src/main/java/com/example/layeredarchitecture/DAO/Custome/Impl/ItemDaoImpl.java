package com.example.layeredarchitecture.DAO.Custome.Impl;

import com.example.layeredarchitecture.DAO.Custome.ItemDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.entity.Item;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        ArrayList<Item> allItem = new ArrayList<>();
        while (rst.next()) {
            Item item = new Item(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));

            allItem.add(item);

        }
        return allItem;
    }

    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
  /*      Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, itemDTO.getCode());
        pstm.setString(2, itemDTO.getDescription());
        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
        pstm.setInt(4, itemDTO.getQtyOnHand());
        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());


    }

    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
    /*    *//*Update Item*//*
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, itemDTO.getDescription());
        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
        pstm.setInt(3, itemDTO.getQtyOnHand());
        pstm.setString(4, itemDTO.getCode());
        return pstm.executeUpdate()>0;*/

        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand(),entity.getCode());

    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();*/

        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();


    }

    public String generateId() throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("code");
            return id;

        }
        return null;
    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeUpdate()>0;*/

        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);

    }

    public Item findItem(String code) throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
        /*PreparedStatement pstm = SQLUtil.execute("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, code);
        ResultSet rst = pstm.executeQuery();*/

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);

        if (rst.next()){
            String desc = rst.getString("description");
            BigDecimal unitPrice = rst.getBigDecimal("unitPrice");
            int qtyOnHand = rst.getInt("qtyOnHand");

            Item item = new Item(code,desc,unitPrice,qtyOnHand);
           return item;
        }
        return null;
    }


    public Item search(String newItemCode) throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
                 /*   PreparedStatement pstm = SQLUtil.execute("SELECT * FROM Item WHERE code=?");
                    pstm.setString(1, newItemCode + "");
                    ResultSet rst = pstm.executeQuery();*/

                    ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",newItemCode);
                    /*rst.next();
                    return new ItemDTO(newItemCode + "",rst.getString("des"),rst.getBigDecimal("unitPrice"),rst.getInt("qty"));
*/
        while(rst.next()){
            String des = rst.getString("description");
            BigDecimal unitPrice =  rst.getBigDecimal("unitPrice");
            int qty = rst.getInt("qtyOnHand");

            Item item = new Item(newItemCode + "" ,des,unitPrice,qty);
            return item;
        }
        return null;
    }
}
