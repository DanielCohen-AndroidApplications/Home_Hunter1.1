package com.homehunter0224902.daniel.homehunter11;

import android.graphics.drawable.Drawable;

/**
 * Created by Daniel on 4/21/2016.
 */
public class Property {
    private String address, shortBlurb, bigBlurb;
    private Integer rent, minSalary;
    private String payPeriod;
    private Double beds, baths, sqft;
    private Boolean pets, couples, smoking;
    private Drawable pic;

    public Property(String address, Drawable pic, Integer rent, Integer minSalary) {
        this.address = address;
        this.pic = pic;
        this.rent = rent;
        this.minSalary=minSalary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortBlurb() {
        return shortBlurb;
    }

    public void setShortBlurb(String shortBlurb) {
        this.shortBlurb= shortBlurb;
    }

    public String getBigBlurb() {
        return bigBlurb;
    }

    public void setBigBlurb(String bigBlurb) {
        this.bigBlurb= bigBlurb;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent= rent;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }
    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Double getBeds() {
        return beds;
    }

    public void setBeds(Double beds) {
        this.beds = beds;
    }

    public Double getBaths() {
        return baths;
    }

    public void setBaths(Double baths) {
        this.baths = baths;
    }

    public Double getSqft() {
        return sqft;
    }

    public void setSqft(Double sqft) {
        this.sqft = sqft;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }

    public Boolean getCouples() {
        return couples;
    }

    public void setCouples(Boolean couples) {
        this.couples = couples;
    }
    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }
    public Drawable getPic() {
        return pic;
    }

    public void setPic(Drawable pic) {
        this.pic = pic;
    }
}
