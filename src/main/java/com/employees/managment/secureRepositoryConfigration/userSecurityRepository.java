package com.employees.managment.secureRepositoryConfigration;

import com.employees.managment.secureConfigration.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userSecurityRepository extends JpaRepository<UserSecurity, Long> {

    UserSecurity findByUserName(String userName);


}
