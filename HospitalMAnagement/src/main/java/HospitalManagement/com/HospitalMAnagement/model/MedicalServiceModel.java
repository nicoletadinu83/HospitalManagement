package HospitalManagement.com.HospitalMAnagement.model;
import javax.annotation.processing.Generated;
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

    @ManyToMany(mappedBy = "medicalServiceModelList", cascade = CascadeType.ALL)
    private List<ConsultationSchedulingModel> consultationSchedulingModelList = new ArrayList<>();

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

    public List<ConsultationSchedulingModel> getConsultationSchedulingModelList() {
        return consultationSchedulingModelList;
    }

    public void setConsultationSchedulingModelList( List<ConsultationSchedulingModel> consultationSchedulingModelList ) {
        this.consultationSchedulingModelList = consultationSchedulingModelList;
    }
}
