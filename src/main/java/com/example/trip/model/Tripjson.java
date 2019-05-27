
package com.example.trip.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tripjson {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("totalDuration")
    @Expose
    private String totalDuration;
    @SerializedName("stops")
    @Expose
    private Integer stops;
    @SerializedName("airlineLogo")
    @Expose
    private List<String> airlineLogo = null;
    @SerializedName("departingAirportName")
    @Expose
    private List<String> departingAirportName = null;
    @SerializedName("arrivalAirportName")
    @Expose
    private List<String> arrivalAirportName = null;
    @SerializedName("logoCover")
    @Expose
    private String logoCover;
    @SerializedName("depCityName")
    @Expose
    private List<String> depCityName = null;
    @SerializedName("arrCityName")
    @Expose
    private List<String> arrCityName = null;
    @SerializedName("depDateAndTime")
    @Expose
    private List<String> depDateAndTime = null;
    @SerializedName("arrDateAndTime")
    @Expose
    private List<String> arrDateAndTime = null;
    @SerializedName("airlineName")
    @Expose
    private List<String> airlineName = null;
    @SerializedName("flightNumber")
    @Expose
    private List<String> flightNumber = null;
    @SerializedName("layOverTime")
    @Expose
    private List<String> layOverTime = null;
    @SerializedName("layOverMinutes")
    @Expose
    private List<String> layOverMinutes = null;
    @SerializedName("layOverCity")
    @Expose
    private List<String> layOverCity = null;
    @SerializedName("arrAirportName")
    @Expose
    private List<String> arrAirportName = null;
    @SerializedName("flightModel")
    @Expose
    private List<String> flightModel = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public List<String> getAirlineLogo() {
        return airlineLogo;
    }

    public void setAirlineLogo(List<String> airlineLogo) {
        this.airlineLogo = airlineLogo;
    }

    public List<String> getDepartingAirportName() {
        return departingAirportName;
    }

    public void setDepartingAirportName(List<String> departingAirportName) {
        this.departingAirportName = departingAirportName;
    }

    public List<String> getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(List<String> arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getLogoCover() {
        return logoCover;
    }

    public void setLogoCover(String logoCover) {
        this.logoCover = logoCover;
    }

    public List<String> getDepCityName() {
        return depCityName;
    }

    public void setDepCityName(List<String> depCityName) {
        this.depCityName = depCityName;
    }

    public List<String> getArrCityName() {
        return arrCityName;
    }

    public void setArrCityName(List<String> arrCityName) {
        this.arrCityName = arrCityName;
    }

    public List<String> getDepDateAndTime() {
        return depDateAndTime;
    }

    public void setDepDateAndTime(List<String> depDateAndTime) {
        this.depDateAndTime = depDateAndTime;
    }

    public List<String> getArrDateAndTime() {
        return arrDateAndTime;
    }

    public void setArrDateAndTime(List<String> arrDateAndTime) {
        this.arrDateAndTime = arrDateAndTime;
    }

    public List<String> getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(List<String> airlineName) {
        this.airlineName = airlineName;
    }

    public List<String> getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(List<String> flightNumber) {
        this.flightNumber = flightNumber;
    }

    public List<String> getLayOverTime() {
        return layOverTime;
    }

    public void setLayOverTime(List<String> layOverTime) {
        this.layOverTime = layOverTime;
    }

    public List<String> getLayOverMinutes() {
        return layOverMinutes;
    }

    public void setLayOverMinutes(List<String> layOverMinutes) {
        this.layOverMinutes = layOverMinutes;
    }

    public List<String> getLayOverCity() {
        return layOverCity;
    }

    public void setLayOverCity(List<String> layOverCity) {
        this.layOverCity = layOverCity;
    }

    public List<String> getArrAirportName() {
        return arrAirportName;
    }

    public void setArrAirportName(List<String> arrAirportName) {
        this.arrAirportName = arrAirportName;
    }

    public List<String> getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(List<String> flightModel) {
        this.flightModel = flightModel;
    }

}
