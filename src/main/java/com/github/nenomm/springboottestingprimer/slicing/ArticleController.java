package com.github.nenomm.springboottestingprimer.slicing;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  private final ArticleRepository articleRepository;

  public ArticleController(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/articles")
  List<Article> all() {
    return articleRepository.findAll();
  }
}
