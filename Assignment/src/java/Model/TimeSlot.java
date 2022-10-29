/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TimeSlot {
    private int tid;
    private String dascription;
    
    private ArrayList<Session> sessions = new ArrayList<>();

    public TimeSlot(int tid, String dascription) {
        this.tid = tid;
        this.dascription = dascription;
    }
    
    

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getDascription() {
        return dascription;
    }

    public void setDascription(String dascription) {
        this.dascription = dascription;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }
    
    
    
    
    
}
