package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface customerDao {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String generateId() throws SQLException, ClassNotFoundException;

}
