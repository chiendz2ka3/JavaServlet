package Dao.Resolve;

import Dao.Employee;
import Entities.CustomerEntity;
import Entities.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class EmployeeIPM implements Employee {
    private EntityManagerFactory entityManagerFactory;
    EntityTransaction tran;

    public EmployeeIPM() {
        entityManagerFactory = Persistence.createEntityManagerFactory("customer");
    }
    @Override
    public List<EmployeeEntity> GetListEmploy() {
        try {
            ArrayList<EmployeeEntity> arrayList = new ArrayList<>();
            EntityManager enty = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = enty.getTransaction();
            entityTransaction.begin();
            for(EmployeeEntity data : enty.createQuery("from  EmployeeEntity " , EmployeeEntity.class).getResultList()){
                arrayList.add(data);
            }
            enty.getTransaction().commit();
            enty.close();
            return arrayList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean AddNewEmployee(EmployeeEntity data) {
        try {
            EntityManager enty = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = enty.getTransaction();
            entityTransaction.begin();
            enty.persist(data);
            entityTransaction.commit();
            enty.close();
            return true;
        }catch (Exception E){
            return false;
        }
    }
}
