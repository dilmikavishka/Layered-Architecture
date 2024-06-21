package com.example.layeredarchitecture.BO.Impl;

import com.example.layeredarchitecture.BO.Costome.PurchaseOrderBO;
import com.example.layeredarchitecture.DAO.Custome.ItemDAO;
import com.example.layeredarchitecture.DAO.Custome.OrderDAO;
import com.example.layeredarchitecture.DAO.Custome.OrderDatailDAO;
import com.example.layeredarchitecture.DAO.Custome.CustomerDao;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.entity.OrderDetail;
import com.example.layeredarchitecture.DTO.CustomerDTO;
import com.example.layeredarchitecture.DTO.ItemDTO;
import com.example.layeredarchitecture.DTO.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    //customerDaoImpl customerDao = new customerDaoImpl();
    //ItemDAO itemDAO = new itemDaoImpl();
    // OrderDAO orderDAO = new OrderDaoImpl();
    // OrderDatailDAO orderDatailDAO = new OrderDetailDAOImpl();

    CustomerDao customerDao = (CustomerDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDatailDAO orderDatailDAO = (OrderDatailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer customer = customerDao.search(id);
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
    }



    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.search(code);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();
//            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
//            stm.setString(1, orderId);


            boolean isExist = orderDAO.exist(orderId);
            /*if order id already exist*/
            if (isExist) {
                return false;
            }

            connection.setAutoCommit(false);
//            stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
//            stm.setString(1, orderId);
//            stm.setDate(2, Date.valueOf(orderDate));
//            stm.setString(3, customerId);


            boolean isSave = orderDAO.save(new Order(orderId,orderDate,customerId));

            if (!isSave) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

//            stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            // int isOdSave = orderDetailDao.Save(orderDetails,orderId);

            for (OrderDetailDTO detail : orderDetails) {
//                stm.setString(1, orderId);
//                stm.setString(2, detail.getItemCode());
//                stm.setBigDecimal(3, detail.getUnitPrice());
//                stm.setInt(4, detail.getQty());

//                String itemCode = detail.getItemCode();
//                BigDecimal unitPrice = detail.getUnitPrice();
//                int qty = detail.getQty();


                boolean isOdSave = orderDatailDAO.save(new OrderDetail(
                        detail.getOid(),
                        detail.getItemCode(),
                        detail.getQty(),
                        detail.getUnitPrice()
                ));

                if (!isOdSave) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }


//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
//
//                PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//                pstm.setString(1, item.getDescription());
//                pstm.setBigDecimal(2, item.getUnitPrice());
//                pstm.setInt(3, item.getQtyOnHand());
//                pstm.setString(4, item.getCode());

//                ItemDAO itemDAO = new itemDaoImpl();
                boolean Update = itemDAO.update(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));

                if (!Update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);
    }

    public String generateIdOrder() throws SQLException, ClassNotFoundException {
        return orderDAO.generateId();
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDao.getAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

            customerDTOS.add(customerDTO);
        }
        return customerDTOS;

    }

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = itemDAO.getAll();
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items){
            ItemDTO itemDTO = new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());

            itemDTOS.add(itemDTO);
        }
        return itemDTOS;
    }

    public ItemDTO findItem(String code) {
        try {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//            pstm.setString(1, code);
//            ResultSet rst = pstm.executeQuery();
//            rst.next();

            // itemDaoImpl itemDao = new itemDaoImpl();
            PurchaseOrderBOImpl purchaseOrderBO = new PurchaseOrderBOImpl();
            return purchaseOrderBO.searchItem(code);

            //return new ItemDTO(code, itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
