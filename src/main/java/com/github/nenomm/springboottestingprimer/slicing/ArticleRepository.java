package com.github.nenomm.springboottestingprimer.slicing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

  // todo: unit test this later, and compare with getXXX method.
  Article findArticleByName(String articleName);
}
