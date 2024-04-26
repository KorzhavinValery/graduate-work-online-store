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
     * @param id = id авторизованного пользователя
     * @return = UserDto
     */
    UserDto getInfoAboutAuthUser(int id);

    /**
     * Обновление информации об авторизованном пользователе
     * @param id = id авторизованного пользователя
     * @param updateUserDto
     * @return
     */
    UpdateUserDto setInfoAboutAuthUser(int id, UpdateUserDto updateUserDto);

    /**
     * Обновление информации об авторизованном пользователе
     * @param image = файл картинки
     */
    void setAvatar(MultipartFile image);
}
