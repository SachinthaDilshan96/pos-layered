/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import java.util.ArrayList;
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
        
        if(customerDao.add(customerEntity)){
            return "Successfully Added";
        }else{
            return "Failed";
        }               
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) throws Exception {
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

        if (customerDao.update(customerEntity)) {
            return "Successfully Updated";
        } else {
            return "Failed to Update";
        }
    }

    @Override
    public String deleteCustomer(String id) throws Exception {
        if (customerDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Failed to delete";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
            CustomerEntity entity = customerDao.get(id);
            return new CustomerDto(
                entity.getId(),
                entity.getTitle(),
                entity.getName(),
                entity.getDob(),
                entity.getSalary(),
                entity.getAddress(),
                entity.getCity(),
                entity.getProvince(),
                entity.getZip()
            );
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
            ArrayList<CustomerDto> customerDtos = new ArrayList<>();
            ArrayList<CustomerEntity> customerEntitys = customerDao.getAll();
            for(CustomerEntity entity:customerEntitys){
                CustomerDto dto = new CustomerDto(
                        entity.getId(),
                        entity.getTitle(),
                        entity.getName(),
                        entity.getDob(),
                        entity.getSalary(),
                        entity.getAddress(),
                        entity.getCity(),
                        entity.getProvince(),
                        entity.getZip()
                );
                customerDtos.add(dto);
            }
            return customerDtos;
    }
    
}
