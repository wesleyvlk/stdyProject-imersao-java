package br.com.alura.simple_api.model.sticker;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ImageConcrete implements Image {
    protected static BufferedImage originalImage;

    @Override
    public BufferedImage readOriginalImage() {
        return originalImage;
    }

    @Override
    public BufferedImage createNewProjectImage() {
        int width = readOriginalImage().getWidth();
        int height = readOriginalImage().getHeight();
        int newHeight = height + (height / 6);
        return new BufferedImage(width, newHeight, Transparency.TRANSLUCENT);
    }
}
