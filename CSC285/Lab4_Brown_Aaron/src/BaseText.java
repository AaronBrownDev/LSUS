
public class BaseText implements Text{
    private final String text;

    public BaseText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
