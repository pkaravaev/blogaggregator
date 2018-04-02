package com.pkaravaev.repository;

import com.pkaravaev.model.Blog;
import com.pkaravaev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findByUser(User user);
}
