/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom;

import pos.layered.dao.CrudDao;
import pos.layered.dao.SuperDao;
import pos.layered.entity.CustomerEntity;

/**
 *
 * @author sachinthadilshan
 */
public interface CustomerDao  extends CrudDao<CustomerEntity, String>{
    boolean add(CustomerEntity customerEntity) throws Exception;

    public boolean update(CustomerEntity customerEntity) throws Exception;
}
