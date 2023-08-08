package service;
import Model.Student;
import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class ManagerStudent {
    List<Student> studentList;
    private final Scanner input = new Scanner(System.in);
    private static final String PATH = "src/file/student.csv";
    public ManagerStudent(){
        studentList = read();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void showStudent() {
        if (studentList.size() > 0) {
            for (Student value : studentList) {
                System.out.println(value);
            }
        } else {
            System.out.println("Hiện tại không có sinh viên");
        }
    }
    public Student input() {
        Student student = null;
        boolean check = true;
        try {
            System.out.println("Nhập mã sinh viên");
            String idCode = input.nextLine();
            for (Student value: studentList) {
                if (value.getIdCode().equals(idCode)){
                    System.out.println("Mã sinh viên đã tồn tại");
                    check = false;
                    break;
                }
            } if (check){
                System.out.println("Nhập tên sinh viên");
                String name = input.nextLine();
                System.out.println("Nhập tuổi sinh viên");
                int age = Integer.parseInt(input.nextLine());
                System.out.println("Nhập giới tính sinh viên");
                String gender = input.nextLine();
                System.out.println("Nhập địa chỉ nơi sinh viên sống");
                String address = input.nextLine();
                System.out.println("Nhập điểm trung bình của sinh viên");
                double avgPoint = Double.parseDouble(input.nextLine());
                student = new Student(idCode, name, age, gender, address, avgPoint);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
    public void addStudent(Student student){
        if (student != null){
            studentList.add(student);
            System.out.println("Thêm thành công");
//            write(studentList);
//            studentList = read();
        } else {
            System.out.println("Thông tin nhập không đúng");
        }
    }
    public void updateStudent(){
        int checkId = -1;
        try {
            System.out.println("Nhập mã sinh viên bạn muốn sửa");
            String id = input.nextLine();
            for (int i = 0; i < studentList.size() ; i++) {
                if (studentList.get(i).getIdCode().equals(id)){
                    checkId = i;
                    break;
                }
            } if (checkId < 0){
                System.out.println("Mã sinh viên không tồn tại");
            } else {
                Student student = input();
                if (student != null){
                    studentList.get(checkId).setIdCode(student.getIdCode());
                    studentList.get(checkId).setName(student.getName());
                    studentList.get(checkId).setAge(student.getAge());
                    studentList.get(checkId).setAddress(student.getAddress());
                    studentList.get(checkId).setAvgPoint(student.getAvgPoint());
                    studentList.get(checkId).setGender(student.getGender());
                    System.out.println("Sửa thành công");
//                    write(studentList);
//                    studentList = read();
                } else {
                    System.out.println("Thông tin nhập không đúng");
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteStudent(){
        try {
            boolean check = true;
            System.out.println("Nhập mã sinh viên bạn muốn xóa");
            String id = input.nextLine();
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getIdCode().equals(id)) {
                    System.out.println("Bạn có chắc chắn muốn xóa");
                    System.out.println("1.Y / 2.N");
                    String YN = input.nextLine();
                    if (YN.equals("Y")) {
                        studentList.remove(i);
                        System.out.println("Xóa thành công");
                        check = false;
                        break;
                    } else {
                        check = false;
                        break;
                    }
                }
            } if (check){
                System.out.println("Mã sinh viên không đúng, vui lòng nhập lại");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void min(){
        Collections.sort(studentList);
        if (studentList != null){
            System.out.println("Sinh viên có số điểm tăng dần");
            for (Student value: studentList) {
                System.out.println(value);
            }
        }

    }
    public void max(){
        studentList.sort(Student::compareTo);
        if (studentList != null){
            System.out.println("Sinh viên có số điểm giảm dần");
            for (Student value: studentList) {
                System.out.println(value);
            }
        }
    }
    public void menu(){
        boolean check = true;
        while (check) {
            System.out.println("1. Sắp xếp giảm dần");
            System.out.println("2. sắp xếp tăng dần");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năg");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> min();
                case 2 -> max();
                case 0 -> check = false;
            }
        }
    }
    public static void write(List<Student> students) {
        try {
            File file = new File(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Student student : students) {
                String value = student.getIdCode() + ","
                        + student.getName() + ","
                        + student.getAge() + ","
                        + student.getGender() + ","
                        + student.getAddress() + ","
                        + student.getAvgPoint() + "\n";
                bufferedWriter.write(value);
            }
            bufferedWriter.close();
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> read() {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(PATH);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Student student = new Student(
                        strings[0],
                        strings[1],
                        Integer.parseInt(strings[2]),
                        strings[3],
                        strings[4],
                        Double.parseDouble(strings[5]));
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
    public void readStudent(){
        studentList = read();
        System.out.println("Đọc thành công");
    }
    public void writeStudent(){
        write(studentList);
        System.out.println("Ghi thành công");
    }
}
