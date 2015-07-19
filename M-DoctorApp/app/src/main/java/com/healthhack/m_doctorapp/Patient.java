package com.healthhack.m_doctorapp;

/**
 * Created by Chinmay on 12-07-2015.
 */
public class Patient {
    String pat_name;
    int pat_id;
    String symptom;
    String description;
    int lat,lon;

    public Patient() {
    }

    public Patient(String pat_name, int pat_id, String symptom, String description, int lat, int lon) {
        this.pat_name = pat_name;
        this.pat_id = pat_id;
        this.symptom = symptom;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPat_name() {
        return pat_name;
    }

    public void setPat_name(String pat_name) {
        this.pat_name = pat_name;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
}
