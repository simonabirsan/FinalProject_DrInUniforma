package POJO;

import jakarta.xml.bind.annotation.XmlElement;

public class RegistrationDetailsModel {
    private String lastname;
    private String firstname;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String county;
    private String password;
    private String confirmPassword;

    public RegistrationDetailsModel() {
    }

    public RegistrationDetailsModel(String lastname, String firstname, String phone, String email, String address,
                                    String city, String county, String password, String confirmPassword) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.county = county;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLastname() {
        return lastname;
    }

    @XmlElement
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @XmlElement
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    @XmlElement
    public void setCounty(String county) {
        this.county = county;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @XmlElement
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
