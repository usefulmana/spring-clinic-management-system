package controller;

import model.Patient;
import model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(path = "patients/id", method = RequestMethod.GET)
    public Patient getPatientById (@RequestParam int id){
        return patientService.getPatientById(id);
    }

    @RequestMapping(path = "patients", method = RequestMethod.GET)
    public List<Patient> getPatientByName (@RequestParam String name){
        return patientService.getPatientbyName(name);
    }

    @RequestMapping(path = "patients/all", method = RequestMethod.GET)
    public List<Patient> getAllPatients (){
        return patientService.getAllPatients();
    }

    @RequestMapping(path = "patients", method = RequestMethod.DELETE)
    public int deletePatient(@RequestBody Patient patient){
        return patientService.removePatient(patient);
    }

    @RequestMapping(path = "patients", method = RequestMethod.POST)
    public int addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @RequestMapping(path = "patients", method = RequestMethod.PUT)
    public int updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    @RequestMapping(path = "patients/visit", method = RequestMethod.GET)
    public List<Visit> getLogByID(@RequestParam int id){return patientService.getLogById(id);}


}
