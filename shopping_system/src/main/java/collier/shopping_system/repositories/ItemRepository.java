package collier.shopping_system.repositories;

import org.springframework.data.repository.CrudRepository;

import collier.shopping_system.models.InventoryItem;

public interface ItemRepository extends CrudRepository<InventoryItem, Object>{

}
