package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.DAO.Custome.Impl.customerDaoImpl;
import com.example.layeredarchitecture.DAO.Custome.customerDao;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.getAll();

    }

    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.save(customerDTO);
    }

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.update(customerDTO);
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.exist(id);
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.delete(id);
    }


    public String generateId() throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.generateId();

    }


    public CustomerDTO search (String newValue) throws SQLException, ClassNotFoundException {
        customerDao customerDao = new customerDaoImpl();
        return customerDao.search(newValue);
}

}
