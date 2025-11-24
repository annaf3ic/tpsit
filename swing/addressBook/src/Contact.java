import java.util.Date;

public class Contact {
    String name;
    String surname;
    String email;
    String mobile;
    String address;
    Date birth;
    
    public Contact(String name, String surname, String email, String mobile, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {return email;}
    public String getMobile() {return mobile;}
    public String getAddress() {return address;}
    public Date getBirth() {return birth;}

    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setMobile(String mobile) {this.mobile = mobile;}
    public void setEmail(String email) {this.email = email;}
    public void setAddress(String address) {this.address = address;}
    public void setBirth(Date birth) {this.birth = birth;}
}