
package waypoint;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import javax.swing.JButton;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointPainter;



public class WaypointRenderCasa extends WaypointPainter<punteroCasa> {

         @Override
    protected void doPaint(Graphics2D g, JXMapViewer map, int width, int height) {
      for(punteroCasa elem: getWaypoints()){
          Point2D pCasa = map.getTileFactory().geoToPixel(elem.getPosition(), map.getZoom());
          Rectangle recCasa = map.getViewportBounds();
          int x = (int)(pCasa.getX() - recCasa.getX());
          int y = (int)(pCasa.getY() - recCasa.getY());
          JButton com = elem.getCasa();
          com.setLocation(x-com.getWidth()/2, y-com.getHeight());
      }
}
}