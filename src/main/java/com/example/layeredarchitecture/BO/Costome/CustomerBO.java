package com.example.layeredarchitecture.BO.Costome;

import com.example.layeredarchitecture.BO.SuperBO;
import com.example.layeredarchitecture.DTO.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;


    public String generateIdCustomer() throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer (String newValue) throws SQLException, ClassNotFoundException;
}
