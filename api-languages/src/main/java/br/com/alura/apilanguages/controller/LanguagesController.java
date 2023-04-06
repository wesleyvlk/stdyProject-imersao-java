package br.com.alura.apilanguages.controller;

import br.com.alura.apilanguages.domain.model.LanguagesPOJO;
import br.com.alura.apilanguages.model.LanguagesDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LanguagesController {

    ResponseEntity<LanguagesDTO> create(LanguagesPOJO pojo);

    ResponseEntity<List<LanguagesDTO>> readAll();

    ResponseEntity<LanguagesDTO> readById(String id);

    ResponseEntity<LanguagesDTO> update(LanguagesPOJO pojo);

    ResponseEntity<Void> deleteById(String id);

}
