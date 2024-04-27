package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

public interface UserService {
    /**
     * Изменить пароль
     * @param newPasswordDto = старый пароль + новый пароль
     */
    void setPassword(NewPasswordDto newPasswordDto);

    /**
     * Получение информации об авторизованном пользователе
     * @param userName = имя авторизованного пользователя
     * @return = UserDto
     */
    UserDto getInfoAboutAuthUser(String userName);

    /**
     * Обновление информации об авторизованном пользователе
     * @param userName = имя авторизованного пользователя
     * @param updateUserDto
     * @return
     */
    UpdateUserDto setInfoAboutAuthUser(String userName, UpdateUserDto updateUserDto);

    /**
     * Обновление аватара авторизованного пользователя
     * @param userName = имя авторизованного пользователя
     * @param pathImage = путь к файлу картинки
     */
    void setAvatar(String userName, String pathImage);
}
