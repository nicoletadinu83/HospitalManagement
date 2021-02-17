package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.*;
import HospitalManagement.com.HospitalMAnagement.model.*;
import HospitalManagement.com.HospitalMAnagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AdressRepository adressRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PacientRepository pacientRepository;
    @Autowired
    ConsultationSchedulingRepository consultationSchedulingRepository;

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<DoctorModel> doctorModelList = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (DoctorModel doctorModel : doctorModelList) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(doctorModel.getId());
            doctorDto.setFirstName(doctorModel.getFirstName());
            doctorDto.setLastName(doctorModel.getLastName());
            doctorDto.setGender(doctorModel.getGender());
            doctorDto.setAge(doctorModel.getAge());
            doctorDto.setPassword(doctorModel.getPassword());

            AddressDto adressDto = new AddressDto();
            if (doctorModel.getAddressModel() != null) {
                Optional<AddressModel> addressModel = adressRepository.findById(doctorModel.getAddressModel().getId());
                if (addressModel.isPresent()) {
                    adressDto.setId(addressModel.get().getId());
                    adressDto.setAddress(addressModel.get().getAddress());
                    adressDto.setCity(addressModel.get().getCity());
                    adressDto.setEmail(addressModel.get().getEmail());
                    adressDto.setNoTel(addressModel.get().getNoTel());

                } else
                    return null;
            }

            doctorDto.setAddressDto(adressDto);
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }


     public List<PacientDto> getAllPacients() {
        List<PacientModel> pacientModelList = pacientRepository.findAll();
        List<PacientDto> pacientDtoList = new ArrayList<>();
        for (PacientModel pacientModel : pacientModelList) {
            PacientDto pacientDto = new PacientDto();
            pacientDto.setId(pacientModel.getId());
            pacientDto.setFirstName(pacientModel.getFirstName());
            pacientDto.setLastName(pacientModel.getLastName());
            pacientDto.setGender(pacientModel.getGender());
            pacientDto.setAge(pacientModel.getAge());
            pacientDto.setPassword(pacientModel.getPassword());

            AddressDto adressDto = new AddressDto();
            if (pacientModel.getAddressModel() != null) {
                Optional<AddressModel> addressModel = adressRepository.findById(pacientModel.getAddressModel().getId());
                if (addressModel.isPresent()) {
                    adressDto.setId(addressModel.get().getId());
                    adressDto.setAddress(addressModel.get().getAddress());
                    adressDto.setCity(addressModel.get().getCity());
                    adressDto.setEmail(addressModel.get().getEmail());
                    adressDto.setNoTel(addressModel.get().getNoTel());

                } else
                    return null;

                pacientDto.setAddressDto(adressDto);
                pacientDtoList.add(pacientDto);
            }
        }
        return pacientDtoList;
        }


    /*public List<PersonDto> getAllPacients() {
        List<PersonModel> personModelList = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        for (PersonModel personModel : personModelList) {
            PersonDto personDto = new PersonDto();
            personDto.setId(personModel.getId());
            personDto.setFirstName(personModel.getFirstName());
            personDto.setLastName(personModel.getLastName());
            personDto.setGender(personModel.getGender());
            personDto.setAge(personModel.getAge());
            personDto.setPassword(personModel.getPassword());

            AddressDto adressDto = new AddressDto();
            if (personModel.getAddressModel() != null) {
                Optional<AddressModel> addressModel = adressRepository.findById(personModel.getAddressModel().getId());
                if (addressModel.isPresent()) {
                    adressDto.setId(addressModel.get().getId());
                    adressDto.setAddress(addressModel.get().getAddress());
                    adressDto.setCity(addressModel.get().getCity());
                    adressDto.setEmail(addressModel.get().getEmail());
                    adressDto.setNoTel(addressModel.get().getNoTel());

                } else
                    return null;

                personDto.setAddressDto(adressDto);
                personDtoList.add(personDto);
            }
        }
        return personDtoList;
        }
        */




    @Override
    public DoctorDto getDoctorById(Long id) {
        Optional<DoctorModel> doctorModel = doctorRepository.findById(id);
        if (doctorModel.isPresent()) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(doctorModel.get().getId());
            doctorDto.setField(doctorModel.get().getField());
            doctorDto.setAge(doctorModel.get().getAge());
            doctorDto.setFirstName(doctorModel.get().getFirstName());
            doctorDto.setLastName(doctorModel.get().getLastName());
            doctorDto.setGender(doctorModel.get().getGender());
            doctorDto.setPassword(doctorModel.get().getPassword());
            doctorDto.setUserName(doctorModel.get().getUserName());
            doctorDto.setMedicalFacilityName(doctorModel.get().getMedicalFacilityName());

            AddressDto addressDto = new AddressDto();
            AddressModel addressModel = doctorModel.get().getAddressModel();
            addressDto.setId(addressModel.getId());
            addressDto.setNoTel(addressModel.getNoTel());
            addressDto.setEmail(addressModel.getEmail());
            addressDto.setCity(addressModel.getCity());
            addressDto.setAddress(addressModel.getAddress());

            long id1 = addressModel.getPerson().getId();
            PersonDto personDto = new PersonDto();
            Optional<PersonModel> personModel = personRepository.findById(id1);
            personDto.setId(personModel.get().getId());

            addressDto.setPersonDto(personDto);
            doctorDto.setAddressDto(addressDto);

            return doctorDto;
        }

        return null;
    }


    @Override
    public PacientDto getPacientById(Long id) {
        Optional<PacientModel> pacientModel = pacientRepository.findById(id);
        if (pacientModel.isPresent()) {
            PacientDto pacientDto = new PacientDto();
            pacientDto.setId(pacientModel.get().getId());
            pacientDto.setDisease(pacientModel.get().getDisease());
            pacientDto.setAge(pacientModel.get().getAge());
            pacientDto.setFirstName(pacientModel.get().getFirstName());
            pacientDto.setLastName(pacientModel.get().getLastName());
            pacientDto.setGender(pacientModel.get().getGender());
            pacientDto.setPassword(pacientModel.get().getPassword());
            pacientDto.setUserName(pacientModel.get().getUserName());

            AddressDto addressDto = new AddressDto();
            long id2 = pacientModel.get().getAddressModel().getId();
            Optional<AddressModel> addressModelFound = adressRepository.findById(id2);
            if (addressModelFound.isPresent()) {
                AddressModel addressModel = addressModelFound.get();

                addressDto.setId(addressModel.getId());
                addressDto.setAddress(addressModel.getAddress());
                addressDto.setCity(addressModel.getCity());
                addressDto.setEmail(addressModel.getEmail());
                addressDto.setNoTel(addressModel.getNoTel());

                PersonDto personDto = new PersonDto();
                long id3 = addressModel.getPerson().getId();
                Optional<PersonModel> personModel = personRepository.findById(id3);
                if (personModel.isPresent()) {
                    personDto.setId(pacientModel.get().getId());
                }
                addressDto.setPersonDto(personDto);
            }

            pacientDto.setAddressDto(addressDto);
            return pacientDto;
        }


        return null;
    }

    @Override
    public void addPerson(PersonDto personDto) {
        PersonModel personModel = new PersonModel();
        personModel.setId(personDto.getId());
        personModel.setFirstName(personDto.getFirstName());
        personModel.setLastName(personDto.getLastName());
        personModel.setAge(personDto.getAge());
        personModel.setGender(personDto.getGender());
        personModel.setUserName(personDto.getUserName());
        personModel.setPassword(personDto.getPassword());

        AddressModel adressModel = new AddressModel();
        if (personDto.getAddressDto() != null) {
            Optional<AddressModel> addressDto = adressRepository.findById(personDto.getAddressDto().getId());
            if (addressDto.isPresent()) {
                adressModel.setId(addressDto.get().getId());
                adressModel.setAddress(addressDto.get().getAddress());
                adressModel.setCity(addressDto.get().getCity());
                adressModel.setEmail(addressDto.get().getEmail());
                adressModel.setNoTel(addressDto.get().getNoTel());
                adressModel.setPerson(addressDto.get().getPerson());
            }
            personModel.setAddressModel(adressModel);
        }
        personRepository.save(personModel);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePerson(PersonDto personDto) {

        Optional<PersonModel> personFind = personRepository.findById(personDto.getId());

        if (personFind != null) {
            personFind.get().setId(personDto.getId());
            personFind.get().setFirstName(personDto.getFirstName());
            personFind.get().setLastName(personDto.getLastName());
            personFind.get().setPassword(personDto.getPassword());
            personFind.get().setGender(personDto.getGender());
            personFind.get().setUserName(personDto.getUserName());
            personFind.get().setAge(personDto.getAge());

            AddressDto addressDto = new AddressDto();
            if (addressDto != null) {
                Optional<AddressModel> addressModel = adressRepository.findById(personFind.get().getAddressModel().getId());
                if (addressModel.isPresent()) {
                    addressModel.get().setId(addressDto.getId());
                    addressModel.get().setAddress(addressDto.getAddress());
                    addressModel.get().setNoTel(addressDto.getNoTel());
                    addressModel.get().setEmail(addressDto.getEmail());
                    addressModel.get().setCity(addressDto.getCity());
                    personFind.get().setAddressModel(addressModel.get());
                }
            }
        }
        personRepository.save(personFind.get());
    }

    @Override
    public List<ConsultationSchedulingDto> getAllConsultationForDoctor( Long id ) {
        Optional<PersonModel> personModel = personRepository.findById(id);
        if(personModel.isPresent()){
            List<ConsultationSchedulingModel> consultationSchedulingModelList = personModel.get().getDoctorConsultationSchedulingList();
            List<ConsultationSchedulingDto> consultationSchedulingDtoList= new ArrayList<>();
            for(ConsultationSchedulingModel consultations : consultationSchedulingModelList){
                ConsultationSchedulingDto consultationSchedulingDto = new ConsultationSchedulingDto();
                consultationSchedulingDto.setId(consultations.getId());
                consultationSchedulingDto.setSchedulingDate(consultations.getSchedulingDate());
                consultationSchedulingDtoList.add(consultationSchedulingDto);
            }
            return consultationSchedulingDtoList;
        }
        return null;
    }

    @Override
    public List<ConsultationSchedulingDto> getAllConsultationForPacient( Long id ) {
        Optional<PersonModel> personModel = personRepository.findById(id);
        if(personModel.isPresent()){
            List<ConsultationSchedulingModel> consultationSchedulingModelList = personModel.get().getPacientConsultationSchedulingList();
            List<ConsultationSchedulingDto> consultationSchedulingDtoList= new ArrayList<>();
            for(ConsultationSchedulingModel consultations : consultationSchedulingModelList){
                ConsultationSchedulingDto consultationSchedulingDto = new ConsultationSchedulingDto();
                consultationSchedulingDto.setId(consultations.getId());
                consultationSchedulingDto.setSchedulingDate(consultations.getSchedulingDate());
                consultationSchedulingDtoList.add(consultationSchedulingDto);
            }
            return consultationSchedulingDtoList;
        }
        return null;
    }

}
