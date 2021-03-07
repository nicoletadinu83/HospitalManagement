package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.AddressDto;
import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.model.PacientModel;
import HospitalManagement.com.HospitalMAnagement.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacientServiceImpl implements PacientService {

    @Autowired
    PacientRepository pacientRepository;

    @Override
    public List<PacientDto> getAllPacients() {
        List<PacientModel> pacientModelList = pacientRepository.findAll();
        List<PacientDto> pacientDtoList = new ArrayList<>();
        for (PacientModel pacientModel : pacientModelList) {
            PacientDto pacientDto = new PacientDto();
            pacientDto.setId(pacientModel.getId());
            pacientDto.setDisease(pacientModel.getDisease());
            pacientDto.setAge(pacientModel.getAge());
            pacientDtoList.add(pacientDto);
        }
        return pacientDtoList;
    }

    @Override
    public PacientDto getPacientById( Long id ) {
        Optional<PacientModel> pacientModel = pacientRepository.findById(id);
        if (pacientModel.isPresent()) {
            PacientDto pacientDto = new PacientDto();
            pacientDto.setId(pacientModel.get().getId());
            pacientDto.setDisease(pacientModel.get().getDisease());
            pacientDto.setAge(pacientModel.get().getAge());
            return pacientDto;
        }
        return null;
    }

    @Override
    public void updatePacient( PacientDto pacientDto ) {
        Optional<PacientModel> foundPacientModel = pacientRepository.findById(pacientDto.getId());
        if (foundPacientModel.isPresent()) {
            PacientModel pacientModel = foundPacientModel.get();
            pacientModel.setDisease(pacientDto.getDisease());
            pacientModel.setAge(pacientDto.getAge());
            pacientRepository.saveAndFlush(pacientModel);
        }

    }

    @Override
    public void deletePacient( Long id ) {
        pacientRepository.deleteById(id);
    }

    @Override
    public void addNewPacient( PacientDto newPacient ) {
        PacientModel pacientModel = new PacientModel();
        pacientModel.setId(newPacient.getId());
        pacientModel.setAge(newPacient.getAge());
        pacientModel.setDisease(newPacient.getDisease());
        pacientRepository.save(pacientModel);

    }

    @Override
    public List<PacientDto> pacientDetailsList() {
        List<PacientModel> pacientDetailsList = pacientRepository.pacientDetailsList();
        List<PacientDto> pacientDtoList = new ArrayList<>();
        for(PacientModel pacient : pacientDetailsList){
            PacientDto pacientDto = new PacientDto();
            pacientDto.setDisease(pacient.getDisease());
            pacientDto.setFirstName(pacient.getFirstName());
            pacientDto.setLastName(pacient.getLastName());
            pacientDto.setAge(pacient.getAge());
            pacientDto.setGender(pacient.getGender());
            pacientDto.setPassword(pacient.getPassword());
            pacientDto.setUserName(pacient.getUserName());
            AddressDto addressDto = new AddressDto();
            addressDto.setAddress(pacient.getAddressModel().getAddress());
            addressDto.setCity(pacient.getAddressModel().getCity());
            addressDto.setEmail(pacient.getAddressModel().getEmail());
            addressDto.setNoTel(pacient.getAddressModel().getNoTel());
            pacientDto.setAddressDto(addressDto);
            pacientDtoList.add(pacientDto);
        }
        return pacientDtoList;
    }
}
