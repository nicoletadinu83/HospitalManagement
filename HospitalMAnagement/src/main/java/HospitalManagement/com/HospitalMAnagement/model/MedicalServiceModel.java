package HospitalManagement.com.HospitalMAnagement.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="medical_service")
public class MedicalServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serviceName;
    private double servicePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConsultationSchedulingModel consultationScheduling;

    public ConsultationSchedulingModel getConsultationScheduling() {
        return consultationScheduling;
    }

    public void setConsultationScheduling( ConsultationSchedulingModel consultationScheduling ) {
        this.consultationScheduling = consultationScheduling;
    }

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

}
