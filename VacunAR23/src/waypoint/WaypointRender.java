
package waypoint;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.Locale;
import javax.swing.JButton;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointPainter;




public class WaypointRender extends WaypointPainter<miPuntero>{

    @Override
    protected void doPaint(Graphics2D g, JXMapViewer map, int width, int height) {
      for(miPuntero elem: getWaypoints()){
          Point2D p = map.getTileFactory().geoToPixel(elem.getPosition(), map.getZoom());
          Rectangle rec = map.getViewportBounds();
          int x = (int)(p.getX() - rec.getX());
          int y = (int)(p.getY() - rec.getY());
          JButton com = elem.getBoton();
          com.setLocation(x-com.getWidth()/2, y-com.getHeight());
      }
    }

}
