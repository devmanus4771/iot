// Q.1 Design simple HR Application using Spring Framework
public class Slip_9_1 {
    
}
/*Designing a simple **HR (Human Resources) Application** using the **Spring Framework** involves creating a basic system to manage employees, including functionalities like adding, viewing, updating, and deleting employee information.

We'll use **Spring Boot**, a popular module of the Spring Framework, to quickly set up and develop the application. We'll use **Spring Data JPA** for database interaction and **Thymeleaf** for rendering views.

### **Step-by-Step Guide to Building a Simple HR Application**

### **1. Set Up Spring Boot Project**

You can create a Spring Boot project using **Spring Initializr** or by manually creating it.

- Go to [Spring Initializr](https://start.spring.io/)
- Add dependencies: `Spring Web`, `Spring Data JPA`, `Thymeleaf`, `H2 Database` (for simplicity, we'll use an in-memory database).

### **2. Project Structure**

Here’s an overview of the project structure:

```
hr-application/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── hr/
│   │   │           ├── controller/
│   │   │           ├── model/
│   │   │           ├── repository/
│   │   │           └── HrApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       ├── templates/
│   │       │   └── employee-list.html
│   │       └── application.yml
```

### **3. Create the `Employee` Model**

We'll create a simple `Employee` model with properties like `id`, `name`, `email`, and `position`.

```java
package com.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String position;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
```

### **4. Create the `EmployeeRepository`**

The repository interface extends `JpaRepository` to provide CRUD operations.

```java
package com.hr.repository;

import com.hr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

### **5. Create the `EmployeeController`**

The controller will handle HTTP requests and provide responses.

```java
package com.hr.controller;

import com.hr.model.Employee;
import com.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Display all employees
    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee-list";
    }

    // Show form to add a new employee
    @GetMapping("/employee/new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    // Save a new employee
    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    // Edit an existing employee
    @GetMapping("/employee/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee id:" + id));
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    // Delete an employee
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
```

### **6. Create HTML Views with Thymeleaf**

#### **employee-list.html** (List all employees)

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <a href="/employee/new">Add New Employee</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Position</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="employee : ${employees}">
                <td th:text="${employee.id}"></td>
                <td th:text="${employee.name}"></td>
                <td th:text="${employee.email}"></td>
                <td th:text="${employee.position}"></td>
                <td>
                    <a th:href="@{/employee/edit/{id}(id=${employee.id})}">Edit</a>
                    <a th:href="@{/employee/delete/{id}(id=${employee.id})}">Delete</a>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
```

#### **employee-form.html** (Form to add or edit an employee)

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add/Edit Employee</title>
</head>
<body>
    <h1>Add/Edit Employee</h1>
    <form th:action="@{/employee/save}" th:object="${employee}" method="post">
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" th:field="*{name}" required />
        </div>
        <div>
            <label for="email">Email</label>
            <input type="email" id="email" th:field="*{email}" required />
        </div>
        <div>
            <label for="position">Position</label>
            <input type="text" id="position" th:field="*{position}" required />
        </div>
        <button type="submit">Save</button>
    </form>
    <a href="/employees">Back to Employee List</a>
</body>
</html>
```

### **7. Configure the Application Properties**

In `src/main/resources/application.properties`, configure the database and other settings:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

### **8. Run the Application**

Now you can run the application:

1. **Build and run** the Spring Boot application using the command:
   ```bash
   mvn spring-boot:run
   ```
   Or you can run the `HrApplication.java` class directly from the IDE.

2. **Access the HR Application**:
   - Open a browser and go to `http://localhost:8080/employees` to view the list of employees.
   - You can add, edit, or delete employees using the provided forms and links.

### **9. Testing and Enhancements**

Once the application is running, you can test it by:

- Adding new employees.
- Editing existing employee information.
- Deleting employees from the list.

You can enhance the application by adding additional features like:

- Employee search and filtering.
- Employee validation (e.g., checking for duplicate emails).
- Pagination for employee list.

This is a basic HR application built using the Spring Framework with **Spring Boot**, **Spring Data JPA**, and **Thymeleaf** for a simple CRUD interface. */