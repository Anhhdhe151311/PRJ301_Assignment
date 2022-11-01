/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.*;
import java.sql.Date;
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
public class SessionDAO extends DBContext{

    public ArrayList<Session> filter(int lid, Date from, Date to) throws SQLException {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "SELECT  \n"
                    + "	ses.sesid,ses.[date],ses.[index],ses.attanded\n"
                    + "	,l.lid,l.lname\n"
                    + "	,g.gid,g.gname\n"
                    + "	,sub.subid,sub.subname\n"
                    + "	,r.rid,r.rname\n"
                    + "	,t.tid,t.[description]\n"
                    + "FROM [Session] ses \n"
                    + "			INNER JOIN Lecturer l ON l.lid = ses.lid\n"
                    + "			INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "			INNER JOIN [Subject] sub ON sub.subid = g.subid\n"
                    + "			INNER JOIN Room r ON r.rid = ses.rid\n"
                    + "			INNER JOIN TimeSlot t ON t.tid = ses.tid\n"
                    + "WHERE\n"
                    + "l.lid = ?\n"
                    + "AND ses.[date] >= ?\n"
                    + "AND ses.[date] <= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, lid);
            ps.setDate(2, from);
            ps.setDate(3, to);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Session session = new Session();
                Lecturer l = new Lecturer();
                Room r = new Room();
                Group g = new Group();
                TimeSlot t = new TimeSlot();
                Subject sub = new Subject();
                
                session.setSesid(rs.getInt("sesid"));
                session.setDate(rs.getDate("date"));
                session.setIndex(rs.getInt("index"));
                session.setAttanded(rs.getBoolean("attanded"));
                
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                session.setLecturer(l);
                
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                session.setGroup(g);
                
                sub.setSubid(rs.getInt("subid"));
                sub.setSubname(rs.getString("subname"));
                g.setSubject(sub);
                
                r.setRid(rs.getInt("rid"));
                r.setRname(rs.getString("rname"));
                session.setRoom(r);
                
                t.setTid(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                session.setTimeslot(t);
                sessions.add(session);
            }
    }catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
        return sessions;
}
}
