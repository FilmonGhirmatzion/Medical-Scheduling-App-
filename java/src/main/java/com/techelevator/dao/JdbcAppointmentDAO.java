package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDAO implements AppointmentDAO {
    private JdbcTemplate jdbcTemplate;
    private UserSqlDAO userDao;

    public JdbcAppointmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        userDao = new UserSqlDAO(jdbcTemplate);
    }

    @Override
    public List<Appointment> list() {
        List<Appointment> appointment = new ArrayList<>();
        String sql = "select * from appointment";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            appointment.add(mapRowToAppointment(rows));
        }
        return appointment;
    }

    @Override
    public Appointment get(Long officeId) {

        Appointment appointment = null;
        String sql = "select office.office_name, *  from appointment Join office ON appointment.office_id = office.office_id Where office.office_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, officeId);

        while (rows.next()) {
            appointment = mapRowToAppointment(rows);
        }
        return appointment;
    }

    @Override
    public List<Appointment> searchByOfficeId(Long officeId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select office.office_name, *  from appointment Join office ON appointment.office_id = office.office_id Where office.office_id = ? ";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, officeId);
        while(rows.next()){
            appointments.add(mapRowToAppointment(rows));
        }
        return appointments;
    }

    @Override
    public List<Appointment> searchAppointmentsByDate(LocalDate appointmentDate) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select office.office_name, *  from appointment Join office ON appointment.office_id = office.office_id Where office.office_id = ? ";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, appointmentDate);
        while(rows.next()){
            appointments.add(mapRowToAppointment(rows));
        }
        return appointments;
    }

    @Override
    public void create(Appointment appointment, String username) {

        String sql = "INSERT INTO appointment " +
                "(appointment_id, office_id, firstname, lastname, gender, dateofbirth, patient_street_address, " +
                "patient_city, patient_state, patient_zip, patient_phone, patient_email, newpatient, " +
                "appointment_type, appointment_date, appointment_time) " +
                "VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING appointment_id";

        //User appointmentUserId = userDao.findByUsername(username);

        Integer appointmentId = jdbcTemplate.queryForObject(sql, Integer.class,
                appointment.getOfficeId(),
                "John",
                "Smith",
                "Male",
                LocalDate.parse("1916-04-17"),
                "52 Wallaby Way",
                "Columbus",
                "OH",
                43215,
                "123-456-7894",
                "nemo@notanemail.com",
                false,
                "Family Medicine",
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime()
        );

//                appointment.getOfficeId(),
//                appointment.getFirstName(),
//                appointment.getLastName(),
//                appointment.getGender(),
//                appointment.getDateOfBirth(),
//                appointment.getPatientStreetAddress(),
//                appointment.getPatientCity(),
//                appointment.getPatientState(),
//                appointment.getPatientZip(),
//                appointment.getPhoneNumber(),
//                appointment.getPatientEmail(),
//                appointment.getNewPatient(),
//                appointment.getAppointmentType(),
//                appointment.getAppointmentDate(),
//                appointment.getAppointmentTime()
    }

    @Override
    public void update(Appointment appointment) {
    }

    @Override
    public void delete(Long appointmentId) {
    }

    private Appointment mapRowToAppointment(SqlRowSet row) {
        Appointment appointment = new Appointment();

        appointment.setAppointmentId(row.getLong("appointment_Id"));
        appointment.setOfficeId(row.getLong("office_Id"));
        appointment.setFirstName(row.getString("firstName"));
        appointment.setLastName(row.getString("lastName"));
        appointment.setGender(row.getString("gender"));
        appointment.setDateOfBirth(row.getDate("dateofbirth").toLocalDate());
        appointment.setPatientStreetAddress(row.getString("patient_street_address"));
        appointment.setPatientCity(row.getString("patient_city"));
        appointment.setPatientState(row.getString("patient_city"));
        appointment.setPatientZip(row.getLong("patient_zip"));
        appointment.setPhoneNumber(row.getString("patient_phone"));
        appointment.setPatientEmail(row.getString("patient_email"));
        appointment.setNewPatient(row.getBoolean("newpatient"));
        appointment.setAppointmentType(row.getString("appointment_type"));
        if (row.getDate("appointment_date") != null) {
            appointment.setAppointmentDate(row.getDate("appointment_date").toLocalDate());
        }
        if (row.getTime("appointment_time") != null) {
            appointment.setAppointmentTime(row.getTime("appointment_time").toLocalTime());
        }
        return appointment;
    }
}