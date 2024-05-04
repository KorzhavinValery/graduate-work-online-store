package ru.skypro.homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userService;
    @PostMapping("set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPasswordDto newPassword, Principal principal) {
        userService.setPassword(newPassword, principal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getInfoAboutAuthUser(Principal principal) {
        return ResponseEntity.ok(userService.getInfoAboutAuthUser(principal));
    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDto> setInfoAboutAuthUser(@RequestBody UpdateUserDto updateUserDto, Principal principal) {

        return ResponseEntity.ok(userService.setInfoAboutAuthUser(principal, updateUserDto));
    }

    @PatchMapping(path = "/me/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> setAvatar(@RequestPart("image") MultipartFile image, Principal principal) {
        userService.setAvatar(image, principal);// надо доделать с файлом
        return ResponseEntity.ok().build();
    }
}
