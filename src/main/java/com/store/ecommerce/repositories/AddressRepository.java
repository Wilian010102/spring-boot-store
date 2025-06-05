package com.store.ecommerce.repositories;

import com.store.ecommerce.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}