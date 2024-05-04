package ru.skypro.homework.service.map;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdExtendedDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;

import java.util.ArrayList;
import java.util.List;

public class AdMap {
    public AdsDto mapAdsDto(List<Ad> adList) {
        AdsDto adsDto = new AdsDto();
        List<AdDto> adDtoList = new ArrayList<>();
        for (Ad ad : adList) {
            adDtoList.add(mapAdDto(ad));
        }
        adsDto.setCount(adDtoList.size());
        adsDto.setResults(adDtoList);
        return adsDto;
    }

    public AdDto mapAdDto(Ad ad) {
        AdDto adDto = new AdDto();
        adDto.setPk(ad.getId());
        adDto.setAuthor(ad.getUser().getId());
        adDto.setImage("/ads/"+ad.getId()+"/image");
        adDto.setPrice(adDto.getPrice());
        adDto.setTitle(ad.getTitle());
        return adDto;
    }

    public AdExtendedDto mapAdExtendedDto(Ad ad) {
        AdExtendedDto adExtendedDto = new AdExtendedDto();
        adExtendedDto.setPk(ad.getId());
        adExtendedDto.setAuthorFirstName(ad.getUser().getFirstName());
        adExtendedDto.setAuthorLastName(ad.getUser().getLastName());
        adExtendedDto.setDescription(ad.getDescription());
        adExtendedDto.setEmail(ad.getUser().getEmail());
        adExtendedDto.setImage("/ads/"+ad.getId()+"/image");
        adExtendedDto.setPhone(ad.getUser().getPhone());
        adExtendedDto.setPrice(ad.getPrice());
        adExtendedDto.setTitle(ad.getTitle());
        return adExtendedDto;
    }

    public void weCombineAdWithCreateOrUpdateAdDto(Ad ad, CreateOrUpdateAdDto createOrUpdateAdDto) {
        ad.setTitle(createOrUpdateAdDto.getTitle());
        ad.setPrice(createOrUpdateAdDto.getPrice());
        ad.setDescription(createOrUpdateAdDto.getDescription());
    }
}
