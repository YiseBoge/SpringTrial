package com.yise.xmltrial.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper

data class ArticlesCollection(
        @JacksonXmlElementWrapper(localName = "articles")
        var articles: MutableCollection<Article> = mutableListOf()
)