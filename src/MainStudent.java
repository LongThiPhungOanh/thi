import service.ManagerStudent;
import java.util.Scanner;
public class MainStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerStudent student = new ManagerStudent();
        boolean check = true;
        while (check) {
            try {
                System.out.println("-----------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN------------");
                System.out.println("          chọn chức năng theo số để tiếp tục         ");
                System.out.println("          1. Xem danh sách sinh viên                 ");
                System.out.println("          2. Thêm mới                                ");
                System.out.println("          3. Cập nhật                                ");
                System.out.println("          4. Xóa                                     ");
                System.out.println("          5. Sắp xếp                                 ");
                System.out.println("          6. Đọc từ file                             ");
                System.out.println("          7. Ghi vào file                            ");
                System.out.println("          8. Thoát                                   ");
                System.out.println("-----------------------------------------------------");
                System.out.println("               Lựa chọn của bạn :                    ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        student.showStudent();
                        break;
                    case 2:
                        student.addStudent(student.input());
                        break;
                    case 3:
                        student.updateStudent();
                        break;
                    case 4:
                        student.deleteStudent();
                        break;
                    case 5:
                        student.menu();
                        break;
                    case 6:
                        break;
                    case 7:
                        student.write(student.getStudentList());
                        break;
                    case 8:
                        check = false;
                        break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
