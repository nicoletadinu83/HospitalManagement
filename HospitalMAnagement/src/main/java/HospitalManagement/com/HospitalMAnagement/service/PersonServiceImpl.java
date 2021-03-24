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
    public List<PersonDto> getAllPersons() {
        List<PersonModel> personModels = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        for(PersonModel person : personModels){
            PersonDto personDto = new PersonDto();
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setAge(person.getAge());
            personDto.setGender(person.getGender());
            personDto.setPassword(person.getPassword());
            personDto.setUserName(person.getUserName());
            AddressDto addressDto = new AddressDto();
            addressDto.setAddress(person.getAddressModel().getAddress());
            addressDto.setNoTel(person.getAddressModel().getNoTel());
            addressDto.setEmail(person.getAddressModel().getEmail());
            addressDto.setCity(person.getAddressModel().getCity());
            personDto.setAddressDto(addressDto);
            personDtos.add(personDto);
        }
        return personDtos;
    }

    @Override
    public PersonDto getPersonById( Long id ) {
        Optional<PersonModel> personModel = personRepository.findById(id);
        if(personModel.isPresent()){
            PersonDto personDto = new PersonDto();
            personDto.setFirstName(personModel.get().getFirstName());
            personDto.setLastName(personModel.get().getLastName());
            personDto.setAge(personModel.get().getAge());
            personDto.setGender(personModel.get().getGender());
            personDto.setUserName(personModel.get().getUserName());
            personDto.setPassword(personModel.get().getPassword());
            return personDto;
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
    public void addPerson1( PersonDto personDto ) {
        PersonModel personModel = new PersonModel();
        personModel.setId(personDto.getId());
        personModel.setFirstName(personDto.getFirstName());
        personModel.setLastName(personDto.getLastName());
        personModel.setAge(personDto.getAge());
        personModel.setGender(personDto.getGender());
        personModel.setUserName(personDto.getUserName());
        personModel.setPassword(personDto.getPassword());
        personRepository.save(personModel);

        AddressModel addressModel = new AddressModel();
        if (personDto.getAddressDto() != null) {
            AddressDto addressDto = personDto.getAddressDto();
            addressModel.setAddress(addressDto.getAddress());
            addressModel.setCity(addressDto.getCity());
            addressModel.setEmail(addressDto.getEmail());
            addressModel.setNoTel(addressDto.getNoTel());
            addressModel.setPerson(personModel);
            adressRepository.save(addressModel);
        }
    }


    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePerson(PersonDto personDto) {

        Optional<PersonModel> personFind = personRepository.findById(personDto.getId());

        if (personFind.isPresent()) {
            personFind.get().setId(personDto.getId());
            personFind.get().setFirstName(personDto.getFirstName());
            personFind.get().setLastName(personDto.getLastName());
            personFind.get().setPassword(personDto.getPassword());
            personFind.get().setGender(personDto.getGender());
            personFind.get().setUserName(personDto.getUserName());
            personFind.get().setAge(personDto.getAge());

            AddressDto addressDto = personDto.getAddressDto();

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
            List<ConsultationSchedulingModel> consultationSchedulingModelList = personModel.get().getDoctorConsultationList();
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
            List<ConsultationSchedulingModel> consultationSchedulingModelList = personModel.get().getPacientConsultationList();
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
