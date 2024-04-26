package ru.skypro.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.CommentService;
import ru.skypro.homework.service.UserService;
import ru.skypro.homework.service.map.CommentMap;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private CommentMap commentMap;
    private final AdRepository adRepository;
    private final UserRepository userRepository;

    /**
     * Получение комментариев объявления
     *
     * @param adId = id объявления
     * @return = лист с комментариями
     */
    @Override

    public CommentsDto getComments(int adId) {
        return commentRepository.findAllByAd(adId);
    }

    /**
     * Добавление комментария к объявлению
     *
     * @param adId    = id объявления
     * @param comment = текст комментария
     * @return = CommentDto
     */
    @Override
    public CommentDto postComment(int adId, CreateOrUpdateCommentDto comment, String userName) {
        Comment newComment = new Comment();
        User user = userRepository.findByName(userName);
        Ad ad = adRepository.findById(adId).orElseThrow();
        newComment.setAd(ad);
        newComment.setUser(user);
        LocalDateTime createdAt = LocalDateTime.now();
        newComment.setCreatedAt(createdAt);
        newComment.setText(comment.getText());
        commentRepository.save(newComment);
        return commentMap.mapCommentDto(commentRepository.save(newComment));
    }

    /**
     * Удалить комментарий
     *
     * @param id = id комментария
     */
    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    /**
     * Обновление комментария
     *
     * @param id = id комментария
     * @return = CommentDto
     */
    @Override
    public CommentDto patchComment(int id, CreateOrUpdateCommentDto commentDto) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.setText(commentDto.getText());
        return commentMap.mapCommentDto(commentRepository.save(comment));
    }
}
