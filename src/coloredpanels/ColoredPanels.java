package coloredpanels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ébel Zsolt
 */
public class ColoredPanels extends JFrame {    

    public ColoredPanels() {
        setSize(400, 400);
        setTitle("Colored Panels");
        setLayout(new GridLayout(4, 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        for (int i = 0; i < 16; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(generateRandomColor());
            
            /*
            Minden egyes JPanelhez hozzáadsz egy figyelő felületet,
            ami kattintásra megváltoztatja az adott panel háttérszínét.            
            */
            panel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    /*
                    getSource() metódus Object-et ad vissza, mivel mi 
                    tudjuk, hogy ezek az objektumok JPanelek, ezért 
                    típuskényszerítéssel visszaalakítjuk őket JPanelekké.
                    Ezek után már elérhető lesz a setBackground(). 
                    */
                    JPanel panel = (JPanel) e.getSource();
                    panel.setBackground(generateRandomColor());
                }

                @Override
                public void mousePressed(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });
            
            /*
            Hozzáadod az adott panelt a keretedhez.
            */
            getContentPane().add(panel);            
        }
    }

    private Color generateRandomColor() {
        int red = (int) (Math.random() * 255 + 1);
        int green = (int) (Math.random() * 255 + 1);
        int blue = (int) (Math.random() * 255 + 1);
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        new ColoredPanels().setVisible(true);
    }
}
