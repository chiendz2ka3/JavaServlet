package Dao.Resolve;

import Dao.Customer;
import Entities.CustomerEntity;
import jakarta.persistence.*;

import java.util.ArrayList;

public class Customeriml implements Customer {
    private EntityManagerFactory entityManagerFactory;
    EntityTransaction tran;

    public Customeriml() {
        entityManagerFactory = Persistence.createEntityManagerFactory("customer");
    }

    @Override
    public ArrayList<CustomerEntity> GetListCus() {
        try {
            ArrayList<CustomerEntity> arrayList = new ArrayList<>();
            EntityManager enty = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = enty.getTransaction();
            entityTransaction.begin();
            for(CustomerEntity data : enty.createQuery("from  CustomerEntity " , CustomerEntity.class).getResultList()){
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
    public Boolean AddNewCustomer(CustomerEntity data) {
       try {
           EntityManager enty = entityManagerFactory.createEntityManager();
           EntityTransaction entityTransaction = enty.getTransaction();
           enty.getTransaction().begin();
           enty.persist(data);
           enty.getTransaction().commit();
           enty.close();
           return true;
       }catch (Exception E){

       }
        return false;
    }

    @Override
    public boolean DeleteCustomer(int id) {
        try {
            EntityManager enty = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = enty.getTransaction();
            entityTransaction.begin();
            CustomerEntity customer = enty.find(CustomerEntity.class , 1);
            enty.remove(customer);
            enty.getTransaction().commit();
            enty.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void UpdateCustomer(int id) {

    }
}
