package Aplication;

import java.util.Date;

import Model.dao.DaoDactory;
import Model.dao.SellerDao;
import Model.entities.Department;
import Model.entities.Seller;

public class Progra {
    public static void main(String[] args) {
        Department  obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
        
        SellerDao sellerDao = DaoDactory.createSellerDao();
        
        
        System.out.println(obj);
        System.out.println(seller);
    }
}
