package controller;


import model.DrugList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DrugsService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DrugsController {

    @Autowired
    private DrugsService drugsService;

    public DrugsService getDrugsService() {
        return drugsService;
    }

    public void setDrugsService(DrugsService drugsService) {
        this.drugsService = drugsService;
    }

    @RequestMapping(path = "drugs/id", method = RequestMethod.GET)
    public DrugList getPatientById (@RequestParam int id){
        return drugsService.getDrugbyId(id);
    }

    @RequestMapping(path = "drugs", method = RequestMethod.GET)
    public List<DrugList> getPatientByName (@RequestParam String name){
        return drugsService.getDrugsbyName(name);
    }
    @RequestMapping(path = "drugs/all", method = RequestMethod.GET)
    public List<DrugList> getAllPatients (){
        return drugsService.getAllDrugs();
    }

    @RequestMapping(path = "drugs", method = RequestMethod.DELETE)
    public int deleteDrug(@RequestBody DrugList drug){
        return drugsService.removeDrug(drug);
    }

    @RequestMapping(path = "drugs", method = RequestMethod.POST)
    public int addDrug(@RequestBody DrugList drugs){
        return drugsService.addDrug(drugs);
    }

    @RequestMapping(path= "drugs", method = RequestMethod.PUT)
    public int updateDrug(@RequestBody DrugList drugs){
        return drugsService.updateDrug(drugs);
    }
}
