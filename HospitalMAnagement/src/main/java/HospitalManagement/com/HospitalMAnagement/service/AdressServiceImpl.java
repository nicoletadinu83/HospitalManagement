package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.AddressDto;
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
public class AdressServiceImpl implements AdressService {

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<AddressDto> getAllAddress() {

        List<AddressModel> addressModelList = adressRepository.findAll();
        List<AddressDto> addressDtoList = new ArrayList<>();

        for (AddressModel addressModel : addressModelList) {
            AddressDto addressDto = new AddressDto();
            addressDto.setId(addressModel.getId());
            addressDto.setAddress(addressModel.getAddress());
            addressDto.setCity(addressModel.getCity());
            addressDto.setEmail(addressModel.getEmail());
            addressDto.setNoTel(addressModel.getNoTel());

            Long id = addressModel.getPerson().getId();
            Optional<PersonModel> personModel = personRepository.findById(id);
            PersonDto personDto = new PersonDto();
            personDto.setId(personModel.get().getId());
            personDto.setFirstName(personModel.get().getFirstName());
            personDto.setLastName(personModel.get().getLastName());
            personDto.setAge(personModel.get().getAge());
            personDto.setUserName(personModel.get().getUserName());
            personDto.setPassword(personModel.get().getPassword());
            personDto.setGender(personModel.get().getGender());
            personDto.setAddressDto(addressDto);

            addressDto.setPersonDto(personDto);
            addressDtoList.add(addressDto);
        }

        return addressDtoList;
    }

    @Override
    public AddressDto getAddressByID(Long id) {
        Optional<AddressModel> addressModel = adressRepository.findById(id);
        AddressDto addressDto = new AddressDto();
        addressDto.setId(addressModel.get().getId());
        addressDto.setEmail(addressModel.get().getEmail());
        addressDto.setCity(addressModel.get().getCity());
        addressDto.setAddress(addressModel.get().getAddress());
        addressDto.setNoTel(addressModel.get().getNoTel());

        PersonDto personDto = new PersonDto();
        Long id1 = addressModel.get().getPerson().getId();
        Optional<PersonModel> personModel = personRepository.findById(id1);
        if (personModel.isPresent()) {
            personDto.setId(personModel.get().getId());
            ;
            personDto.setGender(personModel.get().getGender());
            personDto.setPassword(personModel.get().getPassword());
            personDto.setUserName(personModel.get().getUserName());
            personDto.setAge(personModel.get().getAge());
            personDto.setFirstName(personModel.get().getFirstName());
            personDto.setLastName(personModel.get().getLastName());
        }

        addressDto.setPersonDto(personDto);

        return addressDto;

    }

    @Override
    public void deleteAddress(Long id) {
        adressRepository.deleteById(id);

    }

    @Override
    public void addAddress(AddressDto addressDto) {
        AddressModel addressModel = new AddressModel();
        addressModel.setId(addressDto.getId());
        addressModel.setNoTel(addressDto.getNoTel());
        addressModel.setCity(addressDto.getCity());
        addressModel.setEmail(addressDto.getEmail());
        addressModel.setAddress(addressDto.getAddress());

        PersonDto personDto = addressDto.getPersonDto();
        PersonModel personModel = new PersonModel();
        personModel.setId(personDto.getId());
        personModel.setAge(personDto.getAge());
        personModel.setUserName(personDto.getUserName());
        personModel.setGender(personDto.getGender());
        personModel.setPassword(personDto.getPassword());
        personModel.setFirstName(personDto.getFirstName());
        personModel.setLastName(personDto.getLastName());

        addressModel.setPerson(personModel);
        adressRepository.save(addressModel);

    }

    @Override
    public void updateAdreess(AddressDto addressDto) {
        Optional<AddressModel> addressModel = adressRepository.findById(addressDto.getId());
        if (addressModel.isPresent()) {
            addressModel.get().setId(addressDto.getId());
            addressModel.get().setAddress(addressDto.getAddress());
            addressModel.get().setEmail(addressDto.getEmail());
            addressModel.get().setCity(addressDto.getCity());
            addressModel.get().setNoTel(addressDto.getNoTel());

            Long id = addressDto.getPersonDto().getId();
            Optional<PersonModel> personModelOptional = personRepository.findById(id);
            if (personModelOptional.isPresent()) {
                PersonModel personModel = personModelOptional.get();
                addressModel.get().setPerson(personModel);

            }

        }
    }

}