package ru.skypro.homework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.service.impl.AdServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("ads")
public class AdController {
    private final AdServiceImpl adService;

    public AdController(AdServiceImpl adService) {
        this.adService = adService;
    }

    @GetMapping
    public AdsDto getAllAds() {
        return adService.getAllAds();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AdDto addAd(@RequestPart("properties") CreateOrUpdateAdDto createOrUpdateAdDto,
                       //если первый параметр - объект типа CreateOrUpdateAdDto,
                       //то Swagger не справится в такой посылкой, он пошлет строку.
                       //В Postman надо, используя 3 точки, открыть колонку ТипКонтента и задать там application/json
                       @RequestPart MultipartFile image,
                       Principal principal) {
        return adService.addAd(createOrUpdateAdDto, image, principal);
    }
    @GetMapping("{id}")
    public AdExtendedDto getAdExtended(@PathVariable("id") int id) {
        return adService.getAdExtended(id);
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('Admin') or @CheckRoleService.GetUsernameByAd(#id) == principal.username")
    public ResponseEntity<String> DeleteAd(@PathVariable int id) {
        adService.DeleteAd(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("{id}")
    @PreAuthorize("hasRole('Admin') or @CheckRoleService.GetUserNameByAd(#id) == principal.username")
    public AdDto updateAd(@PathVariable int id, @RequestBody CreateOrUpdateAdDto createOrUpdateAdDto) {
        return adService.updateAd(id, createOrUpdateAdDto);
    }
    @GetMapping("me")
    public AdsDto getMyAds(Principal principal) {
        return adService.getMyAds(principal);
    }
    @PatchMapping(value = "{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('Admin') or @CheckRoleService.GetUserNameByAd(#id) == principal.username")
    public void patchImage(@PathVariable int id, @RequestBody MultipartFile image) {
        adService.patchImage(id, image);
    }
}
