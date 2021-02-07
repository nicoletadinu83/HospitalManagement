package HospitalManagement.com.HospitalMAnagement.controller;

import HospitalManagement.com.HospitalMAnagement.dto.ConsultationSchedulingDto;
import HospitalManagement.com.HospitalMAnagement.service.ConsultationSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ConsultationSchedulingController {

    @Autowired
    ConsultationSchedulingService consultationService;

    @GetMapping("/getConsultationScheduling")
    public ResponseEntity<List<ConsultationSchedulingDto>> getAll() {
        List<ConsultationSchedulingDto> consultationSchedulingDtoList = consultationService.getAllConsultations();
        return new ResponseEntity(consultationSchedulingDtoList, HttpStatus.OK);
    }

    @GetMapping("/getConsultationScheduling/{id}")
    public ResponseEntity<ConsultationSchedulingDto> findById( @PathVariable("id") Long id ) {
        ConsultationSchedulingDto consultationSchedulingDto=consultationService.getConsultationById(id);
        return new ResponseEntity(consultationSchedulingDto, HttpStatus.OK);
    }

    @PostMapping("/addConsultationScheduling")
    public ResponseEntity addConsultationScheduling( @RequestBody ConsultationSchedulingDto consultationSchedulingDto ){
        consultationService.addConsultationScheduling(consultationSchedulingDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteConsultationScheduling/{id}")
    public ResponseEntity deleteConsultationScheduling(@PathVariable("id") Long id){
        consultationService.deleteConsultationScheduling(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateConsultationScheduling")
    public ResponseEntity updateConsultationScheduling(@RequestBody ConsultationSchedulingDto consultationSchedulingDto){
        consultationService.updateConsultationScheduling(consultationSchedulingDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
