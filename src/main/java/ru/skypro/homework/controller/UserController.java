package ru.skypro.homework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {
    @PostMapping("set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPasswordDto newPassword) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getInfoAboutAuthUser() {
        return ResponseEntity.ok(new UserDto());
    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDto> setInfoAboutAuthUser() {
        return ResponseEntity.ok(new UpdateUserDto());
    }

    @PatchMapping(path = "/me/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> setAvatar(@RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}
