package com.yise.xmltrial.repositories

import com.yise.xmltrial.models.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long>