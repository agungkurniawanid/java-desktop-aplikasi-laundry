
package codingImageDashboardAdmin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class image7 extends JPanel{
          @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g.create();
        Image img = new ImageIcon(getClass().getResource("/logo/Desktop - 3.png")).getImage();
        graphics.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
}
