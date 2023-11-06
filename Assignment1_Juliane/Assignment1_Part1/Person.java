
public class Person {

    private String name;
    private String sin;// 9 digits only (0-9)
    private int age; // between 1 and 150
    private String gender;// female, male, other
    private String address;
    private String phoneNum;// no letters

    // Constructors
    public Person() {
        name = "";
        sin = "";
        age = 0;
        gender = "";
        address = "";
        phoneNum = "";
    }

    // Parametrized constructor
    public Person(String name, String sin, int age, String gender, String address, String phoneNum) {
        this.name = name;
        this.sin = sin;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNum = phoneNum;
    }
    // Getters

    public String getName() {
        return name;
    }

    public String getSin() {
        return sin;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // to String
    // print all variables concatenated...
    // java automatically changes int to String
    public String toString() {
        String stringAge = String.valueOf(this.age);
        return (name + " " + sin + " " + stringAge + " " + gender + " " + address + " " + phoneNum + " ");
    }

}