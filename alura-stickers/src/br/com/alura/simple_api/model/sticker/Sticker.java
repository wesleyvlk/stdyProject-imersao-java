package br.com.alura.simple_api.model.sticker;

import java.awt.*;
import java.io.IOException;

public interface Sticker {
    Graphics2D graphicsProject() throws IOException;

    Font configFont();

    void editSticker() throws IOException;

    void saveSticker() throws IOException;
}