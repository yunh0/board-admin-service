package org.yunho.boardadminservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yunho.boardadminservice.constant.RoleType;
import org.yunho.boardadminservice.domain.AdminAccount;
import org.yunho.boardadminservice.dto.AdminAccountDto;
import org.yunho.boardadminservice.repository.AdminAccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminAccountService {

    private final AdminAccountRepository adminAccountRepository;

    @Transactional(readOnly = true)
    public Optional<AdminAccountDto> searchUser(String username) {
        return adminAccountRepository.findById(username)
                .map(AdminAccountDto::from);
    }

    public AdminAccountDto saveUser(String username, String password, Set<RoleType> roleTypes, String email, String nickname, String memo) {
        return AdminAccountDto.from(
                adminAccountRepository.save(AdminAccount.of(username, password, roleTypes, email, nickname, memo, username))
        );
    }

    @Transactional(readOnly = true)
    public List<AdminAccountDto> users() {
        return adminAccountRepository.findAll().stream()
                .map(AdminAccountDto::from)
                .toList();
    }

    public void deleteUser(String username) {
        adminAccountRepository.deleteById(username);
    }

}
