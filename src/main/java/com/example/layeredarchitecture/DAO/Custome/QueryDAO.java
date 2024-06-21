package com.example.layeredarchitecture.DAO.Custome;

import com.example.layeredarchitecture.DAO.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public void getAllUserByOrderDate();
}
