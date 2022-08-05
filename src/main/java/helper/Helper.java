package helper;

import com.example.payroll.model.Employees;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public List<Employees> printErrorMessage(Integer id) {
        List<Employees> employee = new ArrayList<Employees>();
        employee.add(new Employees(id, "Error", "Wrong value specified in URI template variable and or body."));
        return employee;
    }

    public List<Employees> getEmployeeById(Integer id, List<Employees> employees) {
        List<Employees> result = new ArrayList<Employees>();
        for (Employees e : employees) {
            if (e.getId() == id) {
                result.add(e);
            }
        }
        if (result.isEmpty()) {
            return printErrorMessage(id);
        }
        return result;
    }
}
