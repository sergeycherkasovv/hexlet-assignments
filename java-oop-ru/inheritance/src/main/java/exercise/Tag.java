package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    private String tagName;
    private Map<String, String> attributes;

    Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tegName) {
        this.tagName = tegName;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }


    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("<");
        result.append(tagName);
        var attribut = attributes.entrySet()
                .stream()
                .map(a ->
                    String.format(" %s=\"%s\"", a.getKey(), a.getValue())
                ).toList();
        attribut.forEach(result::append);
        result.append(">");
        return result.toString();
    };
}
// END
