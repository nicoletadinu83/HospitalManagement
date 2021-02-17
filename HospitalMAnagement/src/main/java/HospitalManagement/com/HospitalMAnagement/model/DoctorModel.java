package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doctors")
public class DoctorModel extends PersonModel {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;*/
    private String medicalFacilityName; /*denumire cabinet*/
    private String field;/*domeniu: oftalmologie, stomatologie, etc*/

    @ManyToMany(mappedBy = "doctorModelList", cascade = CascadeType.ALL)
    private List<PacientModel> pacientModelList= new ArrayList<>();

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
