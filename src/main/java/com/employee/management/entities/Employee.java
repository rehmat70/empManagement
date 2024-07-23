package com.employee.management.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee", schema = "operation"
//                uniqueConstraints = {
//                @UniqueConstraint(name = "email_unique", columnNames = "email")
//
//                }
)

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp")
    @SequenceGenerator(name = "seq_emp", sequenceName = "seq_emp", allocationSize = 1)

    private Long employeeId;
    @Column(name = "f_Name")
    private String firstName;
    @Column(name = "l_Name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "phones")
    private List<String> contactNumbers;

    @Column(name = "emp_email")
    private String email;

    @JsonManagedReference
    @OneToOne(mappedBy = "employees", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private JobDepartment jobDepartment;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payroll> payroll;

}
