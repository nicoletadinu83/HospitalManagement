package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.MedicalServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalServiceRepository extends JpaRepository<MedicalServiceModel, Long> {
}
