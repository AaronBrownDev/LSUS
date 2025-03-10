// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #4 (Decorator Pattern)
// File Name: ItalicText.java
public class ItalicText extends TextDecorator {

    /**
     * assigns given text to TextDecorator text
     * @param text
     */
    public ItalicText(Text text) {
        this.text = text;
    }

    /**
     *
     * @return text as italic HTML line
     */
    @Override
    public String getText() {
        return "<i>" + this.text.getText() + "</i>";
    }
}
