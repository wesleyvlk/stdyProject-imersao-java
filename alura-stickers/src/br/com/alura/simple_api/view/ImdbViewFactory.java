package br.com.alura.simple_api.view;

import br.com.alura.simple_api.controller.Controller;

import java.util.stream.IntStream;

public class ImdbViewFactory implements View {

    private static final double CUT_SCORE = 8.9;
    private static final String GOOD_MOVIE_EMOJI = "\uD83C\uDF1F";
    private static final String BAD_MOVIE_EMOJI = "\uD83C\uDF45";
    private static final String GOOD_MOVIE_TEXT = "TOPZERA";
    private static final String BAD_MOVIE_TEXT = "MEIO MERDA";
    private static final int FONT_SIZE = 64;

    private final Controller controllerFactory;

    public ImdbViewFactory(Controller controller) {
        this.controllerFactory = controller;
    }

    public void generateView() {
        controllerFactory.generateApi().forEach(view -> {
            String title = view.get("title");
            String urlImage = view.get("image");
            String crew = view.get("crew");
            String imDbRating = view.get("imDbRating");

            double rating = Double.parseDouble(imDbRating);
            int intRating = (int) rating;

            String textSticker = (rating >= CUT_SCORE) ?
                    String.format("%s - %.1f", GOOD_MOVIE_TEXT, rating) :
                    String.format("%s - %.1f", BAD_MOVIE_TEXT, rating);

            System.out.format("%n%s %s%n", "\033[1mTitulo:\033[0m", title);
            System.out.format("%s %s%n", "\033[1mPoster:\033[0m", urlImage);
            System.out.format("%s %s%n", "\033[1mElenco:\033[0m", crew);
            System.out.format("\033[30m\033[41;1m %s \033[0m%s ", "\033[1mPontuação:", imDbRating);

            String scoreEmoji = (rating >= CUT_SCORE) ? GOOD_MOVIE_EMOJI : BAD_MOVIE_EMOJI;
            IntStream.rangeClosed(1, intRating).forEach(score -> System.out.format(scoreEmoji));
            System.out.format("%n");

            controllerFactory.generateSticker(urlImage, title, FONT_SIZE, textSticker);
        });
    }

}
