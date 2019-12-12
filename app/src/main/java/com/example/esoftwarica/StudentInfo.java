package com.example.esoftwarica;

public class StudentInfo {

    private String Name;
    private String Age;
    private String Location;
    private String Gender;
    private int ImageId;

    /**
     * Constructor
     */
    public StudentInfo(String name, String Age, String Location, String Gender, int ImageId){
        this.Name = name;
        this.Age = Age;
        this.Location = Location;
        this.Gender = Gender;
        this.ImageId = ImageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

}
