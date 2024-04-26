package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;

public interface AdService {
    /**
     * Получение всех объявлений
     * @return = получаем лист объявлений
     */
    AdsDto getAllAds();

    /**
     * Добавляем новое объявление
     * @return = возвращает AdDto
     */
    AdDto addAd();

    /**
     * Получаем объявление по id
     * @param id = id объявления
     * @return = возвращает AdExtendedDto
     */
    AdExtendedDto getAdExtended(int id);

    /**
     * Удаляем объявление по id
     * @param id = id объявления
     */
    void DeleteAd(int id);

    /**
     * Обновление объявления
     * @param id = id объявления
     * @return = AdDto
     */
    AdDto updateAd(int id);

    /**
     * Получение объявлений авторизованного пользователя
     * @param userId = id авторизованного пользователя
     * @return = получаем лист объявлений авторизованного пользователя
     */
    AdsDto getMyAds(int userId);

    /**
     * Обновление картинки объявления
     * @param id = id объявления
     * @param image = file картинки
     */
    void patchImage(int id, MultipartFile image);
}
