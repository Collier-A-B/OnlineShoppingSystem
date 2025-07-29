package collier.shopping_system.repositories;

import org.springframework.data.repository.CrudRepository;

import collier.shopping_system.models.GroceryItem;

public interface GroceryRepository extends CrudRepository<GroceryItem, Object>{

}
