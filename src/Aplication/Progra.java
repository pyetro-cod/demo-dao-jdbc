package Aplication;

import Model.dao.DaoDactory;
import Model.dao.SellerDao;
import Model.entities.Seller;

public class Progra {
    public static void main(String[] args) {
        
        SellerDao sellerDao = DaoDactory.createSellerDao();
        
        Seller seller = sellerDao.findBy(3);
        
        System.out.println(seller);
    }
}
