package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;

import java.util.List;

public interface ConsultationSchedulingService {
   List<ConsultationSchedulingDto> getAllConsultations();
   ConsultationSchedulingDto getConsultationById(Long id);
   void updateConsultationScheduling(ConsultationSchedulingDto consultationSchedulingDto);
   void deleteConsultationScheduling(Long id);
   void addConsultationScheduling(ConsultationSchedulingDto newConsultationScheduling);
//   List<ConsultationSchedulingDto> getAllConsultationForDoctor(Long id);

}
