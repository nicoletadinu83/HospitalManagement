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

    @OneToMany(mappedBy = "consultationScheduling", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalServiceModel> medicalServiceModelList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonModel doctor = new PersonModel();

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonModel pacient =new PersonModel();


    public PersonModel getDoctor() {
        return doctor;
    }

    public void setDoctor( PersonModel doctor ) {
        this.doctor = doctor;
    }

    public PersonModel getPacient() {
        return pacient;
    }

    public void setPacient( PersonModel pacient ) {
        this.pacient = pacient;
    }

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
