package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDAO {
    List<Office> list();
    Office get(Long officeId);
    Office create(Office office, String officeName);
    List<Office> searchByName(String officeName);
    List<Office> searchById(String officeId);
    List<Office> searchByEmployeeName(String employeeName);
    void update(Office office);
    void delete(Long officeId);
    boolean isOfficeName(Long officeId);
}
