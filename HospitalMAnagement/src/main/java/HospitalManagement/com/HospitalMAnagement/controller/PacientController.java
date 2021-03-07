package HospitalManagement.com.HospitalMAnagement.controller;


import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.model.PacientModel;
import HospitalManagement.com.HospitalMAnagement.service.PacientService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PacientController {

    @Autowired
    PacientService pacientService;

    @GetMapping("/getPacientsList")
    public ResponseEntity<List<PacientModel>> getAll() {
        List<PacientDto> pacientDtoList = pacientService.getAllPacients();
        return new ResponseEntity(pacientDtoList, HttpStatus.OK);
    }

    @GetMapping("/getPacient/{id}")
    public ResponseEntity<PacientDto> findById( @PathVariable("id") Long id ) {
        PacientDto pacientDto = pacientService.getPacientById(id);
        return new ResponseEntity(pacientDto, HttpStatus.OK);
    }

    @GetMapping("/pacientDetailsList")
    public ResponseEntity<List<PacientModel>> pacientDetailsList(){
        List<PacientDto> pacientDetailsList = pacientService.pacientDetailsList();
        return  new ResponseEntity(pacientDetailsList, HttpStatus.OK);
    }

    @PostMapping("/addPacient")
    public ResponseEntity addPacient(@RequestBody PacientDto pacientDto){
        pacientService.addNewPacient(pacientDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deletePacient/{id}")
    public ResponseEntity deletePacient(@PathVariable("id") Long id){
        pacientService.deletePacient(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updatePacient")
    public ResponseEntity updatePacient(@RequestBody PacientDto pacientDto){
        pacientService.updatePacient(pacientDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
