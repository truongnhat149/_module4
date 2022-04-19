package lpnt.cg.controller;

import lpnt.cg.model.Blog;
import lpnt.cg.service.blog.BlogService;
import lpnt.cg.service.blog.IBlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebAppConfiguration
public class BlogControllerTest {

    private IBlogService blogService = Mockito.mock(BlogService.class);

    private MockMvc mockMvc;

    @InjectMocks
    private BlogController blogController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(blogController)
                .build();
    }

    @Test
    public void findAllTest() throws Exception {
        Blog first = new Blog(1L, "social", "Codegym");
        Blog second = new Blog(2L, "facebook", "CodeGym Dao tao lap trinh");
        when(blogService.findAll()).thenReturn(Arrays.asList(first, second));

        mockMvc
                .perform(get("/blog"))
                .andExpect(status().isOk())
                .andExpect(view().name("/categories"))
                .andExpect(forwardedUrl("/categories"))
                .andExpect(model().attribute("blog", hasItem(allOf(
                    hasProperty("id", is(1)),
                    hasProperty("title", is("social")),
                    hasProperty("content", is("Codegym"))
                    )
                )))
                .andExpect(model().attribute("blog", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("content", is("facebook")),
                                hasProperty("content", is("CodeGym Dao tao lap trinh"))
                        )
                )));
        verify(blogService, times(1)).findAll();
        verifyNoMoreInteractions(blogService);
    }

    @Test
    public void findByIdTest() throws Exception {
       Blog found = new Blog(1L, "social", "Codegym");
       when(blogService.findById(1L)).thenReturn(Optional.of(found));

       mockMvc
               .perform(get("/edit/{id}", 1))
               .andExpect(status().isOk())
               .andExpect(view().name("/blog/edit"))
               .andExpect(forwardedUrl("/blog/edit"))
               .andExpect(model().attribute("blog", hasProperty("id", is(1))))
               .andExpect(model().attribute("blog", hasProperty("content", is("facebook"))))
               .andExpect(model().attribute("blog", hasProperty("content", is("CodeGym Dao tao lap trinh"))));
       verify(blogService, times(1)).findById(1L);
       verifyNoMoreInteractions(blogService);
    }
}
