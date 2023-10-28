package Dao;

import Entities.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public interface Customer {
    public ArrayList<CustomerEntity> GetListCus();
    public Boolean AddNewCustomer(CustomerEntity data);

    public boolean DeleteCustomer(int id);
    public void UpdateCustomer(CustomerEntity data);
    public CustomerEntity FindUserWithid(int id);

    public List<CustomerEntity> Paging(int CurrentPage , int RecordPage);
}
