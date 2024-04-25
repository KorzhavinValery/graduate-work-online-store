package ru.skypro.homework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("ads")
public class AdController {
    @GetMapping
    public AdsDto getAllAds() {

        return new AdsDto();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AdDto addAd(@RequestPart("properties") String jsonCreateOrUpdateAdDto,
                       @RequestPart MultipartFile image ) {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateOrUpdateAdDto crOrUpdAdDto;
        try {
            crOrUpdAdDto = objectMapper.readValue(jsonCreateOrUpdateAdDto, new TypeReference<CreateOrUpdateAdDto>(){});
        } catch( JsonProcessingException e) {
            throw  new RuntimeException();
        }//пока что так, первый параметр - объект типа crOrUpdAdDto,
        // Postman и Swagger возвращают - status 415 Unsupported Media Type, строка приходит без ошибок

        return new AdDto();
    }
    @GetMapping("{id}")
    public AdExtendedDto getAdExtended(@PathVariable("id") int id) {

        return new AdExtendedDto();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteAd(@PathVariable("id") int id) {

        return ResponseEntity.ok().build();
    }
    @PatchMapping("{id}")
    public AdDto updateAd(@PathVariable("id") int id) {
        return new AdDto();
    }
    @GetMapping("me")
    public AdsDto getMyAds() {
        return new AdsDto();
    }
    @PatchMapping(value = "{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] patchImage(@PathVariable("id") int id, @RequestBody MultipartFile image) {
        return new byte[0];
    }
}
