package org.yunho.boardadminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yunho.boardadminservice.domain.AdminAccount;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, String> {
}
