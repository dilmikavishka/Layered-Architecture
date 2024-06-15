package com.example.layeredarchitecture.DAO;

import java.sql.SQLException;

public interface OrderDAO {
    public String generateId() throws SQLException, ClassNotFoundException;

}
