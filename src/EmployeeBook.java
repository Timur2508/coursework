public class EmployeeBook {

    public EmployeeBook(int employeesNumber) {
        this.employeeBook = new Employee[employeesNumber];
    }

    public EmployeeBook(Employee[] employeeBook) {
        this.employeeBook = employeeBook;
    }

    private final Employee[] employeeBook;

    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = newEmployee;
                System.out.println("Сотрудник " + employeeBook[i].getName() + " принят на работу");
                return true;
            }
        }
        System.out.println("Найм нового сотрудника невозможен, нет мест в штатном расписании");
        return false;
    }

    public Employee findEmployee(int id) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getId() == id) {
                    return employee;
                }
            }
        }
        System.out.println("Сотрудник не найден");
        return null;
    }

    public boolean removeEmployee(int id) {
        Employee employeeToRemove = findEmployee(id);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].equals(findEmployee(id))) {
                System.out.println("Cотрудник " + employeeBook[i].getName() + " уволен");
                employeeBook[i] = null;
                return true;
            }
        }
        System.out.println("Сотрудник не найден, увольнение невозможно");
        return false;
    }

    public void printEmployees() {
        System.out.println("Полная информация о сотрудниках компании:");
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculateSalaryFund() {
        double sum = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findMinSalary() {
        double minSalary = employeeBook[0].getSalary();
        Employee minSalaryEmployee = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getSalary() < minSalary) {
                    minSalaryEmployee = employee;
                    minSalary = employee.getSalary();
                }
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalary() {
        double maxSalary = employeeBook[0].getSalary();
        Employee maxSalaryEmployee = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getSalary() > maxSalary) {
                    maxSalaryEmployee = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        return maxSalaryEmployee;
    }

    public double calculateAverageSalary() {
        double averageSalary = 0;
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        System.out.println("Всего сотрудников: " + numberOfEmployees);
        if (numberOfEmployees != 0) {
            averageSalary = Math.floor(calculateSalaryFund() / numberOfEmployees);
        }
        return averageSalary;
    }

    public void printEmployeesNames() {
        System.out.println("Список сотрудников:");
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public void indexAllSalaries(double percent) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                double salary = Math.floor(employee.getSalary() * 100 * (1 + percent / 100) / 100);
                employee.setSalary(salary);
            }
        }
        System.out.println("Зарплата проиндексирована всем сотрудникам компании на " + percent + " процентов");
    }

    public Employee[] deptEmployeesArray(int department) {
        Employee[] deptEmployees = new Employee[employeeBook.length];
        int numberOfDeptEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                deptEmployees[numberOfDeptEmployees] = employee;
                numberOfDeptEmployees++;
            }
        }
        return deptEmployees;
    }

    public Employee findMinDeptSalary(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.findMinSalary();
    }

    public Employee findMaxDeptSalary(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.findMaxSalary();
    }

    public double calculateDeptSalaryFund(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.calculateSalaryFund();
    }

    public double calculateAverageDeptSalary(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.calculateAverageSalary();
    }

    public void indexDeptSalaries(int department, double percent) {
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                double salary = Math.floor(employee.getSalary() * 100 * (1 + percent / 100) / 100);
                employee.setSalary(salary);
            }
        }
    }

    public void printDeptEmployeesNames(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        System.out.println("Отдел " + department + ".");
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        deptEmployeeBook.printEmployeesNames();
    }

    public void findLessThanDeptSalary(int department, double salary) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        System.out.println("В отделе " + department + " З/П меньше, чем " + salary + " у следующих сотрудников:");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                if (employee.getSalary() < salary) {
                    System.out.println("Сотрудник: " + employee.getName() + ", табельный номер: " + employee.getId() + ", З/П: " + employee.getSalary());
                }
            }
        }
    }

    public void findBiggerThanDeptSalary(int department, double salary) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        System.out.println("В отделе " + department + " З/П больше, чем " + salary + " у следующих сотрудников:");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                if (employee.getSalary() > salary) {
                    System.out.println("Сотрудник: " + employee.getName() + ", табельный номер: " + employee.getId() + ", З/П: " + employee.getSalary());
                }
            }
        }
    }
}