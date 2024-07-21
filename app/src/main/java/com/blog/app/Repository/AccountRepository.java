package com.blog.app.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.app.Model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    public Account findByUsername(String username);
   
}
