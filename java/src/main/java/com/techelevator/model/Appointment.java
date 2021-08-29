package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private Long appointmentId;
    private Long officeId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String patientStreetAddress;
    private String patientCity;
    private String patientState;
    private Long patientZip;
    private String phoneNumber;
    private String patientEmail;
    private Boolean newPatient;
    private String appointmentType;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Appointment() {
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientStreetAddress() {
        return patientStreetAddress;
    }

    public void setPatientStreetAddress(String patientStreetAddress) {
        this.patientStreetAddress = patientStreetAddress;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientState() {
        return patientState;
    }

    public void setPatientState(String patientState) {
        this.patientState = patientState;
    }

    public Long getPatientZip() {
        return patientZip;
    }

    public void setPatientZip(Long patientZip) {
        this.patientZip = patientZip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Boolean getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(Boolean newPatient) {
        this.newPatient = newPatient;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
