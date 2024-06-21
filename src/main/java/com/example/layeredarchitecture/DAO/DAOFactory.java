package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.DAO.Custome.CrudDAO;
import com.example.layeredarchitecture.DAO.Custome.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? new DAOFactory():daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType){

        switch (daoType){
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAILS:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;

        }

    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY
    }
}
