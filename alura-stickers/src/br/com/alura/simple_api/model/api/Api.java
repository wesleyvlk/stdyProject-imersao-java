package br.com.alura.simple_api.model.api;

import java.util.List;
import java.util.Map;

public interface Api {
    List<Map<String, String>> receiveJsonParsedService();
}
