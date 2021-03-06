package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;
import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;

import java.util.List;

public interface PersonService {
     public List<DoctorDto> getAllDoctors();
     public DoctorDto getDoctorById( Long id);

     public List<PacientDto> getAllPacients();
     public PacientDto getPacientById(Long id);

     public void addPerson(PersonDto personDto);
     public void deletePerson(Long id);
     public void  updatePerson(PersonDto personDto);

     void addPerson1(PersonDto personDto);
     List<ConsultationSchedulingDto> getAllConsultationForDoctor(Long id);
     List<ConsultationSchedulingDto> getAllConsultationForPacient(Long id);
}
