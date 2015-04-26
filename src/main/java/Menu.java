import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.MouseInfoPeer;

/**
 * Created by Julien on 25/04/2015.
 */
public class Menu extends JFrame implements ActionListener {
    public Menu() {
        this.setSize(400, 300);
        Container c=this.getContentPane();
        c.setLayout(null);
        JButton b1 = new JButton("Ajouter un CV");
        JButton b2 = new JButton("Voir les CV");
        b1.setBounds(100, 50, 200, 50);
        b2.setBounds(100, 150, 200, 50);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddFrame().setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AllFrame().setVisible(true);
            }
        });
        c.add(b1);
        c.add(b2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    /*public void actionPerformed(ActionEvent e) {
        //if((JButton)e.getSource() == .b1){
            this.dispose();
            new AddFrame().setVisible(true);
        }
       */
}
