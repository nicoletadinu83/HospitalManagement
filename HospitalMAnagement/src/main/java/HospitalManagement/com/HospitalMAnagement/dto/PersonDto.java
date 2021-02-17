package HospitalManagement.com.HospitalMAnagement.dto;

import HospitalManagement.com.HospitalMAnagement.model.AddressModel;
import HospitalManagement.com.HospitalMAnagement.model.PersonType;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class PersonDto {
    private long id;

    private String firstName;
    private String lastName;
    private PersonType gender; /* F/M*/
    private int age;
    private String userName;
    private String password;
    private AddressDto addressDto;
    private List<ConsultationSchedulingDto> doctorConsultationSchedulingDtoList = new ArrayList<>();
    private List<ConsultationSchedulingDto> pacientConsultationSchedulingDtoList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonType getGender() {
        return gender;
    }

    public void setGender(PersonType gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
