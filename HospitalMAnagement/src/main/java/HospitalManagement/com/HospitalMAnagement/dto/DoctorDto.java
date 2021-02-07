package HospitalManagement.com.HospitalMAnagement.dto;

import HospitalManagement.com.HospitalMAnagement.model.PersonModel;

public class DoctorDto extends PersonDto {

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
