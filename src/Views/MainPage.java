package Views;

import Models.GLOBALS;
import Presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPage extends JFrame {

    public MainPage(Presenter presenter) throws IOException, FontFormatException {
        initComponents(presenter);
        run();
    }
    private void initComponents(Presenter presenter) throws IOException, FontFormatException {
        initBasic();
        this.add(new Views.panels.Header(this,presenter), BorderLayout.NORTH);
        this.add(new Views.panels.Body(this, presenter), BorderLayout.CENTER);
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
