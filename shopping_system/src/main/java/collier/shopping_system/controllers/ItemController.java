package collier.shopping_system.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import collier.shopping_system.models.InventoryItem;
import collier.shopping_system.repositories.ItemRepository;

@RestController
@RequestMapping(path = "/itemInventory")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(path = "/getAllItems")
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        try {
            List<InventoryItem> returnedItems = (List<InventoryItem>) itemRepository.findAll();
            HttpStatus status;

            if(returnedItems.isEmpty())
                status = HttpStatus.NOT_FOUND;
            else 
                status = HttpStatus.OK;

            return new ResponseEntity<>(returnedItems, status);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
