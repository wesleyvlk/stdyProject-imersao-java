package br.com.alura.simple_api.model.api;

import br.com.alura.simple_api.service.JsonParserService;

import java.util.List;
import java.util.Map;

public class ApiFactory extends HttpConcrete implements Api {
    public ApiFactory(String url) {
        HttpConcrete.url = url;
    }

    @Override
    public List<Map<String, String>> receiveJsonParsedService() {
        return JsonParserService.parse(buildResponse());
    }
}