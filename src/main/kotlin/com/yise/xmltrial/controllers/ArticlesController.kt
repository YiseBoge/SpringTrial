package com.yise.xmltrial.controllers

import com.yise.xmltrial.models.Article
import com.yise.xmltrial.services.ArticleServiceXML
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping("/article")
class ArticlesController(
//        private val articleServiceDB: ArticleServiceDB
        private val articleService: ArticleServiceXML
) {

    @ModelAttribute("newArticle")
    fun newArticle(): Article {
        return Article()
    }

    @ModelAttribute("dataList")
    fun allArticles(): MutableIterable<Article> {
        return articleService.findAll()
    }

    @ModelAttribute("title")
    fun addPageTitle(): String? {
        return "Articles - Article Posts"
    }

    @GetMapping
    fun index(): String {
        return "article/index"
    }

    @GetMapping("/create")
    fun create(): String {
        return "article/create"
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Long, model: Model): String {
        val article = articleService.findById(id)
        model.addAttribute("currentArticle", article)

        return "article/show"
    }

    @GetMapping("/{id}/edit")
    fun edit(@PathVariable("id") id: Long, model: Model): String {
        val article = articleService.findById(id)
        model.addAttribute("currentArticle", article)
        return "article/edit"
    }

    @PostMapping
    fun store(@ModelAttribute("newArticle") article: @Valid Article, errors: Errors): String {
        if (errors.hasErrors()) {
            return "article/create"
        }
        articleService.save(article)
        return "redirect:/article"
    }

    @PostMapping("/{id}/update")
    fun update(@ModelAttribute("currentArticle") article: @Valid Article, errors: Errors): String {
        if (errors.hasErrors()) {
            return "article/edit"
        }
        articleService.save(article)
        return "redirect:/article"
    }

    @GetMapping("/{id}/delete")
    fun destroy(@PathVariable("id") id: Long): String {
        articleService.delete(id)
        return "redirect:/article"
    }
}