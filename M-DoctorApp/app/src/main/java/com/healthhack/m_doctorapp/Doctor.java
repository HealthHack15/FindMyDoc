package com.healthhack.m_doctorapp;

/**
 * Created by Chinmay on 12-07-2015.
 */
public class Doctor {
int doc_id;
    String doc_name;
    String speciality;
    String []tag;
    char availability;
    int hospital_id;

    public Doctor() {
    }

    public Doctor(int doc_id, String doc_name, String speciality, String[] tag, char availability, int hospital_id) {
        this.doc_id = doc_id;
        this.doc_name = doc_name;
        this.speciality = speciality;
        this.tag = tag;
        this.availability = availability;
        this.hospital_id = hospital_id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public char getAvailability() {
        return availability;
    }

    public void setAvailability(char availability) {
        this.availability = availability;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }
}


