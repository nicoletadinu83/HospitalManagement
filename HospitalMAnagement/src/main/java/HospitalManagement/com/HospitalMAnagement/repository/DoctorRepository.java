package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
}
