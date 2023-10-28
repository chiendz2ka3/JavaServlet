package Dao;

import Entities.EmployeeEntity;

import java.util.List;

public interface Employee {
    public List<EmployeeEntity> GetListEmploy();
    public boolean AddNewEmployee(EmployeeEntity data);
}
