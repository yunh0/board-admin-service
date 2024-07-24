package org.yunho.boardadminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yunho.boardadminservice.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
