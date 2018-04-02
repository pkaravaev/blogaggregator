package com.pkaravaev.repository;

import com.pkaravaev.model.Blog;
import com.pkaravaev.model.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByBlog(Blog blog, Pageable pageable);


}
