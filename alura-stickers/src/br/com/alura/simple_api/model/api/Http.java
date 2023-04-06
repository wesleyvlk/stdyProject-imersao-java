package br.com.alura.simple_api.model.api;

import java.net.http.HttpRequest;

interface Http {
    HttpRequest buildRequest();

    String buildResponse();
}
