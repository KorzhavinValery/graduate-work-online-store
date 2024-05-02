package ru.skypro.homework.service.map;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.model.Comment;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CommentMap {
    public CommentDto mapCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(comment.getUser().getId());
        commentDto.setAuthorImage(comment.getUser().getImage());
        commentDto.setAuthorFirstName(comment.getUser().getFirstName());
        commentDto.setPk(comment.getId());
        commentDto.setText(comment.getText());
        ZonedDateTime zdt = ZonedDateTime.of(comment.getCreatedAt(), ZoneId.systemDefault());
        long createdAt = zdt.toInstant().toEpochMilli();
        commentDto.setCreatedAt(createdAt);
        return commentDto;
    }
}
