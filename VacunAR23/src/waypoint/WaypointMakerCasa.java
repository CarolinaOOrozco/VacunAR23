
package waypoint;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class WaypointMakerCasa extends JButton {

       public WaypointMakerCasa(){setContentAreaFilled(false);   
    setIcon(new ImageIcon(getClass().getResource("/Recursos/casa.png")));
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setSize(new Dimension(70,70));
        
    }
}
