package com.sis.jhs.perfit.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.Stream;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a " +
            "FROM Account a " +
            "ORDER BY a.no DESC")
    Stream<Account> findAllDesc();

    Optional<Account> findByAccountId(String accountId);
}
