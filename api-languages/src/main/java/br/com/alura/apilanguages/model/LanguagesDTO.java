package br.com.alura.apilanguages.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguagesDTO {
    String id;
    String title;
    String image;
    int ranking;
}
