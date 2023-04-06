package br.com.alura.apilanguages.controller;

import br.com.alura.apilanguages.domain.model.LanguagesPOJO;
import br.com.alura.apilanguages.domain.model.service.LanguagesService;
import br.com.alura.apilanguages.model.LanguagesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguagesControllerImpl implements LanguagesController {

    @Autowired
    private LanguagesService languagesService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @PostMapping
    public ResponseEntity<LanguagesDTO> create(@RequestBody LanguagesPOJO pojo) {
        return ResponseEntity.ok(toDTO(languagesService.insert(pojo)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<LanguagesDTO>> readAll() {
        return ResponseEntity.ok(toDTOList(languagesService.findAll()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LanguagesDTO> readById(@PathVariable String id) {
        return ResponseEntity.ok(toDTO(languagesService.findById(id)));
    }

    @Override
    @PutMapping
    public ResponseEntity<LanguagesDTO> update(@RequestBody LanguagesPOJO pojo) {
        return ResponseEntity.ok(toDTO(languagesService.update(pojo)));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        languagesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private LanguagesDTO toDTO(LanguagesPOJO pojo) {
        return modelMapper.map(pojo, LanguagesDTO.class);
    }

    private List<LanguagesDTO> toDTOList(List<LanguagesPOJO> pojoList) {
        return pojoList.stream().map(pojo -> modelMapper.map(pojo, LanguagesDTO.class)).toList();
    }

}
