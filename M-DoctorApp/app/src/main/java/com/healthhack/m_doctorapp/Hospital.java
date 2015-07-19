package com.healthhack.m_doctorapp;

/**
 * Created by Chinmay on 12-07-2015.
 */
public class Hospital {
    String name;
    int hospital_id;
    double lat,lon;

    public Hospital() {
    }

    public Hospital(int hospital_id,String name, double lat, double lon) {
        this.name = name;
        this.hospital_id = hospital_id;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
}
