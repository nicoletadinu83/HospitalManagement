package HospitalManagement.com.HospitalMAnagement.dto;
import java.util.ArrayList;
import java.util.List;

public class MedicalServiceDto {
    private long id;
    private String serviceName;
    private double servicePrice;
    private List<ConsultationSchedulingDto> consultationSchedulingDtoList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName( String serviceName ) {
        this.serviceName = serviceName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice( double servicePrice ) {
        this.servicePrice = servicePrice;
    }

    public List<ConsultationSchedulingDto> getConsultationSchedulingDtoList() {
        return consultationSchedulingDtoList;
    }

    public void setConsultationSchedulingDtoList( List<ConsultationSchedulingDto> consultationSchedulingDtoList ) {
        this.consultationSchedulingDtoList = consultationSchedulingDtoList;
    }
}
