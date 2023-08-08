/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.controller;

import pos.layered.dto.CustomerDto;
import pos.layered.service.custom.CustomerService;
import pos.layered.service.ServiceFactory;
/**
 *
 * @author sachinthadilshan
 */
public class CustomerController {
    CustomerService customerService  =(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String addCustomer(CustomerDto customerDto) throws Exception{
       
       return customerService.addCustomer(customerDto);
        
    }
    
}
