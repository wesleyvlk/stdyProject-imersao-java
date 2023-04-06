package br.com.alura.simple_api.service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParserService {
    public static List<Map<String, String>> parse(String json) {
        List<Map<String, String>> jsonParse = new ArrayList<>();

        Matcher matcherItems = RegexEnum.ITEMS.getRegexPattern().matcher(json);
        if (!matcherItems.find()) throw new IllegalArgumentException("Nenhum item encontrado.");
        String[] items = matcherItems.group(1).split("}.\\{");

        Arrays.stream(items).forEach(item -> {
            Map<String, String> attributesItems = new HashMap<>();

            Matcher matcherAttributes = RegexEnum.ATTRIBUTES.getRegexPattern().matcher(item);
            while (matcherAttributes.find()) {
                String attribute = matcherAttributes.group(1);
                String value = matcherAttributes.group(2);

                attributesItems.put(attribute, value);
            }

            jsonParse.add(attributesItems);
        });

        return jsonParse;
    }

    private enum RegexEnum {
        ITEMS(".*\\[(.+)\\].*"), ATTRIBUTES("\"(.+?)\":\"(.*?)\"");

        private final Pattern regexPattern;

        RegexEnum(String regexPattern) {
            this.regexPattern = Pattern.compile(regexPattern);
        }

        public Pattern getRegexPattern() {
            return regexPattern;
        }
    }
}
