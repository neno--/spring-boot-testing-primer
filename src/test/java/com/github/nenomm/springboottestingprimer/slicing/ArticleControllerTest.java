package com.github.nenomm.springboottestingprimer.slicing;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ArticleController.class)
@AutoConfigureMockMvc()
public class ArticleControllerTest {

  @MockBean
  private ArticleService articleService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldCreateMockMvc() {
    assertNotNull(mockMvc);
  }

  @Test
  void shouldReturnAListOfArticles() throws Exception {
    when(articleService.findAll()).thenReturn(List.of(new Article(1L, "First")));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get("/api/articles/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)));
  }

  @Test
  void shouldReturnAProperArticleStructure() throws Exception {
    when(articleService.findAll()).thenReturn(List.of(new Article(1L, "First")));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get("/api/articles/"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("First")));
  }
}
