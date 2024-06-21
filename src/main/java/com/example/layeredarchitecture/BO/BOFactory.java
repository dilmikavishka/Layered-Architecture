package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.BO.Impl.CustomerBOImpl;
import com.example.layeredarchitecture.BO.Impl.ItemBOimpl;
import com.example.layeredarchitecture.BO.Impl.PurchaseOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? new BOFactory():boFactory;
    }

    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOimpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }

    public enum BOType{
        CUSTOMER,ITEM,PURCHASE_ORDER
    }
}
