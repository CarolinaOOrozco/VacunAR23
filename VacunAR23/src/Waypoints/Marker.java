
package Waypoints;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Marker extends JButton {
    public Marker(){setContentAreaFilled(false);   
    setIcon(new ImageIcon(getClass().getResource("/Recursos/pin.png")));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(70,70));
        
    }
}
