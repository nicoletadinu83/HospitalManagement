package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();
    DoctorDto getDoctorById(Long id);
    void updateDoctor(DoctorDto doctorDto);
    void deleteDoctor(Long id);
    void addNewDoctor(DoctorDto newDoctorDto);

}
