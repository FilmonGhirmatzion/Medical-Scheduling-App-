package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDAO implements OfficeDAO {

    private JdbcTemplate jdbcTemplate;

    //public static List<Office> offices = new ArrayList<>();

    public JdbcOfficeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> list() {
        List<Office> office = new ArrayList<>();
        String sql = "Select * From office";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            office.add(mapRowToOffice(rows));
        }
        return office;
    }

    @Override
    public Office get(Long officeId) {
        Office office = null;
        String sql = "Select * From office where office_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, officeId);
        while (rows.next()) {
            office = mapRowToOffice(rows);
        }
        return office;
    }

    @Override
    public Office create(Office office, String officeName) {
//        String sql = "INSERT INTO office (office_id, office_name, office_street_address, office_city, office_state, office_zip, office_phone, office_email," +
//                " office_hours, office_parking, office_additional_info, office_url) VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING office_id ";
//        Long officeId = jdbcTemplate.queryForObject(sql, Long.class, office.getOfficeName(), office.getOfficeStreetAddress(), office.getOfficeCity(),
//                office.getOfficeState(), office.getOfficeZip(), office.getOfficePhone(), office.getOfficeEmail(), office.getOfficeHours(),
//                office.getOfficeParking(), office.getAdditionalInfo(), office.getOfficeUrl());
//        office.setOfficeId(officeId);
        return office;
    }

    @Override
    public List<Office> searchByName(String officeName) {
        return null;
    }

    @Override
    public List<Office> searchById(String officeId) {
        return null;
    }

    @Override
    public List<Office> searchByEmployeeName(String employeeName) {
        return null;
    }

    @Override
    public void update(Office office) {
        String sql = " UPDATE office SET office_name = ?, office_street_address = ?, office_city = ?, office_state = ?, office_zip = ?, office_phone = ?, office_email = ?, office_hours = ?, office_parking = ?, office_additional_info = ?, office_url = ? WHERE office_id = ?";
        jdbcTemplate.update(sql, office.getOfficeName(), office.getOfficeStreetAddress(), office.getOfficeCity(),
                office.getOfficeState(), office.getOfficeZip(), office.getOfficePhone(), office.getOfficeEmail(), office.getOfficeHours(),
                office.getOfficeParking(), office.getAdditionalInfo(), office.getOfficeUrl(), office.getOfficeId() );
    }

    @Override
    public void delete(Long officeId) {
    String sqlDeleteOfficeById = "DELETE FROM office WHERE office_id = ?";
    jdbcTemplate.update(sqlDeleteOfficeById, officeId);
     }


    public boolean isOfficeName(Long officeId) {
        String sql = "Select * From office where office_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, officeId);
        return rows.next();
    }


    private Office mapRowToOffice(SqlRowSet row) {

        Office office = new Office();
        office.setOfficeId(row.getLong("office_Id"));
        office.setOfficeName(row.getString("office_Name"));
        office.setOfficeStreetAddress(row.getString("office_street_address"));
        office.setOfficeCity(row.getString("office_city"));
        office.setOfficeState(row.getString("office_state"));
        office.setOfficeZip(row.getLong("office_zip"));
        office.setOfficePhone(row.getString("office_phone"));
        office.setOfficeEmail(row.getString("office_email"));
        office.setOfficeHours(row.getString("office_hours"));
        office.setOfficeParking(row.getString("office_parking"));
        office.setAdditionalInfo(row.getString("office_additional_info"));
        office.setOfficeUrl(row.getString("office_url"));
        return office;
    }




}
