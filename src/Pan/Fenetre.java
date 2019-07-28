package Pan;

import Pan.Introduction.PresentationPersonnages;

import javax.swing.*;

public class Fenetre  extends JFrame{
    private JPanel panel;

//    ***************************** Constructeur *************************************************
    public Fenetre(){
        this.setTitle("La 7ème magie");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        this.setVisible(true);
    }
//************************************** Nouveau Pan *************************************************
    public void intro (){
        this.panel = new Intro(this);
        this.setContentPane(panel);
        panel.repaint();
        this.getContentPane().revalidate();
    }

//    ************************************* Pour le developement ****************************************
    public void suite(){
//        this.panel = new PresentationPersonnages(this);
//        this.setContentPane(panel);
//        panel.repaint();
//        this.getContentPane().revalidate();

//        ************************************************************************************************************
        PresentationPersonnages presentationPersonnages = new PresentationPersonnages(this);
        this.setContentPane(presentationPersonnages);
        presentationPersonnages.repaint();
        this.getContentPane().revalidate();
        presentationPersonnages.appel();
    }

//    ******************************************************************************************


    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
