package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;

@RestController
@RequestMapping("ads")
@CrossOrigin(value = "http://localhost:3000")
public class CommentController {
    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDto> getComments(@PathVariable Integer adId) {
        return ResponseEntity.ok(new CommentsDto());
    }
    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDto> postComment(@PathVariable Integer adId, @RequestBody CreateOrUpdateCommentDto comment) {
        return ResponseEntity.ok(new CommentDto());
    }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<CommentDto> patchComment(@PathVariable Integer adId, @PathVariable Integer commentId, @RequestBody CreateOrUpdateCommentDto commentDto) {
        return ResponseEntity.ok(new CommentDto());
    }

}
