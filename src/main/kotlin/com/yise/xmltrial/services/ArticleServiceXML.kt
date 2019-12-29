package com.yise.xmltrial.services

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.yise.xmltrial.models.Article
import com.yise.xmltrial.models.ArticlesCollection
import org.springframework.stereotype.Service
import java.io.File


@Service
class ArticleServiceXML : ArticleService {

    private val articles = HashMap<Long, Article>()
    private final val filePath = "/Users/yiseboge/IdeaProjects/SpringTrial/src/main/resources/articles.xml"

    private final fun populateArticles() {
        val xmlMapper = XmlMapper()
        val arts = xmlMapper.readValue(File(filePath),
                ArticlesCollection::class.java)

        for (art in arts.articles) {
            articles[art.id] = art
        }
    }

    private final fun saveXML() {
        val xmlMapper = XmlMapper()
        val arts = ArticlesCollection(articles = articles.values) // test data
        xmlMapper.writeValue(File(filePath), arts)
    }


    override fun findAll(): MutableIterable<Article> {
        populateArticles()
        return articles.values
    }

    override fun save(article: Article): Article? {
        populateArticles()
        articles[article.id] = article
        saveXML()
        return articles[article.id]
    }

    override fun findById(id: Long): Article? {
        populateArticles()
        return articles[id]
    }

    override fun delete(id: Long) {
        populateArticles()
        articles.remove(id)
        saveXML()
    }
}