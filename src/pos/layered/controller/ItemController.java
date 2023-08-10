/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.controller;

import java.util.ArrayList;
import pos.layered.dto.ItemDto;
import pos.layered.service.ServiceFactory;
import pos.layered.service.custom.ItemService;

/**
 *
 * @author sachinthadilshan
 */
public class ItemController {
    ItemService itemService  =(ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);

    public String addItem(ItemDto itemDto) throws Exception{
        
       return itemService.addItem(itemDto);
        
    }
    
    public ItemDto getItem(String id) throws Exception{
        return itemService.getItem(id);
    }
    
    public String updateItem(ItemDto itemDto) throws Exception{
        return itemService.updateItem(itemDto);
    }
    
    public String deleteItem(String itemId) throws Exception{
        return itemService.deleteItem(itemId);
    }
    
    public ArrayList<ItemDto> getAllItems() throws Exception{   
        return itemService.getAllItem();
    }
}
