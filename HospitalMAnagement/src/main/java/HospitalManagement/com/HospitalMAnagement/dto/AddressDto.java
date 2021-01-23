package HospitalManagement.com.HospitalMAnagement.dto;

import HospitalManagement.com.HospitalMAnagement.model.PersonModel;

public class AddressDto {
    private long id;

    private String address;
    private String city;
    private String email;
    private String noTel;
    private PersonModel personModel;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getNoTel() {
        return noTel;
    }

    public void setNoTel( String noTel ) {
        this.noTel = noTel;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel( PersonModel personModel ) {
        this.personModel = personModel;
    }
}
