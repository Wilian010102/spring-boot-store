package com.store.ecommerce.repositories;

import com.store.ecommerce.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}