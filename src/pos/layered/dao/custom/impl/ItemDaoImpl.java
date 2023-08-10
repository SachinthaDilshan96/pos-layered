/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom.impl;

import java.util.ArrayList;
import pos.layered.dao.CrudUtil;
import pos.layered.dao.custom.ItemDao;
import pos.layered.entity.ItemEntity;
import java.sql.ResultSet;
/**
 *
 * @author sachinthadilshan
 */
public class ItemDaoImpl implements ItemDao{

    @Override
    public boolean add(ItemEntity t) throws Exception {
            return CrudUtil.executeUpdate("insert into item values(?,?,?,?,?)", 
                    t.getId(),
                    t.getDescription(),
                    t.getPackSize(),
                    t.getUnitPrice(),
                    t.getQoh()
                    );
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
 return CrudUtil.executeUpdate("update item set description=?,packsize=?,unitprice=?,qtyonhand=? where itemcode=?",                   
                    t.getDescription(),
                    t.getPackSize(),
                    t.getUnitPrice(),
                    t.getQoh(),
                    t.getId()
                    );
    }

    @Override
    public boolean delete(String id) throws Exception {
 return CrudUtil.executeUpdate("delete ftom item where itemcode=?",                   
               id
                    );
    }

    @Override
    public ItemEntity get(String id) throws Exception {
            ResultSet resultSet = CrudUtil.executeQuery("select * from item where itemcode=?", id);
            while(resultSet.next()){
                return new ItemEntity(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)
                );
            }
            return null;
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery("select * from item");
            while(resultSet.next()){
                itemEntitys.add(
                new ItemEntity(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)
                )
                );
            }
            return itemEntitys;
    }
    
}
