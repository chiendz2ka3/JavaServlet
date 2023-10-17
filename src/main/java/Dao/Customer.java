package Dao;

import Entities.CustomerEntity;

import java.util.ArrayList;

public interface Customer {
    public ArrayList<CustomerEntity> GetListCus();
    public Boolean AddNewCustomer(CustomerEntity data);

    public boolean DeleteCustomer(int id);
    public void UpdateCustomer(int id);
}
