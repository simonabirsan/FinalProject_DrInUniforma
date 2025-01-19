package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrationModel {
    private RegistrationDetailsModel registrationDetailsModel;
    private String registerError;

    public RegistrationModel() {
    }

    public RegistrationModel(String lastname, String firstname, String phone, String email, String address,
                             String city, String county, String password, String confirmPassword,
                             String registerError) {
        this.registrationDetailsModel = new RegistrationDetailsModel(lastname, firstname, phone, email,
                address, city, county, password, confirmPassword);
        this.registerError = registerError;
    }

    public RegistrationDetailsModel getRegistrationDetailsModel() {
        return registrationDetailsModel;
    }

    @XmlElement
    public void setRegistrationDetailsModel(RegistrationDetailsModel registrationDetailsModel) {
        this.registrationDetailsModel = registrationDetailsModel;
    }

    public String getRegisterError() {
        return registerError;
    }

    @XmlElement
    public void setRegisterError(String registerError) {
        this.registerError = registerError;
    }

    @Override
    public String toString() {
        return "RegistrationModel: {" +
                "registrationDetailsModel: \n \t lastname: " + registrationDetailsModel.getLastname() +
                ", \n \t firstname: " + registrationDetailsModel.getFirstname() + ",\n \t phone: " + registrationDetailsModel.getPhone() +
                ",\n \t email: " + registrationDetailsModel.getEmail() + ",\n \t address: " + registrationDetailsModel.getAddress() +
                ",\n \t city: " + registrationDetailsModel.getCity() + ",\n \t county: " + registrationDetailsModel.getCounty() +
                ", \n \t password: " + registrationDetailsModel.getPassword() + ", \n \t confirmPassword: " + registrationDetailsModel.getConfirmPassword() +
                "\n }, \n registerError: " + registerError + "\n}";
    }
}

