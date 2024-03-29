package com.vnpost.api.admin;

import com.vnpost.controller.api.admin.NewsApi;
import com.vnpost.service.impl.NewsService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsApi.class)
public class NewsApiTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NewsService newsService;
}
