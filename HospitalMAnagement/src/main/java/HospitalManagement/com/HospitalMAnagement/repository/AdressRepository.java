package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AddressModel, Long> {
}
