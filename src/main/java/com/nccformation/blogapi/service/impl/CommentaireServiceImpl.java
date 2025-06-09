package com.nccformation.blogapi.service.impl;

import com.nccformation.blogapi.entity.Article;
import com.nccformation.blogapi.entity.Commentaire;
import com.nccformation.blogapi.exception.ResourceNotFoundException;
import com.nccformation.blogapi.repository.ArticleRepository;
import com.nccformation.blogapi.repository.CommentaireRepository;
import com.nccformation.blogapi.service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor

public class CommentaireServiceImpl implements CommentaireService {
    private final ArticleRepository articleRepository;
    private final CommentaireRepository commentaireRepository;

    @Override
    public Commentaire addCommentToArticle(Long articleId, Commentaire commentaire) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article non trouvé avec l'id : " + articleId));

        commentaire.setArticle(article);
        commentaire.setDateCommentaire(LocalDate.now());

        return commentaireRepository.save(commentaire);
    }
}
