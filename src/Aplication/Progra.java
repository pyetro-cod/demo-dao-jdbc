package Aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Model.dao.DaoDactory;
import Model.dao.SellerDao;
import Model.entities.Department;
import Model.entities.Seller;

public class Progra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoDactory.createSellerDao();
        Seller seller = sellerDao.findBy(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: Seler findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        if (list != null) {
            // Se a lista não for nula, o loop pode ser executado sem problemas.
            for (Seller obj : list) {
                System.out.println(obj);
            }
        } else {
            // Se a lista for nula, essa mensagem será exibida, e o programa não irá travar.
            System.out.println("Nenhum vendedor encontrado para este departamento.");
        }
        

        System.out.println("\n=== Test 4: Seler findByAll ====");
        Seller nSeller = new Seller(null, "Pyetro", "pyetro@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(nSeller);
        System.out.println("Inserted! new id =" + nSeller.getId());
    
        System.out.println("\n=== Test 5: Seler update ====");
        seller = sellerDao.findBy(1);
        seller.setName("Maria");
        sellerDao.update(seller);
        System.out.println("Update completo");

        System.out.println("\n=== TEST 6: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleById(id);;
		System.out.println("Delete completed");
    
    }


}
