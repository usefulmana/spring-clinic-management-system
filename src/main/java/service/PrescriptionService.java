package service;


import model.Drug;
import model.Prescription;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPrescription(Prescription prescription){
        if(prescription.getDrugList()!=null){
            for(Drug drug: prescription.getDrugList()){
                drug.setPrescription(prescription);
            }
        }
        this.sessionFactory.getCurrentSession().saveOrUpdate(prescription);
        return prescription.getPid();
    }

    public int deletePrescription(Prescription prescription){
        this.sessionFactory.getCurrentSession().delete(prescription);
        return prescription.getPid();
    }

    public int updatePrescription(Prescription prescription){
        if(prescription.getDrugList()!=null){
            for(Drug drug: prescription.getDrugList()){
                drug.setPrescription(prescription);
            }
        }
        this.sessionFactory.getCurrentSession().update(prescription);
        return prescription.getPid();
    }

    public List<Prescription> getAllPrescriptions(){
        return this.sessionFactory.getCurrentSession().createQuery("from Prescription").list();
    }

    public int removeDrug(Drug drug){
        this.sessionFactory.getCurrentSession().delete(drug);
        return drug.getId();
    }

    public List<Drug> getPrescriptionDetails(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug as d where d.prescription.pid =:id");
        query.setInteger("id",id);
        return query.list();
    }
}
