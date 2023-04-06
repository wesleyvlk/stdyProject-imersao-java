package br.com.alura.simple_api.view;

import br.com.alura.simple_api.controller.Controller;

public class NasaViewFactory implements View {
    private static final int FONT_SIZE = 64;
    private static final String TEXT_STICKER = "Que o Univeso te guie";
    private final Controller controllerFactory;

    public NasaViewFactory(Controller controller) {
        this.controllerFactory = controller;
    }

    @Override
    public void generateView() {
        controllerFactory.generateApi().forEach(view -> {
            String title = view.get("title");
            String urlImage = view.get("url");

            controllerFactory.generateSticker(urlImage, title, FONT_SIZE, TEXT_STICKER);
        });
    }
}
