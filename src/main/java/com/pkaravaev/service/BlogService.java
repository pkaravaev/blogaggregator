package com.pkaravaev.service;

import com.pkaravaev.exception.RssException;
import com.pkaravaev.model.Blog;
import com.pkaravaev.model.Item;
import com.pkaravaev.model.User;
import com.pkaravaev.repository.BlogRepository;
import com.pkaravaev.repository.ItemRepository;
import com.pkaravaev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RssService rssService;
    @Autowired
    private ItemRepository itemRepository;

    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item saveItem = itemRepository.findByBlogAndLink(blog, item.getLink());
                if (saveItem == null) {
                    item.setBlog(blog);
                    itemRepository.save(item);
                }
                item.setBlog(blog);
                itemRepository.save(item);
            }
        } catch (RssException e) {

        }
    }


    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);

    }

    public Blog findOne(int id) {
        return blogRepository.getBlogById(id);
    }


    @PreAuthorize("#blog.user.name == authentication.name or hasAnyRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }
}
