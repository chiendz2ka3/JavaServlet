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
        ArrayList<CustomerEntity> arrayList = new ArrayList<>();
        EntityManager enty = entityManagerFactory.createEntityManager();
        arrayList = (ArrayList)enty.createQuery("SELECT c FROM Entity CustomerEntity" , Entity.class).getResultList();
        System.out.println("count22: "+ arrayList.size());
        enty.close();
        return arrayList;
    }

    @Override
    public void AddNewCustomer(CustomerEntity data) {
        EntityManager enty = entityManagerFactory.createEntityManager();
        CustomerEntity entity = new CustomerEntity();
        enty.getTransaction().begin();
        enty.persist(entity);
        enty.getTransaction().commit();
        enty.close();
    }
}
