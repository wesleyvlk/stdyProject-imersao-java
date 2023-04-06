package br.com.alura.apilanguages.domain.model.service;

import br.com.alura.apilanguages.domain.model.LanguagesPOJO;

import java.util.List;

public interface LanguagesService {

    LanguagesPOJO insert(LanguagesPOJO languages);

    List<LanguagesPOJO> findAll();

    LanguagesPOJO findById(String id);

    LanguagesPOJO update(LanguagesPOJO languages);

    void deleteById(String id);

}
