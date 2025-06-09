package com.nccformation.blogapi.controller;

import com.nccformation.blogapi.entity.Commentaire;
import com.nccformation.blogapi.service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commentaires")
@RequiredArgsConstructor

public class CommentaireController {
    private final CommentaireService commentaireService;

    @PostMapping("/article/{articleId}")
    public ResponseEntity<Commentaire> addComment(@PathVariable Long articleId, @RequestBody Commentaire commentaire) {
        return new ResponseEntity<>(commentaireService.addCommentToArticle(articleId, commentaire), HttpStatus.CREATED);
    }

}
