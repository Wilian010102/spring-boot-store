package com.store.ecommerce.repositories;

import com.store.ecommerce.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}