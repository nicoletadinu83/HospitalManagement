package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")

public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private PersonType gender; /* F/M*/
    private int age;
    private String userName;
    private String password;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressModel addressModel;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultationSchedulingModel> doctorConsultationList= new ArrayList<>();

    @OneToMany(mappedBy = "pacient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultationSchedulingModel> pacientConsultationList = new ArrayList<>();



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

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public List<ConsultationSchedulingModel> getDoctorConsultationList() {
        return doctorConsultationList;
    }

    public void setDoctorConsultationList( List<ConsultationSchedulingModel> doctorConsultationList ) {
        this.doctorConsultationList = doctorConsultationList;
    }

    public List<ConsultationSchedulingModel> getPacientConsultationList() {
        return pacientConsultationList;
    }

    public void setPacientConsultationList( List<ConsultationSchedulingModel> pacientConsultationList ) {
        this.pacientConsultationList = pacientConsultationList;
    }
}
