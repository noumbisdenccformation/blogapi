package com.nccformation.blogapi.service;

import com.nccformation.blogapi.entity.Commentaire;

public interface CommentaireService {
    Commentaire addCommentToArticle(Long articleId, Commentaire commentaire);
}
