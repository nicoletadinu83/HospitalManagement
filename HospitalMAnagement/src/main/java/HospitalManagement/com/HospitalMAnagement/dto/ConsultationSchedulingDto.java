package HospitalManagement.com.HospitalMAnagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationSchedulingDto {

    private long id;
    private Date schedulingDate;
    private List<MedicalServiceDto> medicalServiceDtoList = new ArrayList<>();
    private PersonDto doctor;
    private PersonDto pacient;

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

    public PersonDto getDoctor() {
        return doctor;
    }

    public void setDoctor( PersonDto doctor ) {
        this.doctor = doctor;
    }

    public PersonDto getPacient() {
        return pacient;
    }

    public void setPacient( PersonDto pacient ) {
        this.pacient = pacient;
    }
}
