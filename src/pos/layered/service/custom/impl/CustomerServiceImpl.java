/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import pos.layered.dao.custom.CustomerDao;
import pos.layered.dto.CustomerDto;
import pos.layered.entity.CustomerEntity;
import pos.layered.service.custom.CustomerService;
import pos.layered.dao.DaoFactory;
/**
 *
 * @author sachinthadilshan
 */
public class CustomerServiceImpl implements CustomerService{
    
    CustomerDao customerDao =(CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);
    @Override
    public String addCustomer(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDto.getId(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getZip()
        );
        
        if(customerDao.addCustomer(customerEntity)){
            return "Successfully Added";
        }else{
            return "Failed";
        }               
    }
    
}
