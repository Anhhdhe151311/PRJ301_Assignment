/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.TimeSlot;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TimeSlotDAO extends DBContext{

    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> slots = new ArrayList<>();
        return slots;
    }
    
}
