package br.com.alura.simple_api.model.sticker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerFactory extends ImageConcrete implements Sticker {
    private final StickerProject stickerProject;
    private BufferedImage projectImage;

    public StickerFactory(String imageUrl, StickerProject stickerProject) {
        this.stickerProject = stickerProject;
        try {
            InputStream inputStream = new URL(imageUrl).openStream();
            originalImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Graphics2D graphicsProject() {
        if (projectImage == null) {
            projectImage = createNewProjectImage();
            Graphics2D graphicProject = projectImage.createGraphics();
            graphicProject.drawImage(readOriginalImage(), 0, 0, null);
        }

        return (Graphics2D) projectImage.getGraphics();
    }

    @Override
    public Font configFont() {
        return new Font("Impact", Font.BOLD, stickerProject.fontSize());
    }

    @Override
    public void editSticker() {
        String text = stickerProject.text();
        Graphics2D graphics = graphicsProject();

        graphics.setFont(configFont());
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D rectangle = fontMetrics.getStringBounds(text, graphicsProject());

        int textWidth = (int) rectangle.getWidth();
        int textPositionX = (projectImage.getWidth() - textWidth) / 2;
        int textPositionY = projectImage.getHeight() - 100;

        graphics.setColor(Color.YELLOW);
        graphics.drawString(text, textPositionX, textPositionY);
    }

    @Override
    public void saveSticker() throws IOException {
        editSticker();
        String pathFileName = "output/";

        File outputDir = new File(pathFileName);
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        pathFileName += String.format("%s.png", stickerProject.name());
        ImageIO.write(projectImage, "png", new File(pathFileName));
    }
}
