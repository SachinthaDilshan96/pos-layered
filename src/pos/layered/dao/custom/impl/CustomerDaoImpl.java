/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom.impl;

import java.util.ArrayList;
import pos.layered.dao.CrudUtil;
import pos.layered.dao.custom.CustomerDao;
import pos.layered.entity.CustomerEntity;
import java.sql.ResultSet;



/**
 *
 * @author sachinthadilshan
 */
public class CustomerDaoImpl implements CustomerDao{

    @Override
    public boolean add(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("insert into customer values (?,?,?,?,?,?,?,?,?)",
                t.getId(),
                t.getTitle(),
                t.getName(),
                t.getDob(),
                t.getSalary(),
                t.getAddress(),
                t.getCity(),
                t.getProvince(),
                t.getZip());
    }
    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("update customer set custtitle=?, custname=?, dob=?,salary=?,address=?,city=?,province=?,zip=? where custid=?",
                t.getTitle(),
                t.getName(),
                t.getDob(),
                t.getSalary(),
                t.getAddress(),
                t.getCity(),
                t.getProvince(),
                t.getZip(),
                t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete fromm customer where custid=?", id);
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("select * from customer where custid=?", id);
        while (resultSet.next()) {
            CustomerEntity customer = new CustomerEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9));
            return customer;
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ArrayList<CustomerEntity> customerEntitys = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery("select * from customer");
        while (resultSet.next()) {
            System.out.println("getAll");
            CustomerEntity customer = new CustomerEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9));
            customerEntitys.add(customer);
        }
        return customerEntitys;
    }


   
    
}
