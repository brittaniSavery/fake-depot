package com.brittanisavery.demos.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tool {
    private Code code;
    private String type;
    private String brand;
    private BigDecimal charge;
    private boolean busCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    public Tool(Code code) throws Exception {
        switch (code) {
            case LADW:
                this.code = Code.LADW;
                this.type = "Ladder";
                this.brand = "Werner";
                this.charge = new BigDecimal("1.99").setScale(2, RoundingMode.HALF_UP);
                this.busCharge = true;
                this.weekendCharge = true;
                this.holidayCharge = false;
                break;
            case CHNS:
                this.code = Code.CHNS;
                this.type = "Chainsaw";
                this.brand = "Stihl";
                this.charge = new BigDecimal("1.49").setScale(2, RoundingMode.HALF_UP);
                this.busCharge = true;
                this.weekendCharge = false;
                this.holidayCharge = true;
                break;
            case JAKR:
            case JAKD:
                this.code = code;
                this.type = "Jackhammer";
                this.brand = this.code == Code.JAKR ? "Ridgid" : "DeWalt";
                this.charge = new BigDecimal("2.99").setScale(2, RoundingMode.HALF_UP);
                this.busCharge = true;
                this.weekendCharge = false;
                this.holidayCharge = false;
                break;
            default:
                throw new IllegalArgumentException(
                        "This tool could not be found. Please double-check for typos and try again.");
        }
    }

    public Tool(String code) throws Exception {
        this(Code.valueOf(code));
    }

    public static enum Code {
        LADW, CHNS, JAKR, JAKD
    }

    // #region Getters and Setters

    public Code getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = Code.valueOf(code);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getCharge() {
        return this.charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public boolean hasBusCharge() {
        return this.busCharge;
    }

    public void setBusCharge(boolean busCharge) {
        this.busCharge = busCharge;
    }

    public boolean hasWeekendCharge() {
        return this.weekendCharge;
    }

    public void setWeekendCharge(boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    public boolean hasHolidayCharge() {
        return this.holidayCharge;
    }

    public void setHolidayCharge(boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }

    // #endregion
}