package com.nccformation.blogapi.service.impl;

import com.nccformation.blogapi.entity.Article;
import com.nccformation.blogapi.exception.ResourceNotFoundException;
import com.nccformation.blogapi.repository.ArticleRepository;
import com.nccformation.blogapi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article) {
        article.setDatePublication(LocalDate.now());
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article non trouvé avec l'id : " + id));
    }

    @Override
    public Article updateArticle(Long id, Article articleDetails) {
        Article article = getArticleById(id);
        article.setTitre(articleDetails.getTitre());
        article.setContenu(articleDetails.getContenu());
        article.setDatePublication(articleDetails.getDatePublication());
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        Article article = getArticleById(id);
        articleRepository.delete(article);
    }
}
