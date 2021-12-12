package question2.dao;

import question2.entity.Employee;

public class EmployeeDao extends BaseDao<Employee , Long> {
    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
