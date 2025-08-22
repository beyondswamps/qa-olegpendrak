package hh;

public class Resume {
    private String gender;
    private int age;
    private String city;
    private boolean isPhoneConfirmed;
    private boolean isReadyToRelocate;

    public Resume(String gender, int age, String city, boolean isPhoneConfirmed, boolean isReadyToRelocate) {
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.isPhoneConfirmed = isPhoneConfirmed;
        this.isReadyToRelocate = isReadyToRelocate;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean isPhoneConfirmed() {
        return isPhoneConfirmed;
    }

    public boolean isReadyToRelocate() {
        return isReadyToRelocate;
    }
}
