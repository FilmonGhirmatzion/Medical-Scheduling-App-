package com.techelevator.controller;

import com.techelevator.dao.AppointmentDAO;
import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class AppointmentController {

    private AppointmentDAO appointmentDAO;

    public AppointmentController(AppointmentDAO appointmentDAO){
        this.appointmentDAO = appointmentDAO;
    }

        @RequestMapping(path="/appointments", method= RequestMethod.GET)
    public List<Appointment> list(){
        return appointmentDAO.list();
    }

    @RequestMapping(path = "/appointment/{office_Id}", method = RequestMethod.GET)
    public Appointment get(@PathVariable(name="office_Id") Long officeId ){
        return appointmentDAO.get(officeId);
    }

    @RequestMapping(path = "/appointments/{office_Id}", method = RequestMethod.GET)
    public List<Appointment> searchAppointmentsByOfficeId(@PathVariable(name="office_Id") Long officeId ){
        return appointmentDAO.searchByOfficeId(officeId);
    }

    @RequestMapping(path = "/appointments", method = RequestMethod.POST)
    public void createAppointment(@RequestBody Appointment appointment) {
        appointmentDAO.create(appointment, "patient");
    }
}
