package com.yise.xmltrial.services

import com.yise.xmltrial.models.Article
import com.yise.xmltrial.repositories.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleServiceDB(
        private val articleRepository: ArticleRepository
) : ArticleService {

    override fun findAll(): MutableIterable<Article> {
        return articleRepository.findAll()
    }

    override fun save(article: Article): Article {
        return articleRepository.save(article)
    }

    override fun findById(id: Long): Article {
        return articleRepository.findById(id).get()
    }

    override fun delete(id: Long) {
        return articleRepository.deleteById(id)
    }
}