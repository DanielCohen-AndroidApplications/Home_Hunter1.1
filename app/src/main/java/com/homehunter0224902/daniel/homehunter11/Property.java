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
    private Boolean guarantor, pets, couples, smoking;
    private Drawable pic, pic2, pic3, pic4;
    private Double myDistance;

    public Property(String address, Drawable pic, Integer rent, String payPeriod, Integer minSalary) {
        this.address = address;
        this.pic = pic;
        this.rent = rent;
        this.payPeriod=payPeriod;
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

    public Boolean getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(Boolean guarantor) {
        this.guarantor = guarantor;
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


    public void setPic(Drawable pic3) {
        this.pic = pic;
    }
    public Drawable getPic() {
        return pic;
    }

    public void setPic2(Drawable pic2) {
        this.pic2 = pic2;
    }

    public Drawable getPic2() {
        return pic2;
    }

    public void setPic3(Drawable pic3) {
        this.pic3 = pic3;
    }
    public Drawable getPic3() {
        return pic3;
    }

    public void setPic4(Drawable pic4) {
        this.pic4 = pic4;
    }
    public Drawable getPic4() {
        return pic4;
    }
    public Double getMyDistance() {
        return myDistance;
    }
    public void setMyDistance(Double myDistance) {
        this.myDistance = myDistance;
    }
}
