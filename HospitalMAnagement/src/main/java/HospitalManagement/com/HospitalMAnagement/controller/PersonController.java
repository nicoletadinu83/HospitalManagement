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

    @GetMapping("/getAllPersons")
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> personDtos = personService.getAllPersons();
        return new ResponseEntity(personDtos, HttpStatus.OK);
    }

    @GetMapping("/getPersonById/{id}")
    public ResponseEntity<PersonDto> getPersonById( @PathVariable("id") Long id ) {
        PersonDto personDto = personService.getPersonById(id);
        return new ResponseEntity(personDto, HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson/{id}")

    public ResponseEntity deletePerson( @PathVariable Long id ) {
        personService.deletePerson(id);
        System.out.println(" The person with id = " + id + " was deleted.");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity addPerson( @RequestBody PersonDto personDto ) {
        personService.addPerson(personDto);
        System.out.println("Was addes the  person : " + personDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addPerson1")
    public ResponseEntity addPerson1( @RequestBody PersonDto personDto ) {
        personService.addPerson1(personDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updatePerson")
    public ResponseEntity updatePerson( @RequestBody PersonDto personDto ) {
        personService.updatePerson(personDto);
        System.out.println("The person was updated");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getConsultatinSchedulingForDoctor/{id}")
    public ResponseEntity<List<ConsultationSchedulingDto>> getAllConsultationForDoctor( @PathVariable("id") Long id ) {
        List<ConsultationSchedulingDto> consultationSchedulingDtoList = personService.getAllConsultationForDoctor(id);
        return new ResponseEntity(consultationSchedulingDtoList, HttpStatus.OK);
    }

    @GetMapping("/getConsultatinSchedulingForPacient/{id}")
    public ResponseEntity<List<ConsultationSchedulingDto>> getAllConsultationForPacient( @PathVariable("id") Long id ) {
        List<ConsultationSchedulingDto> consultationSchedulingDtoList = personService.getAllConsultationForPacient(id);
        return new ResponseEntity(consultationSchedulingDtoList, HttpStatus.OK);
    }
}
