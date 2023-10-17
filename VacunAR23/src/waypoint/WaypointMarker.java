
package waypoint;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class WaypointMarker  extends JButton{

    public WaypointMarker(){setContentAreaFilled(false);   
    setIcon(new ImageIcon(getClass().getResource("/Recursos/pin.png")));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(70,70));
        
    }

        }


