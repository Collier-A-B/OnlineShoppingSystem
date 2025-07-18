package collier.shopping_system.repositories;

import org.springframework.data.repository.CrudRepository;

import collier.shopping_system.models.BookItem;

public interface BookRepository extends CrudRepository<BookItem, Integer>{

}
