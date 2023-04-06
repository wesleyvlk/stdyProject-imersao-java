package br.com.alura.simple_api.model.sticker;

import java.awt.image.BufferedImage;

public interface Image {
    BufferedImage readOriginalImage();

    BufferedImage createNewProjectImage();
}
