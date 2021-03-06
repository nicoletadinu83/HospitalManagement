package HospitalManagement.com.HospitalMAnagement.controller;


import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/getDoctorsList")
    public ResponseEntity<List<DoctorDto>> getAll() {
        List<DoctorDto> doctorDtoList = doctorService.getAllDoctors();
        return new ResponseEntity(doctorDtoList, HttpStatus.OK);
    }

    @GetMapping("/getDoctor/{id}")
    public ResponseEntity<DoctorDto> findById( @PathVariable("id") Long id ) {
        DoctorDto doctorDto = doctorService.getDoctorById(id);
        return new ResponseEntity(doctorDto, HttpStatus.OK);
    }

    @GetMapping("/findAllDoctorsDetails")
    public ResponseEntity<List<DoctorDto>> findAllDoctorsDetails(){
        List<DoctorDto> doctorDtoWithDetailsList = doctorService.findAllDoctorsDetails();
        return new ResponseEntity(doctorDtoWithDetailsList, HttpStatus.OK);
    }

    @PostMapping("/addDoctor")
    public ResponseEntity addDoctor(@RequestBody DoctorDto doctorDto){
        doctorService.addNewDoctor(doctorDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateDoctor")
    public ResponseEntity updateDoctor(@RequestBody DoctorDto doctorDto){
        doctorService.updateDoctor(doctorDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
