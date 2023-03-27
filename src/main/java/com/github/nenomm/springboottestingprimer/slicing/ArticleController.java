package com.github.nenomm.springboottestingprimer.slicing;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping("/")
  List<Article> findAll() {
    return articleService.findAll();
  }

  @GetMapping("/{articleName}")
  Article findByArticleName(@PathVariable String articleName) {
    return articleService.findArticleByName(articleName);
  }
}
