package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> listSingleTag;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> listSingleTag) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.listSingleTag = listSingleTag;
    }

    public String getTagBody() {
        return tagBody;
    }

    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(super.toString());
        listSingleTag.stream()
                .forEach(a -> result.append(a.toString()));
        result.append(tagBody);
        result.append(String.format("</%s>", super.getTagName()));

        return result.toString();
    }
}
// END
