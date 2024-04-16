package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

    @Override
    public List<Content> extractContent(String json) {
        // Extract only the relevant data (title, poster, rating)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attributes : attributesList) {
            String title = attributes.get("title");
            String imageUrl = attributes.get("url");

            Content content = new Content(title, imageUrl);
            contents.add(content);
        }

        return contents;
    }
}

