package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacients")
public class PacientModel extends PersonModel {

    private String disease;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_pacient_List",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "pacient_id"))
    private List<DoctorModel> doctorModelList = new ArrayList<>();

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<DoctorModel> getDoctorModelList() {
        return doctorModelList;
    }

    public void setDoctorModelList(List<DoctorModel> doctorModelList) {
        this.doctorModelList = doctorModelList;
    }
}
