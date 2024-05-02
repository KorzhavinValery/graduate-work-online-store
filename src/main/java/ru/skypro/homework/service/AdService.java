package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;

public interface AdService {
    /**
     * Получение всех объявлений
     * @return = получаем лист объявлений
     */
    AdsDto getAllAds();

    /**
     * Добавляем новое объявление
     * @param userName = имя авторизированного пользователя
     * @param createOrUpdateAdDto = экземпляр CreateOrUpdateAdDto
     * @param pathImage = путь к файлу с изображением
     * @return = экземпляр AdDto
     */
    AdDto addAd(String userName, CreateOrUpdateAdDto createOrUpdateAdDto, String pathImage);

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
    AdDto updateAd(int id, CreateOrUpdateAdDto createOrUpdateAdDto);

    /**
     * Получение объявлений авторизованного пользователя
     * @param userName = имя авторизованного пользователя
     * @return = получаем лист объявлений авторизованного пользователя
     */
    AdsDto getMyAds(String userName);

    /**
     * Обновление картинки объявления
     * @param id = id объявления
     * @param pathImage = путь к file картинки
     */
    void patchImage(int id, String pathImage);
}
