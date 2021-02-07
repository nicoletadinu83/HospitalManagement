package HospitalManagement.com.HospitalMAnagement.model;

import javax.persistence.*;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_consultation",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name="person_id)") )
    List<ConsultationSchedulingModel> doctorConsultationSchedulingList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="pacient_consultation",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    List<ConsultationSchedulingModel> pacientConsultationSchedulingList;

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

    public List<ConsultationSchedulingModel> getDoctorConsultationSchedulingList() {
        return doctorConsultationSchedulingList;
    }

    public void setDoctorConsultationSchedulingList( List<ConsultationSchedulingModel> doctorConsultationSchedulingList ) {
        this.doctorConsultationSchedulingList = doctorConsultationSchedulingList;
    }

    public List<ConsultationSchedulingModel> getPacientConsultationSchedulingList() {
        return pacientConsultationSchedulingList;
    }

    public void setPacientConsultationSchedulingList( List<ConsultationSchedulingModel> pacientConsultationSchedulingList ) {
        this.pacientConsultationSchedulingList = pacientConsultationSchedulingList;
    }
}
