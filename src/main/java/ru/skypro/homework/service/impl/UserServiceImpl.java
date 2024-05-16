package ru.skypro.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.exceptions.PasswordsNotEqualsException;
import ru.skypro.homework.exceptions.UserNotFoundException;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;
import ru.skypro.homework.service.map.UserMap;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.security.Principal;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserMap userMap;
    private final PasswordEncoder encoder;
    /**
     * Изменить пароль
     *
     * @param newPasswordDto = старый пароль + новый пароль
     */
    @Override
    public void setPassword(NewPasswordDto newPasswordDto, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        if (!encoder.matches(newPasswordDto.getCurrentPassword(), user.getPassword())) {
            throw new PasswordsNotEqualsException();
        }
        user.setPassword(encoder.encode(newPasswordDto.getNewPassword()));
        userRepository.save(user);

    }

    /**
     * Получение информации об авторизованном пользователе
     *
     * @param principal = интерфейс для получения username пользователя
     * @return = UserDto
     */
    @Override
    public UserDto getInfoAboutAuthUser(Principal principal) {
        String userName = principal.getName();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UserNotFoundException(userName));
        return userMap.mapUserDto(user);

    }

    /**
     * Обновление информации об авторизованном пользователе
     *
     * @param principal = интерфейс для получения username пользователя
     * @param updateUserDto
     * @return
     */
    @Override
    public UpdateUserDto setInfoAboutAuthUser(Principal principal, UpdateUserDto updateUserDto) {
        String userName = principal.getName();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UserNotFoundException(userName));;
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setPhone(updateUserDto.getPhone());
        return updateUserDto;
    }

    /**
     * Обновление аватара авторизованного пользователя
     * @param principal = интерфейс для получения username пользователя
     * @param image = путь к файлу картинки
     * @throws UserNotFoundException выбрасывается, если пользователь не найден в таблице user.
     * @throws IOException выбрасывается, если возникают проблемы при получении картинки.
     */
    @Override
    public void setAvatar(MultipartFile image, Principal principal) {
        String userName = principal.getName();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UserNotFoundException(userName));
        try {
            user.setImage(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        userRepository.save(user);
    }
}
