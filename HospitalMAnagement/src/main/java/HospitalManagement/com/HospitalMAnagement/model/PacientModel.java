package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;

@Entity
@Table(name="pacients")
public class PacientModel extends PersonModel{

    private String disease;

    public String getDisease() {
        return disease;
    }

    public void setDisease( String disease ) {
        this.disease = disease;
    }
}
