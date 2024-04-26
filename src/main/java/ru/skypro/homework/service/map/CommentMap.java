package ru.skypro.homework.service.map;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.model.Comment;

public class CommentMap {
    public CommentDto mapCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(comment.getUser().getId());
        commentDto.setAuthorImage(comment.getUser().getImage());
        commentDto.setAuthorFirstName(comment.getUser().getFirstName());
        commentDto.setPk(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setCreatedAt(comment.getCreatedAt());
        return commentDto;
    }
}
