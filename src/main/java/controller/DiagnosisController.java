package controller;


import model.Diagnosis;
import model.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DiagnosisService;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    public DiagnosisService getDiagnosisService() {
        return diagnosisService;
    }

    public void setDiagnosisService(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @RequestMapping(path = "diag",method = RequestMethod.POST)
    public int addDiagnosis(@RequestBody Diagnosis diagnosis){
        return this.getDiagnosisService().addDiagnosis(diagnosis);
    }

    @RequestMapping(path = "diag", method = RequestMethod.DELETE)
    public int deleteDiagnosis(@RequestBody Diagnosis diagnosis){
        return this.getDiagnosisService().deleteDiagnosis(diagnosis);
    }

    @RequestMapping(path = "diag", method = RequestMethod.PUT)
    public int updateDiagnosis(@RequestBody Diagnosis diagnosis){
        return this.getDiagnosisService().updateDiagnosis(diagnosis);
    }

    @RequestMapping(path = "diag/details",method = RequestMethod.GET)
    public List<Disease> getDiagnosisDetails(@RequestParam int did){
        return this.getDiagnosisService().getDiagnosisDetails(did);
    }
}
