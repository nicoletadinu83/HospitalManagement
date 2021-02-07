package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.MedicalServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalServiceModel, Long> {
}
