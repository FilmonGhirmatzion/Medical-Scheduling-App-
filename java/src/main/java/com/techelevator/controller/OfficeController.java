package com.techelevator.controller;

import com.techelevator.dao.OfficeDAO;
import com.techelevator.model.Office;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")


public class OfficeController {

    private OfficeDAO officeDAO;

    public OfficeController(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;


    }


    @RequestMapping(path="/offices", method= RequestMethod.GET)
    public List<Office> list(){
        return officeDAO.list();
    }

    @RequestMapping(path = "/offices/{office_Id}", method = RequestMethod.GET)
    public Office get(@PathVariable(name="office_Id") Long officeId ){
        return officeDAO.get(officeId);
    }


    @RequestMapping(path = "/offices", method= RequestMethod.POST )
    public Office add(@Valid @RequestBody Office office, Principal principal){
        return officeDAO.create(office, principal.getName());

    }

    @RequestMapping(path = "/offices/{office_Id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name="office_Id") Long officeId ){
         officeDAO.delete(officeId);
    }

    @RequestMapping(path = "/offices/{office_Id}", method = RequestMethod.PUT)
    public void update(@PathVariable(name="office_Id") Long officeId, @RequestBody Office office, Principal principal){
        if(officeDAO.isOfficeName(office.getOfficeId() )){
            officeDAO.update(office);
        }
    }
}
