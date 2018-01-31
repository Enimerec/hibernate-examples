package com.github.pabloo99.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryDaoTest {

    @Test
    void ShouldReturnCountryById(){
        CountryDao countryDao = new CountryDao();
        assertTrue(countryDao.findByID("AR").getCountryName().equals("Argentina"));
        assertTrue(countryDao.findAll().size() > 1);
    }

    @Test
    void shouldReturnCountriesWIthNames(){
        CountryDao countryDao = new CountryDao();

        String regionName = countryDao.findByID("CN").getRegion().getRegionName();
        assertTrue(regionName.equals("Asia"));

    }

}