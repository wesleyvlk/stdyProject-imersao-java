package br.com.alura.simple_api;

import br.com.alura.simple_api.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller.runStickerApi("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD-JamesWebbSpaceTelescope.json");
    }
}