/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Subject;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class SubjectDAO extends DBContext{

    public Subject getSubject(int subid) {
        try {
            String sql = "SELECT * from [Subject] where subid=1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Subject s = new Subject();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setFullslot(3);
                return s;
            }
        } catch (SQLException ex ) {
        }
        return null;
    }
    
}
