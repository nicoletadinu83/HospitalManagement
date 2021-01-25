package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepository extends JpaRepository <PacientModel, Long> {
}
