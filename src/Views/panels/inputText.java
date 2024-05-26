package Views.panels;

import Models.GLOBALS;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static Models.GLOBALS.properties;

public class inputText extends JLabel {
    public inputText(String text) throws IOException, FontFormatException {
        super(text);
        stylizeInput();
    }

    public void stylizeInput() throws IOException, FontFormatException {
        this.setFont(createFont());
        this.setSize(Models.GLOBALS.buttonSize);
        this.setBackground(Color.WHITE);
    }

    private Font createFont() throws IOException, FontFormatException {
        properties.load(getClass().getResourceAsStream("../../data.properties"));
        return Font.createFont(Font.TRUETYPE_FONT, new File(properties.getProperty("fontPath"))).deriveFont(GLOBALS.fontSize);
    }
}
