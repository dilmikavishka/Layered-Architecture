package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.DAO.Custome.Impl.itemDaoImpl;
import com.example.layeredarchitecture.DAO.Custome.ItemDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOimpl {
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.getAll();
    }

    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.save(itemDTO);
    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.update(itemDTO);
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.exist(code);
    }

    public String generateId() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.generateId();
    }
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        itemDAO.delete(code);
    }

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.findItem(code);

    }


    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new itemDaoImpl();
        return itemDAO.search(newItemCode);
    }
}
