import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Julien on 25/04/2015.
 */
public class AddFrame extends JFrame{
    public AddFrame(){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        JLabel age_label = new JLabel("Age : ");
        final JLabel nom_label = new JLabel("Nom : ");
        final JLabel prenom_label = new JLabel("Prenom");
        final JTextField age_value = new JTextField();
        final JTextField nom_value = new JTextField();
        final JTextField prenom_value = new JTextField();
        JButton b1 = new JButton("valider");

        age_label.setBounds(25, 25, 150, 25);
        age_value.setBounds(200, 25, 150, 25);
        nom_label.setBounds(25,75,150,25);
        nom_value.setBounds(200,75,150,25);
        prenom_label.setBounds(25,125,150,25);
        prenom_value.setBounds(200,125,150,25);
        b1.setBounds(100, 175, 200, 25);

        this.add(age_label);
        this.add(age_value);
        this.add(nom_label);
        this.add(nom_value);
        this.add(prenom_label);
        this.add(prenom_value);
        this.add(b1);
        this.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringEntity monxml = null;
                try {
                    monxml = new StringEntity("<CV><age>" + age_value.getText() + "</age><nom>" + nom_value.getText() + "</nom><prenom>" + prenom_value.getText() + "</prenom></CV>");
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpPost postRequest = new HttpPost("http://projetlw2serveur-sindael117.rhcloud.com/rest/CV/");
                    monxml.setContentType("application/xml");
                    postRequest.setEntity(monxml);
                    HttpResponse response = httpClient.execute(postRequest);
                    JOptionPane.showMessageDialog(null,"Le CV a été ajouté");

                } catch (ClientProtocolException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
