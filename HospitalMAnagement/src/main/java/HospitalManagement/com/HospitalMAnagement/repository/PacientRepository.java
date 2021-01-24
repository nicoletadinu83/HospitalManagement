package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository <PacientModel, Long> {
}
