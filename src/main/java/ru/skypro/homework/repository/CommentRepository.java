package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.model.Comment;

import java.time.LocalDateTime;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT e FROM Comment e WHERE e.ad_id LIKE %:adId%")
    CommentsDto findAllByAd(@Param("adId") int adId);

    Comment findByCreatedAt(LocalDateTime createdAt);
}
