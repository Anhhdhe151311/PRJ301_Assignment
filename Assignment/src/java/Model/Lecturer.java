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
public class Lecturer {
    private int id;
    private String name;
    private ArrayList<Group> group = new ArrayList<>();
    private ArrayList<Session> session = new ArrayList<>();

    public Lecturer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Lecturer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

   

   
    public ArrayList<Group> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Group> group) {
        this.group = group;
    }

    public ArrayList<Session> getSession() {
        return session;
    }

    public void setSession(ArrayList<Session> session) {
        this.session = session;
    }
    
    
}
