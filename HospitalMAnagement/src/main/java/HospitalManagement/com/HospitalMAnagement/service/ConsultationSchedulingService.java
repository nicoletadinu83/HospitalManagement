package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;

import java.util.List;

public interface ConsultationSchedulingService {
   List<ConsultationSchedulingDto> getAllConsultations();
   ConsultationSchedulingDto getConsultationById(Long Id);
   void updateConsultationScheduling(ConsultationSchedulingDto consultationSchedulingDto);
   void deleteConsultationScheduling(Long Id);
   void addConsultationScheduling(ConsultationSchedulingDto newConsultationScheduling);

}
