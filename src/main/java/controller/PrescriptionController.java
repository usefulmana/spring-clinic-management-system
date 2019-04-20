package controller;



import model.Drug;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    public PrescriptionService getPrescriptionService() {
        return prescriptionService;
    }

    public void setPrescriptionService(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }


    @RequestMapping(path="prescription/details", method = RequestMethod.GET)
    public List<Drug> getPrescriptionDetails(@RequestParam int id){
        return prescriptionService.getPrescriptionDetails(id);
    }

    @RequestMapping(path="prescription", method = RequestMethod.GET)
    public List<Prescription> getAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    @RequestMapping(path="prescription", method = RequestMethod.POST)
    public int addPrescription(@RequestBody Prescription prescription){
        return prescriptionService.addPrescription(prescription);
    }

    @RequestMapping(path="prescription", method = RequestMethod.DELETE)
    public int deletePrescription(@RequestBody Prescription prescription){
        return prescriptionService.deletePrescription(prescription);
    }

    @RequestMapping(path="prescription", method = RequestMethod.PUT)
    public int updatePrescription(@RequestBody Prescription prescription){
        return prescriptionService.updatePrescription(prescription);
    }

}
