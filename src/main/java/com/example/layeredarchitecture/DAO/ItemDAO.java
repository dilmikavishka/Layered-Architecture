package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException;
    public String generateCode() throws SQLException, ClassNotFoundException;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
    public ItemDTO findeItemCode(String code) throws SQLException, ClassNotFoundException;
}
