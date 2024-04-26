package ru.skypro.homework.service.impl;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.service.AdService;

public class AdServiceImpl implements AdService {
    /**
     * Получение всех объявлений
     *
     * @return = получаем лист объявлений
     */
    @Override
    public AdsDto getAllAds() {
        return null;
    }

    /**
     * Добавляем новое объявление
     *
     * @return = возвращает AdDto
     */
    @Override
    public AdDto addAd() {
        return null;
    }

    /**
     * Получаем объявление по id
     *
     * @param id = id объявления
     * @return = возвращает AdExtendedDto
     */
    @Override
    public AdExtendedDto getAdExtended(int id) {
        return null;
    }

    /**
     * Удаляем объявление по id
     *
     * @param id = id объявления
     */
    @Override
    public void DeleteAd(int id) {

    }

    /**
     * Обновление объявления
     *
     * @param id = id объявления
     * @return = AdDto
     */
    @Override
    public AdDto updateAd(int id) {
        return null;
    }

    /**
     * Получение объявлений авторизованного пользователя
     *
     * @param userId = id авторизованного пользователя
     * @return = получаем лист объявлений авторизованного пользователя
     */
    @Override
    public AdsDto getMyAds(int userId) {
        return null;
    }

    /**
     * Обновление картинки объявления
     *
     * @param id    = id объявления
     * @param image = file картинки
     */
    @Override
    public void patchImage(int id, MultipartFile image) {

    }
}
