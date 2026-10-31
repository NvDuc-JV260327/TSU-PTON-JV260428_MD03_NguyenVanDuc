package business.dao;

import business.entity.Degree;
import utils.ConnectionDB;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DegreeDaoImpl implements IDegreeDao {
    @Override
    public List<Degree> getAllDegrees() {
        List<Degree> degrees = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("call get_all_degrees()");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Degree degree = new Degree(
                        rs.getInt("degree_id"),
                        rs.getString("degree_name"),
                        rs.getString("emp_id"),
                        rs.getTimestamp("degree_date").toLocalDateTime(),
                        rs.getString("school_name"),
                        rs.getInt("degree_year"),
                        rs.getString("degree_classification")
                );
                degrees.add(degree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return degrees;
    }

    @Override
    public void addDegree(Degree degree) {
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("call add_degrees(?,?,?,?,?,?)");
            call.setString(1, degree.getDegreeName());
            call.setString(2, degree.getEmpId());
            call.setTimestamp(3, Timestamp.valueOf(degree.getDegreeDate()));
            call.setString(4, degree.getSchoolName());
            call.setInt(5, degree.getDegreeYear());
            call.setString(6, degree.getDegreeClassification());
            call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void updateDegree(Degree degree) {
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("call update_degrees(?,?,?,?,?,?,?)");
            call.setInt(1, degree.getDegreeId());
            call.setString(2, degree.getDegreeName());
            call.setString(3, degree.getEmpId());
            call.setTimestamp(4, Timestamp.valueOf(degree.getDegreeDate()));
            call.setString(5, degree.getSchoolName());
            call.setInt(6, degree.getDegreeYear());
            call.setString(7, degree.getDegreeClassification());
            call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void deleteDegree(Integer deleteId) {
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("call delete_degree(?)");
            call.setInt(1, deleteId);
            call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public List<Degree> getByEmpId(String empIdSearch) {
        List<Degree> lisyByEmpId = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("call get_by_emp_id(?)");
            call.setString(1,empIdSearch);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Degree degree = new Degree(
                        rs.getInt("degree_id"),
                        rs.getString("degree_name"),
                        rs.getString("emp_id"),
                        rs.getTimestamp("degree_date").toLocalDateTime(),
                        rs.getString("school_name"),
                        rs.getInt("degree_year"),
                        rs.getString("degree_classification")
                );
                lisyByEmpId.add(degree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return lisyByEmpId;
    }

    @Override
    public List<Degree> getByDegreeName(String degreeNamesearch) {
        List<Degree> listByDegreeName = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("call get_by_degree_name(?)");
            call.setString(1, degreeNamesearch);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Degree degree = new Degree(
                        rs.getInt("degree_id"),
                        rs.getString("degree_name"),
                        rs.getString("emp_id"),
                        rs.getTimestamp("degree_date").toLocalDateTime(),
                        rs.getString("school_name"),
                        rs.getInt("degree_year"),
                        rs.getString("degree_classification")
                );
                listByDegreeName.add(degree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listByDegreeName;
    }

    @Override
    public boolean existsById(Integer id) {
        for (Degree degree : getAllDegrees()) {
            if(degree.getDegreeId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
