package com.dsc.aeroparker_coding_challenge.repository;

import com.dsc.aeroparker_coding_challenge.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
