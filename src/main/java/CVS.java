import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julien on 26/04/2015.
 */
@XmlRootElement(name = "CVS")
public class CVS {

    private List<CV> cvs;

    public List<CV> getCvs() {
        return cvs;
    }

    public CVS(List<CV> cvs) {
        this.cvs = cvs;
    }

    @XmlElement(name="cv")
    public void setMaliste(List<CV> maliste) {
        this.cvs = maliste;
    }

    public CVS(){
        this.cvs= null;
    }
}
