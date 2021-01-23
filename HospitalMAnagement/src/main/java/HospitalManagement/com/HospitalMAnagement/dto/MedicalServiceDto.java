package HospitalManagement.com.HospitalMAnagement.dto;

import HospitalManagement.com.HospitalMAnagement.model.ConsultationSchedulingModel;

import java.util.List;

public class MedicalServiceDto {
    private long id;
    private String serviceName;
    private double servicePrice;
    private List<ConsultationSchedulingModel> consultationSchedulingModelList;

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
