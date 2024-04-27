package ru.skypro.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;
import ru.skypro.homework.service.map.UserMap;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserMap userMap;
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
     * @param userName = имя авторизованного пользователя
     * @return = UserDto
     */
    @Override
    public UserDto getInfoAboutAuthUser(String userName) {
        return userMap.mapUserDto(userRepository.findByName(userName));
    }

    /**
     * Обновление информации об авторизованном пользователе
     *
     * @param userName = имя авторизованного пользователя
     * @param updateUserDto
     * @return
     */
    @Override
    public UpdateUserDto setInfoAboutAuthUser(String userName, UpdateUserDto updateUserDto) {
        User user = userRepository.findByName(userName);
        userMap.updateUser(user, updateUserDto);
        return userMap.mapUpdateUserDto(userRepository.save(user));
    }

    /**
     * Обновление аватара авторизованного пользователя
     * @param userName = имя авторизованного пользователя
     * @param pathImage = путь к файлу картинки
     */
    @Override
    public void setAvatar(String userName, String pathImage) {
        User user = userRepository.findByName(userName);
        user.setImage(pathImage);
        userRepository.save(user);
    }
}
