package com.employees.managment.Entities;

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
public class employees {
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


//    //OneToOne Uni Directional mapping
//    @OneToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(name = "dep_Id", referencedColumnName = "jobDepartment_Id")
//    private jobDepartment jobDepartment;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id") // assu:ming department_id is the foreign key column in the employee table
    private jobDepartment jobDepartment;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_Id")
    private payroll payroll;

}
