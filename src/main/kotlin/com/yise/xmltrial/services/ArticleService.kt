package com.yise.xmltrial.services

import com.yise.xmltrial.models.Article

interface ArticleService {

    fun findAll(): MutableIterable<Article>

    fun save(article: Article): Article?

    fun findById(id: Long): Article?

    fun delete(id: Long)
}