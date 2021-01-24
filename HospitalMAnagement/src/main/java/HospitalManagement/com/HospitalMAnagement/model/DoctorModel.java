package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;

@Entity
@Table(name="doctors")
public class DoctorModel extends PersonModel {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;*/
    private String medicalFacilityName; /*denumire cabinet*/
    private String field;/*domeniu: oftalmologie, stomatologie, etc*/

    public String getMedicalFacilityName() {
        return medicalFacilityName;
    }

    public void setMedicalFacilityName(String medicalFacilityName) {
        this.medicalFacilityName = medicalFacilityName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
