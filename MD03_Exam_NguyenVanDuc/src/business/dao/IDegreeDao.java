package business.dao;

import business.entity.Degree;

import java.util.List;

public interface IDegreeDao {
    List<Degree> getAllDegrees();
    void addDegree(Degree degree);
    void updateDegree(Degree degree);
    void deleteDegree(Integer deleteId);
    List<Degree> getByEmpId(String empIdSearch);
    List<Degree> getByDegreeName(String degreeNamesearch);
    boolean existsById(Integer id);
}
