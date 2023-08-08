/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom;

import pos.layered.dao.SuperDao;
import pos.layered.entity.CustomerEntity;

/**
 *
 * @author sachinthadilshan
 */
public interface CustomerDao extends SuperDao{
    boolean addCustomer(CustomerEntity customerEntity) throws Exception;
}
