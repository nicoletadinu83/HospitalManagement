package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.MedicalServiceDto;
import HospitalManagement.com.HospitalMAnagement.model.MedicalServiceModel;
import HospitalManagement.com.HospitalMAnagement.repository.MedicalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {

    @Autowired
    MedicalServiceRepository medicalServiceRepository;

    @Override
    public List<MedicalServiceDto> getAllMedicalService() {
        List<MedicalServiceModel> medicalServiceModelList = medicalServiceRepository.findAll();
        List<MedicalServiceDto> medicalServiceDtoList = new ArrayList<>();
        for (MedicalServiceModel medicalServiceModel : medicalServiceModelList) {
            MedicalServiceDto medicalServiceDto = new MedicalServiceDto();
            medicalServiceDto.setId(medicalServiceModel.getId());
            medicalServiceDto.setServiceName(medicalServiceModel.getServiceName());
            medicalServiceDto.setServicePrice(medicalServiceModel.getServicePrice());
            medicalServiceDtoList.add(medicalServiceDto);
        }
        return medicalServiceDtoList;
    }

    @Override
    public MedicalServiceDto getMedicalServiceById( Long id ) {
        Optional<MedicalServiceModel> medicalServiceModel = medicalServiceRepository.findById(id);
        if (medicalServiceModel.isPresent()) {
            MedicalServiceDto medicalServiceDto = new MedicalServiceDto();
            medicalServiceDto.setId(medicalServiceModel.get().getId());
            medicalServiceDto.setServiceName(medicalServiceModel.get().getServiceName());
            medicalServiceDto.setServicePrice(medicalServiceModel.get().getServicePrice());
            return medicalServiceDto;
        }
        return null;
    }

    @Override
    public void updateMedicalService( MedicalServiceDto medicalServiceDto ) {
        Optional<MedicalServiceModel> foundMedicalServiceModel = medicalServiceRepository.findById(medicalServiceDto.getId());
        if(foundMedicalServiceModel.isPresent()){
            MedicalServiceModel medicalServiceModel = foundMedicalServiceModel.get();
            medicalServiceModel.setServiceName(medicalServiceDto.getServiceName());
            medicalServiceModel.setServicePrice(medicalServiceDto.getServicePrice());
            medicalServiceRepository.saveAndFlush(medicalServiceModel);
        }
    }

    @Override
    public void deleteMedicalService( Long id ) {
        medicalServiceRepository.deleteById(id);

    }

    @Override
    public void addNewMedicalService( MedicalServiceDto newMedicalService ) {
        MedicalServiceModel medicalServiceModel = new MedicalServiceModel();
        medicalServiceModel.setId(newMedicalService.getId());
        medicalServiceModel.setServiceName(newMedicalService.getServiceName());
        medicalServiceModel.setServicePrice(newMedicalService.getServicePrice());
        medicalServiceRepository.save(medicalServiceModel);
    }
}
