package service;


import model.DrugList;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrugsService {

    @Autowired
    private SessionFactory sessionFactory;

    public DrugsService() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addDrug(DrugList drug){
        this.sessionFactory.getCurrentSession().save(drug);
        return drug.getId();
    }

    public DrugList getDrugbyId(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from DrugList where id=:id");
        query.setInteger("id",id);
        return (DrugList)query.uniqueResult();
    }

    public List<DrugList> getDrugsbyName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from DrugList d where d.name like :name");
        query.setString("name", "%"+name+"%");
        return query.list();
    }

    public List<DrugList> getAllDrugs(){
        return sessionFactory.getCurrentSession().createQuery("from DrugList").list();
    }

    public int removeDrug(DrugList drug){
        this.sessionFactory.getCurrentSession().delete(drug);
        return drug.getId();
    }

    public int updateDrug(DrugList drug){
        this.sessionFactory.getCurrentSession().update(drug);
        return drug.getId();
    }


}
