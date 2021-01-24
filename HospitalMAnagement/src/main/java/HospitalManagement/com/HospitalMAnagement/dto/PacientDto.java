package HospitalManagement.com.HospitalMAnagement.dto;

public class PacientDto  extends PersonDto{
    private String disease;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
