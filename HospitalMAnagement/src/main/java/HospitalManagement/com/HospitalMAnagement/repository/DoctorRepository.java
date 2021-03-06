package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {

    @Query(value="select * from doctors d\n" +
                "join person p on d.id=p.id\n" +
                "join address a on a.person_id=p.id;", nativeQuery = true)
    List<DoctorModel> findAllDoctorsDetails();
}
