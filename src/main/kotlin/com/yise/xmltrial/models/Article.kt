package com.yise.xmltrial.models

import javax.persistence.*

@Entity
@Table(name = "articles")
data class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var title: String = "",
        var body: String = ""
)