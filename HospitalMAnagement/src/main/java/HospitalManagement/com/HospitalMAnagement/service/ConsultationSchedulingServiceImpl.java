package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;
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
        if (foundConsultation.isPresent()) {
            ConsultationSchedulingModel consultationSchedulingModel = foundConsultation.get();
            consultationSchedulingModel.setSchedulingDate(consultationSchedulingDto.getSchedulingDate());

            PersonDto doctorDto = consultationSchedulingDto.getDoctor();
            Optional<PersonModel> foundDoctor = personRepository.findById(doctorDto.getId());
            if (foundDoctor.isPresent()) {
                consultationSchedulingModel.setDoctor(foundDoctor.get());
            }

            PersonDto pacientDto = consultationSchedulingDto.getPacient();
            Optional<PersonModel> foundPacient = personRepository.findById(pacientDto.getId());
            if (foundPacient.isPresent()) {
                consultationSchedulingModel.setPacient(foundPacient.get());
            }

            consultationrepository.saveAndFlush(consultationSchedulingModel);
        }
    }

    @Override
    public void deleteConsultationScheduling( Long id ) {
        consultationrepository.deleteById(id);

    }

    @Override
    public void addConsultationScheduling( ConsultationSchedulingDto consultationSchedulingDto ) {
        ConsultationSchedulingModel newConsultationSchedulingModel = new ConsultationSchedulingModel();

        newConsultationSchedulingModel.setSchedulingDate(consultationSchedulingDto.getSchedulingDate());

        PersonDto doctorDto = consultationSchedulingDto.getDoctor();
        Optional<PersonModel> foundDoctor = personRepository.findById(doctorDto.getId());
        PersonDto pacientDto = consultationSchedulingDto.getDoctor();
        Optional<PersonModel> foundPacient = personRepository.findById(pacientDto.getId());

        if (foundDoctor.isPresent()) {
            newConsultationSchedulingModel.setDoctor(foundDoctor.get());
        }

        if (foundPacient.isPresent()) {
            newConsultationSchedulingModel.setPacient(foundPacient.get());
        }

        consultationrepository.save(newConsultationSchedulingModel);

    }


}
