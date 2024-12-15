package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface tagInterface;

    public LabelTag(String tag, TagInterface tagInterface) {
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        StringBuilder result = new StringBuilder();

        result.append("<label>");
        result.append(tag);
        result.append(tagInterface.render());
        result.append("</label>");

        return result.toString();
    }
}
// END
