package HospitalManagement.com.HospitalMAnagement.controller;


import HospitalManagement.com.HospitalMAnagement.dto.MedicalServiceDto;
import HospitalManagement.com.HospitalMAnagement.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class MedicalServiceController {

    @Autowired
    MedicalServiceService medicalServiceService;

    @GetMapping("/getAllMedicalServices")
    public ResponseEntity<List<MedicalServiceDto>> getAll() {
        List<MedicalServiceDto> medicalServiceDtoList = medicalServiceService.getAllMedicalService();
        return new ResponseEntity(medicalServiceDtoList, HttpStatus.OK);
    }

    @GetMapping("/getMedicalService/{id}")
    public ResponseEntity<MedicalServiceDto> findById( @PathVariable("id") Long id ) {
        MedicalServiceDto medicalServiceDto = medicalServiceService.getMedicalServiceById(id);
        return new ResponseEntity(medicalServiceDto, HttpStatus.OK);
    }

    @PostMapping("/addMedicalService")
    public ResponseEntity addMedicalService(@RequestBody MedicalServiceDto medicalServiceDto){
        medicalServiceService.addNewMedicalService(medicalServiceDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteMedicalService/{id}")
    public ResponseEntity deleteMedicalService(@PathVariable("id") Long id){
        medicalServiceService.deleteMedicalService(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateMedicalService")
    public ResponseEntity updateMedicalService(@RequestBody MedicalServiceDto medicalServiceDto){
        medicalServiceService.updateMedicalService(medicalServiceDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
