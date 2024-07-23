package com.employee.management.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "department", schema = "operation")
public class JobDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_department")
    @SequenceGenerator(name = "seq_department", sequenceName = "seq_department", allocationSize = 1)
    private Long jobDepartment_Id;

    private String department;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "salary_range")
    private String salaryRange;

    @JsonBackReference
    @OneToOne()
    @JoinColumn(name = "employee_Id")
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Employee employees;


}
