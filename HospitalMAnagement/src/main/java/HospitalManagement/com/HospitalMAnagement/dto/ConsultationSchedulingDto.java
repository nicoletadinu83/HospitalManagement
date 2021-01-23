package HospitalManagement.com.HospitalMAnagement.dto;

import HospitalManagement.com.HospitalMAnagement.model.MedicalServiceModel;
import HospitalManagement.com.HospitalMAnagement.model.PersonModel;

import java.util.Date;
import java.util.List;

public class ConsultationSchedulingDto {

    private long id;
    private Date schedulingDate;
    private List<MedicalServiceModel> medicalServiceModelList;
    private List<PersonModel> doctorsList ;
    private List<PersonModel> pacientsList;

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

    public List<PersonModel> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList( List<PersonModel> doctorsList ) {
        this.doctorsList = doctorsList;
    }

    public List<PersonModel> getPacientsList() {
        return pacientsList;
    }

    public void setPacientsList( List<PersonModel> pacientsList ) {
        this.pacientsList = pacientsList;
    }
}
