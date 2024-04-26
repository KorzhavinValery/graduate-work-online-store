package ru.skypro.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;
import ru.skypro.homework.service.map.CommentMap;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private CommentMap commentMap;

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
     * @param adId      = id объявления
     * @param comment = текст комментария
     * @return = CommentDto
     */
    @Override
    public CommentDto postComment(int adId, CreateOrUpdateCommentDto comment) {
        return null;
    }

    /**
     * Удалить комментарий
     *
     * @param id = id комментария
     */
    @Override
    public void deleteComment(int id) {

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
        commentRepository.save(comment);
        return commentMap.mapCommentDto(comment);
    }
}
