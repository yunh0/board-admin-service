package org.yunho.boardadminservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yunho.boardadminservice.dto.UserAccountDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserAccountManagementService {

    public List<UserAccountDto> getUserAccounts() {
        return List.of();
    }

    public UserAccountDto getUserAccount(String userId) {
        return null;
    }

    public void deleteUserAccount(String userId) {

    }

}
