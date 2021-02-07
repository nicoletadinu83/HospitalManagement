package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;

import java.util.List;

public interface PacientService {
    List<PacientDto> getAllPacients();
    PacientDto getPacientById(Long Id);
    void updatePacient(PacientDto pacientDto);
    void deletePacient(Long Id);
    void addNewPacient(PacientDto newPacient);
}
