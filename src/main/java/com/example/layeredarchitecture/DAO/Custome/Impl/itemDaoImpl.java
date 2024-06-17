package com.example.layeredarchitecture.DAO.Custome.Impl;

import com.example.layeredarchitecture.DAO.Custome.ItemDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class itemDaoImpl implements ItemDAO {
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        ArrayList<ItemDTO> allItem = new ArrayList<>();
        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));

            allItem.add(itemDTO);

        }
        return allItem;
    }

    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
  /*      Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, itemDTO.getCode());
        pstm.setString(2, itemDTO.getDescription());
        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
        pstm.setInt(4, itemDTO.getQtyOnHand());
        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());


    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
    /*    *//*Update Item*//*
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, itemDTO.getDescription());
        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
        pstm.setInt(3, itemDTO.getQtyOnHand());
        pstm.setString(4, itemDTO.getCode());
        return pstm.executeUpdate()>0;*/

        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());

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

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
        /*PreparedStatement pstm = SQLUtil.execute("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, code);
        ResultSet rst = pstm.executeQuery();*/

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);

        if (rst.next()){
            String desc = rst.getString("description");
            BigDecimal unitPrice = rst.getBigDecimal("unitPrice");
            int qtyOnHand = rst.getInt("qtyOnHand");

           ItemDTO itemDTO = new ItemDTO(code,desc,unitPrice,qtyOnHand);
           return itemDTO;
        }
        return null;
    }


    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
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

            ItemDTO itemDTO = new ItemDTO(newItemCode + "" ,des,unitPrice,qty);
            return itemDTO;
        }
        return null;
    }
}
