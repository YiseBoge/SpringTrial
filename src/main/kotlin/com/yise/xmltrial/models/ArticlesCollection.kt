package com.yise.xmltrial.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper

data class ArticlesCollection(
        @JacksonXmlElementWrapper(localName = "articles")
        var article: MutableCollection<Article> = mutableListOf()
)