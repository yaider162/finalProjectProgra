package Views;

import Models.GLOBALS;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPage extends JFrame {

    public MainPage() throws IOException, FontFormatException {
        initComponents();
        run();
    }
    private void initComponents() throws IOException, FontFormatException {
        initBasic();
        this.add(new Views.panels.Header(this), BorderLayout.NORTH);
        this.add(new Views.panels.Body(), BorderLayout.CENTER);
    }

    public void addNewPanel(JPanel panel, String position){
        this.add( panel, position);
        this.revalidate();
        this.repaint();
    }

    private void initBasic(){
        this.setTitle(GLOBALS.TITLE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Models.GLOBALS.frameWidth, 600);
        this.setLocationRelativeTo(null);
    }
    public void run() {
        setVisible(true);
    }
}
