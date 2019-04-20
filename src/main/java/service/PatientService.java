package service;


import model.Patient;
import model.Visit;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPatient(Patient patient){

        if(patient.getVisits()!=null){
            for(Visit visit: patient.getVisits()){
                visit.setPatient(patient);
            }
        }
        this.sessionFactory.getCurrentSession().saveOrUpdate(patient);
        return patient.getId();
    }

    public int logVisit(Visit visit){
        this.sessionFactory.getCurrentSession().saveOrUpdate(visit);
        return visit.getVisitId();
    }

    public List<Visit> getLogById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit as vs where vs.patient.id =:id");
        query.setInteger("id",id);
        return query.list();
    }


    public int removePatient(Patient patient)
    {
        this.sessionFactory.getCurrentSession().delete(patient);
        return patient.getId();
    }

    public List<Patient> getAllPatients(){
        return sessionFactory.getCurrentSession().createQuery("from Patient").list();
    }

    public Patient getPatientById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id=:id");
        query.setInteger("id", id);
        return (Patient)query.uniqueResult();
    }

    public List<Patient> getPatientbyName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient p where p.name like :name");
        query.setString("name", "%"+name+"%");
        return query.list();
    }

    public int updatePatient(Patient patient){
        if(patient.getVisits()!=null){
            for(Visit visit: patient.getVisits()){
                visit.setPatient(patient);
            }
        }
        this.sessionFactory.getCurrentSession().update(patient);
        return patient.getId();
    }
}
