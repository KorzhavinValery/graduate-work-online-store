package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("ads")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDto> getComments(@PathVariable Integer adId) {
        return ResponseEntity.ok(commentService.getComments(adId));
    }
    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDto> postComment(@PathVariable Integer adId, @RequestBody CreateOrUpdateCommentDto comment, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return ResponseEntity.ok(commentService.postComment(adId, comment, principal.getName()));
    }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<CommentDto> patchComment(@PathVariable Integer adId, @PathVariable Integer commentId, @RequestBody CreateOrUpdateCommentDto commentDto) {
        return ResponseEntity.ok(commentService.patchComment(commentId, commentDto));
    }

}
