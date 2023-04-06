package br.com.alura.simple_api.view;

import br.com.alura.simple_api.controller.Controller;

public class OtherViewFactory implements View {
    private static final int FONT_SIZE = 64;
    private static final String TEXT_STICKER = "The Best!";

    private final Controller controllerFactory;

    public OtherViewFactory(Controller controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    @Override
    public void generateView() {
        controllerFactory.generateApi().forEach(view -> controllerFactory.generateSticker(
                view.get("image"), view.get("title"), FONT_SIZE, TEXT_STICKER
        ));
    }
}