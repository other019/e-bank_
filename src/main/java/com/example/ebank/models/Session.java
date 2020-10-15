package com.example.ebank.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "sessions")
public class Session {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;
    
    @ManyToMany
    @JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;
    
    public Session() {
        
    }
    
    public Integer getSession_length() {
        return session_length;
    }
    
    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }
    
    public String getSession_description() {
        return session_description;
    }
    
    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }
    
    public String getSession_name() {
        return session_name;
    }
    
    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }
}