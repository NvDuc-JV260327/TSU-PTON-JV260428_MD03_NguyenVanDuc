package business.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Degree {
    private Integer degreeId;
    private String degreeName;
    private String empId;
    private LocalDateTime degreeDate;
    private String schoolName;
    private int degreeYear;
    private String degreeClassification;

    public Degree() {
    }

    public Degree(Integer degreeId, String degreeName, String empId, LocalDateTime degreeDate, String schoolName, int degreeYear, String degreeClassification) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
        this.empId = empId;
        this.degreeDate = degreeDate;
        this.schoolName = schoolName;
        this.degreeYear = degreeYear;
        this.degreeClassification = degreeClassification;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public LocalDateTime getDegreeDate() {
        return degreeDate;
    }

    public void setDegreeDate(LocalDateTime degreeDate) {
        this.degreeDate = degreeDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getDegreeYear() {
        return degreeYear;
    }

    public void setDegreeYear(int degreeYear) {
        this.degreeYear = degreeYear;
    }

    public String getDegreeClassification() {
        return degreeClassification;
    }

    public void setDegreeClassification(String degreeClassification) {
        this.degreeClassification = degreeClassification;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("DegreeId: %d, DegreeName: %s, EmployeeId: %s, DegreeDate: %s, SchoolName: %s, DegreeYear: %d, DegreeClassification: %s",
                degreeId, degreeName, empId, degreeDate.format(formatter), schoolName, degreeYear, degreeClassification);
    }
}
