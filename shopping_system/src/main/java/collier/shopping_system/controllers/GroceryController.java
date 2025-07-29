package collier.shopping_system.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import collier.shopping_system.models.GroceryItem;
import collier.shopping_system.repositories.GroceryRepository;

@RestController
@RequestMapping(path = "/groceryInventory")
public class GroceryController {
    @Autowired
    private GroceryRepository groceryRepository;

    @PostMapping(path = "/addGrocery")
    public ResponseEntity<String> addGrocery(@Validated @RequestBody GroceryItem newGrocery, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Input Validation Failed: " + bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Unknown Error Has Occured: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Grocery Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllGroceries")
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        try {
            List<GroceryItem> returnedGroceries = (List<GroceryItem>) groceryRepository.findAll();
            HttpStatus status;
            if(returnedGroceries.isEmpty())
                status = HttpStatus.NOT_FOUND;
            else
                status = HttpStatus.OK;
            return new ResponseEntity<>(returnedGroceries, status);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
