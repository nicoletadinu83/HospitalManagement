package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.MedicalServiceDto;

import java.util.List;

public interface MedicalServiceService {
    List<MedicalServiceDto> getAllMedicalService();
    MedicalServiceDto getMedicalServiceById(Long id);
    void updateMedicalService(MedicalServiceDto medicalServiceDto);
    void deleteMedicalService(Long id);
    void addNewMedicalService(MedicalServiceDto newMedicalService);
}
