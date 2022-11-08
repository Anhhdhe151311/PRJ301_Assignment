/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Group;
import Model.Lecturer;
import Model.Student;
import Model.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentDAO extends DBContext {

    public Student getId(String displayname) {
        try {
            String sql = "SELECT * FROM Student WHERE stdname = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, displayname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student getAllStudent(int stdid) {
        try {
            String sql = "SELECT * FROM Student WHERE stdid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stdid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> getStudentGroup(int stdid) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT * from [Student] stu \n"
                    + "                    INNER JOIN [Student_Group] stg on stu.stdid = stg.stdid \n"
                    + "                    Inner join [Group] g on stg.gid = g.gid\n"
                    + "					INner join [Subject] s on g.subid = s.subid\n"
                    + "                    where stu.stdid = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stdid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Student stu = new Student();
                Group g = new Group();
                Subject s = new Subject();
                s.setId(rs.getInt("subid"));
                s.setName(rs.getString("subname"));
                g.setId(rs.getInt(5));
                g.setName(rs.getString(6));
                g.setSubject(s);

                stu.setGroup(g);
                stu.setId(rs.getInt(1));
                stu.setName(rs.getString(2));
                students.add(stu);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

}
