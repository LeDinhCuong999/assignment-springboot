package aptech.t2010a.assignmentspringboot.repository;

import aptech.t2010a.assignmentspringboot.entity.Account;
import aptech.t2010a.assignmentspringboot.entity.enums.AccountStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsername(String username);

    Page<Account> findAllByFirstNameOrLastNameOrAddressOrEmailOrPhoneOrUsernameContains(String search, Pageable pageable);

    Page<Account> findAllByStatusEquals(AccountStatus status, Pageable pageable);

    Page<Account> findAllByRoleEquals(String role, Pageable pageable);

//    Page<Account> findAllByAddressContains(String address, Pageable pageable);
//
//    Account findByPhone(String phone);
//
//    Account findByEmail(String email);

//    Page<Account> findAllByCreateAt(LocalDateTime createdAt, Pageable pageable);
//
//    Page<Account> findAllByUpdateAt(LocalDateTime updatedAt, Pageable pageable);
//
//    Page<Account> findAllByDeleteAt(LocalDateTime deletedAt, Pageable pageable);

    Page<Account> findAllByCreateAtBetween(LocalDateTime min, LocalDateTime max, Pageable pageable);

    Page<Account> findAllByUpdateAtBetween(LocalDateTime min, LocalDateTime max, Pageable pageable);

    Page<Account> findAllByDeleteAtBetween(LocalDateTime min, LocalDateTime max, Pageable pageable);

    Page<Account> findAll(Pageable pageable);
}
