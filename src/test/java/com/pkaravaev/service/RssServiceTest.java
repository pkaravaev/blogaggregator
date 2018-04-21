package com.pkaravaev.service;

import com.pkaravaev.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class RssServiceTest {

    private RssService rssService;

    @Before
    public void setUp()throws Exception {
        rssService = new RssService();
    }

    @Test
    public void testGetItemsFile() throws Exception {

        List<Item> items = rssService.getItems(new File("C:\\Users\\karav\\blog_ag\\blogaggregator\\src\\test\\java\\com\\pkaravaev\\service\\test_rss.xml"));
        assertEquals(10, items.size());
        Item first = items.get(0);
        assertEquals("How to generate web.xml in Eclipse",first.getTitle());
        assertEquals("23 03 2014 12 01 34", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(first.getPublishedDate()));
    }

}
