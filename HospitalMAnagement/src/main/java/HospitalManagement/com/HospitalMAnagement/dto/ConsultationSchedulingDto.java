package HospitalManagement.com.HospitalMAnagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationSchedulingDto {

    private long id;
    private Date schedulingDate;
    private List<MedicalServiceDto> medicalServiceDtoList = new ArrayList<>();
    private List<PersonDto> doctorsList = new ArrayList<>();
    private List<PersonDto> pacientsList = new ArrayList<>();

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

    public List<MedicalServiceDto> getMedicalServiceDtoList() {
        return medicalServiceDtoList;
    }

    public void setMedicalServiceDtoList( List<MedicalServiceDto> medicalServiceDtoList ) {
        this.medicalServiceDtoList = medicalServiceDtoList;
    }

    public List<PersonDto> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList( List<PersonDto> doctorsList ) {
        this.doctorsList = doctorsList;
    }

    public List<PersonDto> getPacientsList() {
        return pacientsList;
    }

    public void setPacientsList( List<PersonDto> pacientsList ) {
        this.pacientsList = pacientsList;
    }
}
