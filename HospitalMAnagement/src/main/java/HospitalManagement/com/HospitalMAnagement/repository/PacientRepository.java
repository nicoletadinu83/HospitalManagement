package HospitalManagement.com.HospitalMAnagement.repository;

import HospitalManagement.com.HospitalMAnagement.model.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientRepository extends JpaRepository <PacientModel, Long> {

    @Query(value="select pp.id as id,pp.first_name as firstName,pp.last_name as lastName,pp.gender as gender, pp.age as age,p.disease as disease,\n" +
            "a.address as address, a.city as city, a.no_tel as noTel, a.email as email,\n" +
            "pp.user_name as userName, pp.password as password from pacients p\n" +
            "join person pp on pp.id=p.id\n" +
            "join address a on a.person_id=pp.id;", nativeQuery = true)
    List<PacientModel> pacientDetailsList();
}
