package com.pkaravaev.repository;

import com.pkaravaev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserById(int id);

    User findByName(String name);

}
