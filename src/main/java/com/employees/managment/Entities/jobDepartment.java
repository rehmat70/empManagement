package com.employees.managment.Entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "department", schema = "operation")
public class jobDepartment {
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

    @JsonManagedReference
    @OneToMany(mappedBy = "jobDepartment", fetch = FetchType.LAZY)
    private List<employees> employees;


}
