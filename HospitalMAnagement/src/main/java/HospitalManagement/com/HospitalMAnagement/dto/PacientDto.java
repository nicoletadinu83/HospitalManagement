package HospitalManagement.com.HospitalMAnagement.dto;

import java.util.List;

public class PacientDto  extends PersonDto{
    private String disease;
     private List<DoctorDto> doctorDtoList;

    public List<DoctorDto> getDoctorDtoList() {
        return doctorDtoList;
    }

    public void setDoctorDtoList(List<DoctorDto> doctorDtoList) {
        this.doctorDtoList = doctorDtoList;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
