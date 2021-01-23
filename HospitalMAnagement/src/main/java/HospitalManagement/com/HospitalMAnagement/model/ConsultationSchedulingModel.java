package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "consultations_schedule")
public class ConsultationSchedulingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date schedulingDate;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "schedule_medicalservice",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "medicalservice_id"))
    private List<MedicalServiceModel> medicalServiceModelList = new ArrayList<>();


//    private List<PersonModel> doctorsList = new ArrayList<>();
//
//
//    private List<PersonModel> pacientsList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public Date getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate( Date schedulingDate ) {
        this.schedulingDate = schedulingDate;
    }

    public List<MedicalServiceModel> getMedicalServiceModelList() {
        return medicalServiceModelList;
    }

    public void setMedicalServiceModelList( List<MedicalServiceModel> medicalServiceModelList ) {
        this.medicalServiceModelList = medicalServiceModelList;
    }
}
