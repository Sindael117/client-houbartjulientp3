import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Julien on 26/04/2015.
 */
public class AllFrame extends JFrame {
    public AllFrame() {

        org.jdom.Document document;
        Element racine;

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        JLabel info = new JLabel();
        this.add(info);
        info.setBounds(25, 25, 150, 25);

        JLabel CV1= new JLabel();
        JLabel CV2= new JLabel();
        JLabel CV3= new JLabel();
        this.add(CV1);
        this.add(CV2);
        this.add(CV3);
        CV1.setBounds(25, 75, 150, 25);
        CV2.setBounds(25, 125, 150, 25);
        CV3.setBounds(25, 175, 150, 25);

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet("http://projetlw2serveur-sindael117.rhcloud.com/rest/CV/");
            getRequest.addHeader("Accept", "application/xml");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            String output=br.readLine();
            info.setText(output);
            httpClient.getConnectionManager().shutdown();

            FileWriter fstream = new FileWriter("cv.xml");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(output);
            out.close();

            JAXBContext jaxbContext = JAXBContext.newInstance(CVS.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CVS cvs = new CVS();
            //cvs.setMaliste((List<CV>) jaxbUnmarshaller.unmarshal()));
        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}