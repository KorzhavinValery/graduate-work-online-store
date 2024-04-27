package ru.skypro.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.map.AdMap;

@Service
@AllArgsConstructor
public class AdServiceImpl implements AdService {
    private final AdRepository adRepository;
    private AdMap adMap;
    private UserRepository userRepository;

    /**
     * Получение всех объявлений
     *
     * @return = получаем лист объявлений
     */
    @Override

    public AdsDto getAllAds() {
        return adMap.mapAdsDto(adRepository.findAll());
    }

    /**
     * Добавляем новое объявление
     * @param userName = имя авторизированного пользователя
     * @param createOrUpdateAdDto = экземпляр CreateOrUpdateAdDto
     * @param pathImage = путь к файлу с изображением
     * @return = экземпляр AdDto
     */
    @Override
    public AdDto addAd(String userName, CreateOrUpdateAdDto createOrUpdateAdDto, String pathImage) {
        Ad ad = new Ad();
        ad.setUser(userRepository.findByName(userName));
        ad.setImage(pathImage);
        adMap.weCombineAdWithCreateOrUpdateAdDto(ad, createOrUpdateAdDto);
        return adMap.mapAdDto(adRepository.save(ad));
    }

    /**
     * Получаем объявление по id
     *
     * @param id = id объявления
     * @return = возвращает AdExtendedDto
     */
    @Override
    public AdExtendedDto getAdExtended(int id) {
        return adMap.mapAdExtendedDto(adRepository.findById(id).orElseThrow());
    }

    /**
     * Удаляем объявление по id
     *
     * @param id = id объявления
     */
    @Override
    public void DeleteAd(int id) {
        adRepository.deleteById(id);
    }

    /**
     * Обновление объявления
     *
     * @param id = id объявления
     * @return = AdDto
     */
    @Override
    public AdDto updateAd(int id, CreateOrUpdateAdDto createOrUpdateAdDto) {
        Ad ad = adRepository.findById(id).orElseThrow();
        adMap.weCombineAdWithCreateOrUpdateAdDto(ad, createOrUpdateAdDto);
        return adMap.mapAdDto(adRepository.save(ad));
    }

    /**
     * Получение объявлений авторизованного пользователя
     *
     * @param userName = имя авторизованного пользователя
     * @return = получаем лист объявлений авторизованного пользователя
     */
    @Override
    public AdsDto getMyAds(String userName) {
        User user = userRepository.findByName(userName);
        return adMap.mapAdsDto(adRepository.findAllByUserId(user.getId()));
    }

    /**
     * Обновление картинки объявления
     *
     * @param id    = id объявления
     * @param pathImage = путь к file картинки
     */
    @Override
    public void patchImage(int id, String pathImage) {
        Ad ad = adRepository.findById(id).orElseThrow();
        ad.setImage(pathImage);
        adRepository.save(ad);
    }
}
