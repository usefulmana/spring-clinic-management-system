package service;


import model.Diagnosis;
import model.Disease;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiagnosisService {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addDiagnosis(Diagnosis diagnosis){
        if(diagnosis.getDiseases()!=null){
            for(Disease disease: diagnosis.getDiseases()){
                disease.setDiagnosis(diagnosis);
            }
        }

        this.sessionFactory.getCurrentSession().saveOrUpdate(diagnosis);
        return diagnosis.getDid();
    }

    public int deleteDiagnosis(Diagnosis diagnosis){
        this.sessionFactory.getCurrentSession().delete(diagnosis);
        return diagnosis.getDid();
    }

    public int updateDiagnosis(Diagnosis diagnosis){
        if(diagnosis.getDiseases()!=null){
            for(Disease disease: diagnosis.getDiseases()){
                disease.setDiagnosis(diagnosis);
            }
        }

        this.sessionFactory.getCurrentSession().update(diagnosis);
        return diagnosis.getDid();
    }

    public List<Disease> getDiagnosisDetails(int did){
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Disease as d where d.diagnosis.id=:id");
        query.setInteger("id",did);
        return query.list();
    }
}
