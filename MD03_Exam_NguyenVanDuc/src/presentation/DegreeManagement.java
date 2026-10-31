package presentation;

import business.dao.DegreeDaoImpl;
import business.entity.Degree;
import utils.InputData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DegreeManagement {
    private DegreeDaoImpl degreeDao =  new DegreeDaoImpl();
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        do {
            System.out.print("""
                    *************DEGREES MANAGEMENT*************
                    1. Danh sách các bằng cấp
                    2. Thêm mới một bằng cấp
                    3. Cập nhật bằng cấp
                    4. Xóa bằng cấp
                    5. Tìm kiếm bằng cấp theo tên 
                    6. Thoát
                    """);
            int choice = InputData.getInt(scanner, "Lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    System.out.println("************ Danh sách bằng cấp ************");
                    List<Degree> degrees = degreeDao.getAllDegrees();
                    if(degrees.isEmpty()) {
                        System.out.println("Danh sách trống!0");
                    } else {
                        degrees.forEach(System.out::println);
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("************ Thêm mới bằng cấp ************");
                    String degreeName = InputData.getString(scanner, "Nhập tên bằng cấp: ");
                    String empId = InputData.getString(scanner, "Nhập Id nhân viên: ");
                    LocalDateTime degreeDate = InputData.getDateTime(scanner, "Nhập thời gian cấp bằng (dd/MM/yyyy HH:mm:ss) : ");
                    String schoolName = InputData.getString(scanner, "Nhập tên trường: ");
                    int degreeYear = InputData.getInt(scanner, "Nhập năm cấp bằng: ");
                    String degreeClassification = InputData.getString(scanner, "Xếp loại bằng: ");
                    Degree degree = new Degree(null, degreeName, empId, degreeDate, schoolName, degreeYear, degreeClassification);
                    degreeDao.addDegree(degree);
                    System.out.println("Thêm bằng cấp thành công!");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("************ Cập nhật bằng cấp ************");
                    int updateId = InputData.getInt(scanner, "Nhập Id bằng cấp cần sửa: ");
                    if(!degreeDao.existsById(updateId)) {
                        System.out.println("Id không tồn tại!");
                    } else {
                        String newDegreeName = InputData.getString(scanner, "Nhập tên bằng cấp: ");
                        String newEmpId = InputData.getString(scanner, "Nhập Id nhân viên: ");
                        LocalDateTime newDegreeDate = InputData.getDateTime(scanner, "Nhập thời gian cấp bằng (dd/MM/yyyy HH:mm:ss) : ");
                        String newSchoolName = InputData.getString(scanner, "Nhập tên trường: ");
                        int newDegreeYear = InputData.getInt(scanner, "Nhập năm cấp bằng: ");
                        String newDegreeClassification = InputData.getString(scanner, "Xếp loại bằng: ");
                        Degree degreeUpdate = new Degree(updateId, newDegreeName, newEmpId, newDegreeDate, newSchoolName, newDegreeYear, newDegreeClassification);
                        degreeDao.updateDegree(degreeUpdate);
                        System.out.println("Cập nhật thành công!");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("************ Xóa bằng cấp ************");
                    int deleteId = InputData.getInt(scanner, "Nhập Id bằng cấp cần xóa: ");
                    if(!degreeDao.existsById(deleteId)) {
                        System.out.println("Id không tồn tại!");
                    } else {
                        do {
                            String cofirm = InputData.getString(scanner, "Nhập y để xác nhận xóa, nhập n để hủy bỏ: ");
                            if(cofirm.equalsIgnoreCase("n")) {
                                System.out.println("Đã hủy xóa!");
                                break;
                            }
                            if (cofirm.equalsIgnoreCase("y")) {
                                degreeDao.deleteDegree(deleteId);
                                System.out.println("Xóa thành công!");
                                break;
                            }
                        } while (true);
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("************ Tìm kiếm bằng cấp theo tên ************");
                    String degreeNameSearch = InputData.getString(scanner, "Nhập tên bằng cấp cần tìm: ");
                    List<Degree> listByDegreeName = new ArrayList<>();
                    listByDegreeName = degreeDao.getByDegreeName(degreeNameSearch);
                    if (listByDegreeName.isEmpty()) {
                        System.out.println("không tìm thấy bằng cấp nào!");
                    } else {
                        listByDegreeName.forEach(System.out::println);
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Kết thúc chương trình!");
                    scanner.close();
                    System.exit(0);
                    break;
            }

        } while (true);
    }
}
