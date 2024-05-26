package Models;

import java.awt.*;
import java.util.Properties;

public class GLOBALS {
    public static final String TITLE = "Veterinaria";
    public static final Color BEIGE = new Color(245, 245, 220);
    public static  final Color MainColor = new Color(255, 205, 41);
    public static final Dimension buttonSize = new Dimension(200, 50);
    public static final float fontSize = 15f;
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int frameWidth = (int) screenSize.getWidth()-100;
    public static final Properties properties = new Properties();
    public static Dimension normalButtonSize = new Dimension(200, 100);

    public static String[] headerButtonsText = {"Registrar Mascota", "Registrar Vacuna", "Consultar Vacuna", "Citas", "Consultar Mascota","Principal"};
}
