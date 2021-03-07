package HospitalManagement.com.HospitalMAnagement.controller;

import HospitalManagement.com.HospitalMAnagement.dto.AddressDto;
import HospitalManagement.com.HospitalMAnagement.service.AdressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class AddressController {

    @Autowired
    AdressServiceImpl addressService;

    @GetMapping("/getListOfAddress")
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        List<AddressDto> addressDtoList = addressService.getAllAddress();
        return new ResponseEntity(addressDtoList, HttpStatus.OK);
    }

    @GetMapping("/getAddress/{id}")
     public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id){
       AddressDto addressDto= addressService.getAddressByID(id);
       return new ResponseEntity (addressDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/addAdress")
    public ResponseEntity addAddress(@RequestBody AddressDto addressDto){
        addressService.addAddress(addressDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity updateAddress(@RequestBody AddressDto addressDto){
        addressService.updateAdreess(addressDto);
         return new ResponseEntity(HttpStatus.OK);
    }

}
