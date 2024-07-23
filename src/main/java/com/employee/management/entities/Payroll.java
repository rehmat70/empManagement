package com.employee.management.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter

@Table(name = "payroll", schema = "operation")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payroll")
    @SequenceGenerator(name = "seq_payroll", sequenceName = "seq_payroll", allocationSize = 1)

    private Long payrollId;
    @Column(name = "basic_salary")
    private BigDecimal basicSalary;
    @Column(name = "previous_salary")
    private BigDecimal previousSalary;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "report")
    private String report;

    @Column(name = "total_salary")
    private BigDecimal totalSalary;

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
        updateTotalSalary();
    }

    public void setPreviousSalary(BigDecimal previousSalary) {
        this.previousSalary = previousSalary;
        updateTotalSalary();
    }

    private void updateTotalSalary() {
        if (basicSalary != null && previousSalary != null){
            totalSalary = basicSalary.add(previousSalary);
        }
    }

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "employee_Id", referencedColumnName = "employeeId")
    //  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "EmpPayroll"})
    // @JsonIgnoreProperties(value = {"firstName", "lastName", "age", "gender", "emailAddress", "contactNumber","empDepartment"})
    private Employee employee;



}

