package HospitalManagement.com.HospitalMAnagement.controller;

import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;
import HospitalManagement.com.HospitalMAnagement.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("getDoctors")
    public ResponseEntity<List<DoctorDto>> getDoctorsList() {
        List<DoctorDto> doctorList = personService.getAllDoctors();
        System.out.println("doctorList: " + doctorList);
        return new ResponseEntity(doctorList, HttpStatus.OK);
    }

    @GetMapping("getPacients")
    public ResponseEntity<List<PacientDto>> getAllPacients() {
        List<PacientDto> pacientDtoList = personService.getAllPacients();
        System.out.println("Pacient list are: " + pacientDtoList);
        return new ResponseEntity(pacientDtoList, HttpStatus.OK);
    }

}
