package ru.skypro.homework.service.impl;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.service.UserService;

public class UserServiceImpl implements UserService {
    /**
     * Изменить пароль
     *
     * @param newPasswordDto = старый пароль + новый пароль
     */
    @Override
    public void setPassword(NewPasswordDto newPasswordDto) {

    }

    /**
     * Получение информации об авторизованном пользователе
     *
     * @param id = id авторизованного пользователя
     * @return = UserDto
     */
    @Override
    public UserDto getInfoAboutAuthUser(int id) {
        return null;
    }

    /**
     * Обновление информации об авторизованном пользователе
     *
     * @param id            = id авторизованного пользователя
     * @param updateUserDto
     * @return
     */
    @Override
    public UpdateUserDto setInfoAboutAuthUser(int id, UpdateUserDto updateUserDto) {
        return null;
    }

    /**
     * Обновление информации об авторизованном пользователе
     *
     * @param image = файл картинки
     */
    @Override
    public void setAvatar(MultipartFile image) {

    }
}
