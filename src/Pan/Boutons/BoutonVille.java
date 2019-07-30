package Pan.Boutons;

import Pan.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoutonVille extends JButton implements ActionListener, MouseListener {
    private String name;
    private Map map;
    private int[] emplacement;

    public BoutonVille(String name, Map map, int[] emplacement) {
        this.name = name;
        this.map = map;
        this.emplacement = emplacement;
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.map.setDesc(name);
        this.map.setEmplacementDesc(emplacement);
        this.map.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.map.setDesc("");
        this.map.repaint();
    }
}
