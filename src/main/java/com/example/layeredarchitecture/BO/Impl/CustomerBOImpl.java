package com.example.layeredarchitecture.BO.Impl;

import com.example.layeredarchitecture.BO.Costome.CustomerBO;
import com.example.layeredarchitecture.DAO.Custome.CustomerDao;
import com.example.layeredarchitecture.DAO.Custome.Impl.CustomerDaoImpl;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.DTO.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDao customerDao = (CustomerDaoImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDao.getAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers){
          CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

          customerDTOS.add(customerDTO);
        }
        return customerDTOS;

    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDao.save(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()));
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()));
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }


    public String generateIdCustomer() throws SQLException, ClassNotFoundException {
        return customerDao.generateId();

    }


    public CustomerDTO searchCustomer (String newValue) throws SQLException, ClassNotFoundException {
        Customer customer = customerDao.search(newValue);
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

    }

}
