package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;
import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();
    PersonDto getPersonById(Long id);

    void addPerson( PersonDto personDto );

    void deletePerson( Long id );

    void updatePerson( PersonDto personDto );

    void addPerson1( PersonDto personDto );

    List<ConsultationSchedulingDto> getAllConsultationForDoctor( Long id );

    List<ConsultationSchedulingDto> getAllConsultationForPacient( Long id );
}
