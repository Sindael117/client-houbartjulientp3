import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CV")
public class CV {

    String nom;
    String prenom;
    int age;
    // String adresse;
    //List<String> exp_Pro;
    //List<String> skill;

    public CV(){super();}

    public CV(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
}
