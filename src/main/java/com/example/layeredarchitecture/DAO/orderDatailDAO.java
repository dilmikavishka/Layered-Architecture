package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface orderDatailDAO {
    public int Save(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException;
}
