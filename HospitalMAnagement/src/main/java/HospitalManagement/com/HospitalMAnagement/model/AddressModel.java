package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;
    private String city;
    private String email;
    private String noTel;

    @OneToOne/*(fetch = FetchType.LAZY)*/
    private PersonModel person;

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

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson( PersonModel person ) {
        this.person = person;
    }
}
