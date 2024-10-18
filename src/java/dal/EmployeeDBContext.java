/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class EmployeeDBContext extends DBContext<Employee> {

    public ArrayList<Employee> listSalaryMonth() {
        ArrayList<Employee> emps = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "select [eid]\n"
                    + "      ,[ename]\n"
                    + "      ,[gender]\n"
                    + "      ,[address]\n"
                    + "  from [Employee]";
            //chuyển String sang câu lệnh 
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Employee e = new Employee();
                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setAddress(rs.getString("address"));
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emps;
    }

    @Override
    public void insert(Employee model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Employee> list() {
        ArrayList<Employee> emps = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "select eid, ename,email, address, gender "
                    + "from ProductionSchedulingSystem_DB.dbo.Employees";
            //chuyển String sang câu lệnh 
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Employee e = new Employee();
                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));

                e.setAddress(rs.getString("address"));
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emps;
    }

}
