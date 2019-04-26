package core.data;

import core.AppEngine;
import core.data.exceptions.*;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class User{

    //Requested
    private String name;
    private String email;
    private String pwd;
    private String birthday;
    private String location;

    //Optionnals
    private String address;
    private String phone;



    /**
     * Constructor of USer
     * @param name String
     * @param email String
     * @param pwd String
     * @param birthday String
     * @param location String
     * @param address String
     * @param phone String
     * @throws InvalidEmailException Email invalid format
     * @throws InvalidPhoneNumberException Phone invalid format
     * @throws BadGeographicLocationException Need to be France
     * @throws MinimumAgeRequiredException Need to have more than 18
     * @throws EmptyFieldException The field need to dont be empty
     */
    public User(String name, String email, String pwd, String birthday, String location, String address, String phone) throws InvalidEmailException, InvalidPhoneNumberException, BadGeographicLocationException, MinimumAgeRequiredException, EmptyFieldException {

        //Validating Data
        if(name.equals("")){
            throw new EmptyFieldException("name");
        }else{
            this.name = name;
        }

        if (pwd.equals("")){
            throw new EmptyFieldException("password");
        }else{
            this.pwd = encode(pwd);
        }

        if (valideEmail(email)){
            this.email = email;
        }else{
            throw new InvalidEmailException();
        }

        if(valideLocation(location)){
            this.location = location;
        }else{
            throw new BadGeographicLocationException();
        }

        LocalDate birthdayDate = converteToDate(birthday);
        if (valideAge(birthdayDate)){
            this.birthday = birthday;
        }else{
            throw new MinimumAgeRequiredException();
        }


        // Optionnals fields
        this.address = Optional.ofNullable(address)
                .map(String::trim)
                .filter(s -> s.length() > 0)
                .orElse("NULL");

        String phoneNumber = Optional.ofNullable(phone)
                .map(String::trim)
                .filter(s -> s.length() > 0)
                .orElse("NULL");

        if (phoneNumber != "NULL"){
            if(validePhone(phoneNumber)){
                this.phone = phone;
            }else{
                throw new InvalidPhoneNumberException();
            }
        }


    }

    public User(User user) throws InvalidEmailException, EmptyFieldException,  BadGeographicLocationException, InvalidPhoneNumberException, MinimumAgeRequiredException {
        this(user.name,user.email,user.pwd,user.birthday,user.location,user.address,user.phone);
    }

    /**
     * Empty constructor for testing and correct @Data init
     */
    public User() {
    }


    //Age part

    /**
     * Get the age with a Date
     * @param birthDate LocalDate
     * @return int the age
     */
    public int calculateAge(LocalDate birthDate) {
        return _calculateAge(birthDate,LocalDate.now());
    }

    /**
     * intermediate function for {@link #calculateAge(LocalDate) calculateAge}
     * @param birthDate LocalDate
     * @param currentDate LocalDate
     * @return int the age
     */
    private int _calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    /**
     * To convert a String into a LocalDate
     * @param birthday int as "dd/MM/yy" like "01/01/2000"
     * @return LocalDate
     */
    public LocalDate converteToDate(String birthday){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);

        return localDate;
    }

    /**
     * To validate the Age
     * @param birthday LocalDate
     * @return boolean
     */
    public boolean valideAge(LocalDate birthday){
        return calculateAge(birthday) > 18;
    }

    // Location part

    /**
     * To validate the location
     * @param location String here need to be "france"
     * @return boolean
     */
    public boolean valideLocation(String location){
        return location.toLowerCase().contains("france");
    }

    //Phone part

    /**
     * To validate FRENCH Phone number
     * @param phone String phone number
     * @return boolean
     */
    public boolean validePhone(String phone){
        Pattern pattern = Pattern.compile("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$");
        Matcher matcher = pattern.matcher(phone);
        return (matcher.find() && matcher.group().equals(phone));
    }

    //Email part

    /**
     * To validate the Email
     * @param email String email
     * @return boolean
     */
    public boolean valideEmail(String email){
        Pattern pattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Matcher matcher = pattern.matcher(email);
        return (matcher.find() && matcher.group().equals(email));
    }

    //Encoding password part

    /**
     * To encode the password as Sha256
     * @param pwd String clear password
     * @return String encoded password
     */
    private String encode(String pwd){
        return DigestUtils.sha256Hex(pwd);
    }

    //Getters


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                " name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birthday=" + birthday +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
