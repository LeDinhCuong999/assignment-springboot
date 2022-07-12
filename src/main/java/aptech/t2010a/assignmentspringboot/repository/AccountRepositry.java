package aptech.t2010a.assignmentspringboot.repository;

import aptech.t2010a.assignmentspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositry extends JpaRepository<Account, Integer> {
    Account findAccountByUsername(String username);
}
