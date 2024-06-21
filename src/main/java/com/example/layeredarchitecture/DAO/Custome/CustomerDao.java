package com.example.layeredarchitecture.DAO.Custome;

import com.example.layeredarchitecture.entity.Customer;

public interface CustomerDao extends CrudDAO<Customer> {
 /*   public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String generateId() throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;*/


       /* @Override
        public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException;

        public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
           *//* Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            stm.setString(1, dto.getOid());
                    stm.setString(2, dto.getItemCode());
                    stm.setBigDecimal(3, dto.getUnitPrice());
                    stm.setInt(4, dto.getQty());

            return stm.executeUpdate() > 0;*//*

            return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
            }

        @Override
        public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
            return false;
        }

        @Override
        public boolean exist(String id) throws SQLException, ClassNotFoundException {
            return false;
        }

        @Override
        public boolean delete(String id) throws SQLException, ClassNotFoundException {
            return false;
        }

        @Override
        public String generateId() throws SQLException, ClassNotFoundException {
            return null;
        }

        @Override
        public OrderDetailDTO search(String newValue) throws SQLException, ClassNotFoundException {
            return null;
        }*/
    }

