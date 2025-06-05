package com.store.ecommerce.repositories;

import com.store.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
