package Model;
import java.util.Comparator;
public class Student implements Comparator<Student>,Comparable<Student> {
    private String idCode;
    private String name;
    private int age;
    private String gender;
    private String Address;
    private double avgPoint;

    public Student(String idCode, String name, int age, String gender, String address, double avgPoint) {
        this.idCode = idCode;
        this.name = name;
        this.age = age;
        this.gender = gender;
        Address = address;
        this.avgPoint = avgPoint;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idCode='" + idCode + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", Address='" + Address + '\'' +
                ", avgPoint=" + avgPoint +
                '}';
    }


    @Override
    public int compare(Student o1, Student o2) {
        if (o2.getAvgPoint() == o1.avgPoint){
            return o2.getAge() - o1.age;
        }
        return (int) (o2.getAvgPoint() - o1.avgPoint);
    }

        @Override
    public int compareTo(Student o) {
        if (this.avgPoint == o.getAvgPoint()){
            return this.age - o.getAge() ;
        }
        return (int) (this.avgPoint - o.getAvgPoint());
    }
}
