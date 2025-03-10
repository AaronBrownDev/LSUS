// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #4 (Decorator Pattern)
// File Name: StrikedThroughText.java
public class StrikedThroughText extends TextDecorator {

    /**
     * assigns given text to TextDecorator text
     * @param text
     */
    public StrikedThroughText(Text text) {
        this.text = text;
    }

    /**
     *
     * @return text as strikethrough HTML line
     */
    @Override
    public String getText() {
        return "<s>" + this.text.getText() + "</s>";
    }
}
