package Model.dao;

import Model.impl.SellerDaoJDBC;
import db.DB;

public class DaoDactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());

    }
}
