package com.example.layeredarchitecture.DAO.Custome;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;

public interface ItemDAO extends CrudDAO<ItemDTO> {
 /*   public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException;
    public String generateCode() throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException;*/
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;

   // ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
}
