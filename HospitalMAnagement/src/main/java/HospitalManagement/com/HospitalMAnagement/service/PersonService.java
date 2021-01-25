package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;

public interface PersonService {
     public DoctorDto getAllDoctors();
     public DoctorDto getDoctorById( Long id);

     public PacientDto getAllPacients();
     public PacientDto getPacientById(Long id);

     public void addPerson(PersonDto personDto);
     public void deletePerson(Long id);
     public void  updatePerson(PersonDto personDto);
}
