package com.github.nenomm.springboottestingprimer.slicing;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

  private final ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  public Article findArticleByName(String articleName) {
    return articleRepository.findArticleByName(articleName);
  }
}
