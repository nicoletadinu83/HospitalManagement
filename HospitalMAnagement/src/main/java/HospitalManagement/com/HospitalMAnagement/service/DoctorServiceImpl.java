package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.model.DoctorModel;
import HospitalManagement.com.HospitalMAnagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<DoctorModel> doctorModelList = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (DoctorModel doctorModel : doctorModelList) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(doctorModel.getId());
            doctorDto.setMedicalFacilityName(doctorDto.getMedicalFacilityName());
            doctorDto.setField(doctorDto.getField());
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }

    @Override
    public DoctorDto getDoctorById( Long id ) {
        Optional<DoctorModel> doctorModel = doctorRepository.findById(id);
        if (doctorModel.isPresent()) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(doctorModel.get().getId());
            doctorDto.setField(doctorModel.get().getField());
            doctorDto.setMedicalFacilityName(doctorModel.get().getMedicalFacilityName());
            return doctorDto;
        }
        return null;
    }

    @Override
    public void updateDoctor( DoctorDto doctorDto ) {
        Optional<DoctorModel> foundDoctorModel = doctorRepository.findById(doctorDto.getId());

        if(foundDoctorModel.isPresent()){
            DoctorModel doctorModel = foundDoctorModel.get();
            doctorModel.setField(doctorDto.getField());
            doctorModel.setMedicalFacilityName(doctorDto.getMedicalFacilityName());
            doctorRepository.saveAndFlush(doctorModel);
        }
    }

    @Override
    public void deleteDoctor( Long id ) {
        doctorRepository.deleteById(id);

    }

    @Override
    public void addNewDoctor( DoctorDto newDoctorDto ) {
        DoctorModel doctorModel = new DoctorModel();
        doctorModel.setId(newDoctorDto.getId());
        doctorModel.setField(newDoctorDto.getField());
        doctorModel.setMedicalFacilityName(newDoctorDto.getMedicalFacilityName());
        doctorRepository.save(doctorModel);
    }
}
