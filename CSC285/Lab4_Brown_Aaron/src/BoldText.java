// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #4 (Decorator Pattern)
// File Name: BoldText.java
public class BoldText extends TextDecorator {
    /**
     * assigns given text to TextDecorator text
     * @param text
     */

    public BoldText(Text text) {
        this.text = text;
    }

    /**
     *
     * @return text as bold HTML line
     */
    @Override
    public String getText() {
        return "<b>" + this.text.getText() + "</b>";
    }
}
