package com.akkademy

case class ParseArticle(uri: String)
case class HttpResponse(rawArticle: String)
case class ParseHtmlArticle(uri: String, rawArticle: String)
case class ArticleBody(url: String, body: String)