package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.AddressDto;
import HospitalManagement.com.HospitalMAnagement.dto.DoctorDto;
import HospitalManagement.com.HospitalMAnagement.dto.PacientDto;
import HospitalManagement.com.HospitalMAnagement.dto.PersonDto;
import HospitalManagement.com.HospitalMAnagement.model.AddressModel;
import HospitalManagement.com.HospitalMAnagement.model.PersonModel;
import HospitalManagement.com.HospitalMAnagement.repository.AdressRepository;
import HospitalManagement.com.HospitalMAnagement.repository.PersonRepository;
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


    @Override
    public DoctorDto getAllDoctors() {
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
            }

            personDto.setAddressDto(adressDto);
            personDtoList.add(personDto);
        }
        return (DoctorDto) personDtoList;
    }

    public PacientDto getAllPacients() {
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
        return (PacientDto) personDtoList;
    }

    @Override
    public DoctorDto getDoctorById(Long id) {


        return null;
    }


    @Override
    public PacientDto getPacientById(Long id) {
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

}