package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;
import HospitalManagement.com.HospitalMAnagement.model.ConsultationSchedulingModel;
import HospitalManagement.com.HospitalMAnagement.model.PersonModel;
import HospitalManagement.com.HospitalMAnagement.repository.ConsultationSchedulingRepository;
import HospitalManagement.com.HospitalMAnagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationSchedulingServiceImpl implements ConsultationSchedulingService {

    @Autowired
    ConsultationSchedulingRepository consultationrepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<ConsultationSchedulingDto> getAllConsultations() {
        List<ConsultationSchedulingModel> consultationSchedulingModelList = consultationrepository.findAll();
        List<ConsultationSchedulingDto> consultationSchedulingDtos = new ArrayList<>();
        for (ConsultationSchedulingModel consultations : consultationSchedulingModelList) {
            ConsultationSchedulingDto consultationDto = new ConsultationSchedulingDto();
            consultationDto.setId(consultations.getId());
            consultationDto.setSchedulingDate(consultations.getSchedulingDate());
            consultationSchedulingDtos.add(consultationDto);
        }

        return consultationSchedulingDtos;
    }

    @Override
    public ConsultationSchedulingDto getConsultationById( Long id ) {
        Optional<ConsultationSchedulingModel> consultationSchedulingModel = consultationrepository.findById(id);
        if (consultationSchedulingModel.isPresent()) {
            ConsultationSchedulingDto consultationSchedulingDto = new ConsultationSchedulingDto();
            consultationSchedulingDto.setId(consultationSchedulingModel.get().getId());
            consultationSchedulingDto.setSchedulingDate(consultationSchedulingModel.get().getSchedulingDate());
            return consultationSchedulingDto;
        }
        return null;
    }

    @Override
    public void updateConsultationScheduling( ConsultationSchedulingDto consultationSchedulingDto ) {
        Optional<ConsultationSchedulingModel> foundConsultation = consultationrepository.findById(consultationSchedulingDto.getId());
        if(foundConsultation.isPresent()){
            ConsultationSchedulingModel consultationSchedulingModel = foundConsultation.get();
            consultationSchedulingModel.setSchedulingDate(consultationSchedulingDto.getSchedulingDate());
            consultationrepository.saveAndFlush(consultationSchedulingModel);
        }
    }

    @Override
    public void deleteConsultationScheduling( Long id ) {
       consultationrepository.deleteById(id);

    }

    @Override
    public void addConsultationScheduling( ConsultationSchedulingDto newConsultationScheduling ) {
        ConsultationSchedulingModel consultationSchedulingModel = new ConsultationSchedulingModel();
        consultationSchedulingModel.setId(newConsultationScheduling.getId());
        consultationSchedulingModel.setSchedulingDate(newConsultationScheduling.getSchedulingDate());
        consultationrepository.save(consultationSchedulingModel);

    }


}
