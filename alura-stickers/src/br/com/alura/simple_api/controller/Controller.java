package br.com.alura.simple_api.controller;

import br.com.alura.simple_api.model.api.Api;
import br.com.alura.simple_api.model.api.ApiFactory;
import br.com.alura.simple_api.model.sticker.StickerFactory;
import br.com.alura.simple_api.model.sticker.StickerProject;
import br.com.alura.simple_api.view.ImdbViewFactory;
import br.com.alura.simple_api.view.NasaViewFactory;
import br.com.alura.simple_api.view.OtherViewFactory;
import br.com.alura.simple_api.view.View;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Controller implements ApiController, StickerController {
    private static final String REGEX_VIEW_NASA = "NASA|nasa";
    private static final String REGEX_VIEW_IMDB = "TV|Movie";
    private static View view;
    private final Api apiFactory;

    public Controller(String urlApi) {
        this.apiFactory = new ApiFactory(urlApi);
        if (urlApi.split(REGEX_VIEW_NASA).length > 1) view = new NasaViewFactory(this);
        else if (urlApi.split(REGEX_VIEW_IMDB).length > 1) view = new ImdbViewFactory(this);
        else view = new OtherViewFactory(this);
    }

    public static void runStickerApi(String urlApi) {
        new Controller(urlApi);
        view.generateView();
    }

    @Override
    public List<Map<String, String>> generateApi() {
        return apiFactory.receiveJsonParsedService();
    }

    @Override
    public void generateSticker(String imageUrl, String nameArchive, Integer fontSize, String textInImage) {
        StickerFactory receiveStickerFactory = new StickerFactory(imageUrl, new StickerProject(nameArchive, fontSize, textInImage));
        try {
            receiveStickerFactory.saveSticker();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
