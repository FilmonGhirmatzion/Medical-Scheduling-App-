package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDAO {
    List<Appointment> list();

    Appointment get(Long officeId);

    void create(Appointment appointment, String username);

    List<Appointment> searchByOfficeId(Long officeId);

    List<Appointment> searchAppointmentsByDate(LocalDate appointmentDate);

    void update(Appointment appointment);

    void delete(Long appointmentId);

}
