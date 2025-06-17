package Model.dao;

import Model.impl.SellerDaoJDBC;

public class DaoDactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();

    }
}
