package Model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.dao.SellerDao;
import Model.entities.Department;
import Model.entities.Seller;
import db.DB;
import db.DbException;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleById(Integer id) {

    }

    private Seller instantiateSeller(ResultSet rs, Department dep) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'instantiateSeller'");
    }

    private Department instantiateDepartment(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'instantiateDepartment'");
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Seller findBy(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department dep = new Department();
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id")); // Assuming 'Id' is the column for seller's ID
                obj.setName(rs.getString("Name")); // Assuming 'Name' is the column for seller's Name
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setDepartment(dep);
                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }
}
