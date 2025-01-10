public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);
        Employee ivanov1 = new Employee("Иванов Иван Иванович", 1, 100000);
        employeeBook.addEmployee(ivanov1);
        Employee petrov1 = new Employee("Петров Петр Петрович", 2, 120000);
        employeeBook.addEmployee(petrov1);
        Employee ivanov2 = new Employee("Иванов Иван Иванович", 1, 100000);
        employeeBook.addEmployee(ivanov2);
        Employee sidorov1 = new Employee("Сидоров Сидор Сидорович", 3, 123456);
        employeeBook.addEmployee(sidorov1);
        Employee maksimov1 = new Employee("Максимов Роман Федорович", 1, 999999);
        employeeBook.addEmployee(maksimov1);
        Employee nazarova1 = new Employee("Назарова Наталья Сергеевна", 2, 321654);
        employeeBook.addEmployee(nazarova1);
        Employee stepanov1 = new Employee("Степанов Евгений Васильевич", 2, 999999);
        employeeBook.addEmployee(stepanov1);

        employeeBook.printEmployees();
        employeeBook.removeEmployee(4);
        employeeBook.printEmployees();
        System.out.println("Затраты на ЗП в месяц: " + employeeBook.calculateSalaryFund());
        System.out.println("Сотрудник c минимальной ЗП: " + employeeBook.findMinSalary());
        System.out.println("Сотрудник c максимальной ЗП: " + employeeBook.findMaxSalary());
        System.out.println("Средняя ЗП: " + employeeBook.calculateAverageSalary());
        employeeBook.printEmployeesNames();
        employeeBook.indexAllSalaries(10);
        employeeBook.printEmployees();
        System.out.println("В отделе 2 минимальную ЗП имеет " + employeeBook.findMinDeptSalary(2));
        System.out.println("В отделе 2 максимальную ЗП имеет " + employeeBook.findMaxDeptSalary(2));
        employeeBook.printDeptEmployeesNames(2);
        employeeBook.indexDeptSalaries(2, 10);
        employeeBook.printDeptEmployeesNames(2);
        System.out.println("Средняя ЗП: " + employeeBook.calculateAverageDeptSalary(2));
        employeeBook.findLessThanDeptSalary(2, 400000);
        employeeBook.findBiggerThanDeptSalary(2, 200000);

    }
}