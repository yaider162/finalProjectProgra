package Views.panels;

import Models.GLOBALS;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static Models.GLOBALS.properties;

public class Button extends JButton{

    public Button(String text) throws IOException, FontFormatException {
        button(text);
    }
    public void button(String text) throws IOException, FontFormatException {
        this.setBorderPainted(false);
        this.setText(text);
        this.setFont(createFont());
        this.setSize(Models.GLOBALS.buttonSize);
        this.setBackground(Color.WHITE);
        this.setFocusPainted(false);
    }
    public Button(String text, Dimension size) throws IOException, FontFormatException {
        button(text, size);
    }
    public void button(String text, Dimension size) throws IOException, FontFormatException {
        this.setBorderPainted(false);
        this.setText(text);
        this.setFont(createFont());
        this.setSize(size);
        this.setBackground(Color.WHITE);
        this.setFocusPainted(false);
    }
    public Font createFont() throws IOException, FontFormatException {
        properties.load(getClass().getResourceAsStream("../../data.properties"));
        return Font.createFont(Font.TRUETYPE_FONT, new File(properties.getProperty("fontPath"))).deriveFont(GLOBALS.fontSize);
    }
}
