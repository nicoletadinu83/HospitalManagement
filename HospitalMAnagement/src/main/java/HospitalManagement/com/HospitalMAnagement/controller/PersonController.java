package HospitalManagement.com.HospitalMAnagement.controller;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;
import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;
import HospitalManagement.com.HospitalMAnagement.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   /* @GetMapping("getPacient/{id}")
    public ResponseEntity<PacientDto> getPacientById(@PathVariable Long id) {
        PacientDto pacientDto = personService.getPacientById(id);
        System.out.println("I found the pacient: " + pacientDto);
        return new ResponseEntity(pacientDto, HttpStatus.OK);
    }*/

   /* @GetMapping("getDoctor/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        DoctorDto doctorDto = personService.getDoctorById(id);
        return new ResponseEntity(doctorDto, HttpStatus.OK);
    }*/

    @DeleteMapping("deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        System.out.println(" The person with id = " + id + " was deleted.");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("addPerson")
    public ResponseEntity addPerson(@RequestBody PersonDto personDto){
        personService.addPerson(personDto);
        System.out.println("Was addes the  person : "+ personDto);
         return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("addPerson1")
    public ResponseEntity addPerson1(@RequestBody PersonDto personDto){
        personService.addPerson1(personDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("updatePerson")
    public ResponseEntity updatePerson(@RequestBody PersonDto personDto){
        personService.updatePerson(personDto);
        System.out.println("The person was updated");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getConsultatinSchedulingForDoctor/{id}")
    public ResponseEntity<List<ConsultationSchedulingDto>> getAllConsultationForDoctor(@PathVariable("id") Long id){
        List<ConsultationSchedulingDto> consultationSchedulingDtoList = personService.getAllConsultationForDoctor(id);
        return new ResponseEntity(consultationSchedulingDtoList, HttpStatus.OK);
    }

    @GetMapping("/getConsultatinSchedulingForPacient/{id}")
    public ResponseEntity<List<ConsultationSchedulingDto>> getAllConsultationForPacient(@PathVariable("id") Long id){
        List<ConsultationSchedulingDto> consultationSchedulingDtoList = personService.getAllConsultationForPacient(id);
        return new ResponseEntity(consultationSchedulingDtoList, HttpStatus.OK);
    }
}
