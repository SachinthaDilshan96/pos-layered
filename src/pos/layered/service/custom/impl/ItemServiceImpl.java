/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import java.util.ArrayList;
import pos.layered.dao.DaoFactory;
import pos.layered.dao.custom.ItemDao;
import pos.layered.dto.ItemDto;
import pos.layered.entity.ItemEntity;
import pos.layered.service.custom.ItemService;

/**
 *
 * @author sachinthadilshan
 */
public class ItemServiceImpl implements ItemService{

    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String addItem(ItemDto itemDto) throws Exception {
        if (itemDao.add(new ItemEntity(
                itemDto.getId(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrice(),
                itemDto.getQoh()
        ))) {
            return "Successfully saved";
        } else {
            return "Failed to save";
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) throws Exception {
        if (itemDao.update(new ItemEntity(
                itemDto.getId(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrice(),
                itemDto.getQoh()
        ))) {
            return "Successfully Updated";
        } else {
            return "Failed to save";
        }
    }

    @Override
    public String deleteItem(String id) throws Exception {
        if (itemDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Failed to Delete";
        }
    }

    @Override
    public ItemDto getItem(String id) throws Exception {
           ItemEntity entity = itemDao.get(id);
           return new ItemDto(
                   entity.getId(),
                   entity.getDescription(),
                   entity.getPackSize(),
                   entity.getUnitPrice(),
                   entity.getQoh()
           );
    }

    @Override
    public ArrayList<ItemDto> getAllItem() throws Exception {
           ArrayList<ItemDto> itemDtos = new ArrayList<>();
           ArrayList<ItemEntity> itemEntitys = itemDao.getAll();
           for(ItemEntity itemEntity:itemEntitys){
               itemDtos.add(new ItemDto(
                       itemEntity.getId(),
                       itemEntity.getDescription(),
                       itemEntity.getPackSize(),
                       itemEntity.getUnitPrice(),
                       itemEntity.getQoh()
               ));
           }
           return itemDtos;
    }
    
}
