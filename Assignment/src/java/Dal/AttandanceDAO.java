/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Attandance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.*;

/**
 *
 * @author Admin
 */
public class AttandanceDAO extends DBContext {

    public ArrayList<Attandance> getAttsBySessionId(int sesid) {
        ArrayList<Attandance> atts = new ArrayList<>();
        try {
            String sql = "SELECT std.stdid,std.stdname\n"
                    + "	,ses.sesid\n"
                    + "	,ISNULL(a.present,0) present,ISNULL(a.[description],'') [description]\n"
                    + "			FROM [Session] ses\n"
                    + "			INNER JOIN [Group] g ON ses.gid = g.gid\n"
                    + "			INNER JOIN Student_Group sg ON g.gid = sg.gid\n"
                    + "			INNER JOIN Student std ON std.stdid = sg.stdid\n"
                    + "			LEFT JOIN Attandance a ON a.sesid = ses.sesid AND std.stdid = a.stdid\n"
                    + "WHERE ses.sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sesid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attandance att = new Attandance();
                Student s = new Student();
                att.setStudent(s);
                Session ses = new Session();
                att.setSession(ses);
                att.setPresent(rs.getBoolean("present"));
                att.setDescription(rs.getString("description"));
                s.setId(rs.getInt("stdid"));
                s.setName(rs.getString("stdname"));
                ses.setId(sesid);
                atts.add(att);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttandanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public ArrayList<Attandance> getCheckAttendance(int stdid, int gid) {
        ArrayList<Attandance> atts = new ArrayList<>();
        try {
            String sql = "SELECT * from [Attandance] att \n"
                    + "INNER JOIN [Session] ses on att.sesid = ses.sesid \n"
                    + "Inner join [Group] g on ses.gid = g.gid\n"
                    + "Inner Join [Subject] s on g.subid = s.subid\n"
                    + "where att.stdid =? and g.gid=? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stdid);
            ps.setInt(2, gid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attandance att = new Attandance();
                Session ses = new Session();
                Group g = new Group();
                Subject s = new Subject();

                s.setName(rs.getString("subname"));
                s.setFullslot(rs.getInt("fullslot"));
                g.setName(rs.getString("gname"));
                ses.setDate(rs.getDate("date"));
                att.setPresent(rs.getBoolean("present"));

                g.setSubject(s);
                ses.setGroup(g);
                att.setSession(ses);
                atts.add(att);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttandanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

}
