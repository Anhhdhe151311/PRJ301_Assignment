/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.TimeSlot;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TimeSlotDAO extends DBContext{

    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> slots = new ArrayList<>();
        
        try {
            String sql = "SELECT tid,[description] FROM TimeSlot";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TimeSlot slot = new TimeSlot(
                        rs.getInt(1), 
                        rs.getString(2));
                slots.add(slot);
            }
        } catch (SQLException ex ) {
        }
        return slots;
    }
    
}
