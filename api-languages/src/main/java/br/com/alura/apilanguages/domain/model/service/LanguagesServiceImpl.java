package br.com.alura.apilanguages.domain.model.service;

import br.com.alura.apilanguages.domain.model.LanguagesPOJO;
import br.com.alura.apilanguages.domain.repository.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LanguagesServiceImpl implements LanguagesService {

    @Autowired
    private LanguagesRepository languagesRepository;

    @Override
    public LanguagesPOJO insert(LanguagesPOJO languages) {
        return languagesRepository.insert(languages);
    }

    @Override
    public List<LanguagesPOJO> findAll() {
        return languagesRepository.findByOrderByRanking();
    }

    @Override
    public LanguagesPOJO findById(String id) {
        return languagesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public LanguagesPOJO update(LanguagesPOJO languages) {
        if (languagesRepository.findById(languages.getId()).isPresent()) {
            return languagesRepository.save(languages);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteById(String id) {
        if (languagesRepository.findById(id).isPresent()) languagesRepository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
