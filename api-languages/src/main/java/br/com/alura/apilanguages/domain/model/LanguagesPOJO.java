package br.com.alura.apilanguages.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "apiLanguages")
@Getter
@Setter
public class LanguagesPOJO {
    @Id
    String id;
    String title;
    String image;
    int ranking;
}
