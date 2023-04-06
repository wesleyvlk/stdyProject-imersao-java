package br.com.alura.apilanguages.domain.repository;

import br.com.alura.apilanguages.domain.model.LanguagesPOJO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LanguagesRepository extends MongoRepository<LanguagesPOJO, String> {

    List<LanguagesPOJO> findByOrderByRanking();

}
