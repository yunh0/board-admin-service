package org.yunho.boardadminservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yunho.boardadminservice.dto.response.UserAccountResponse;
import org.yunho.boardadminservice.service.UserAccountManagementService;

@RequiredArgsConstructor
@RequestMapping("/management/user-accounts")
@Controller
public class UserAccountManagementController {

    private final UserAccountManagementService userAccountManagementService;

    @GetMapping
    public String userAccounts(
            Model model,
            HttpServletRequest request
    ) {
        model.addAttribute(
                "userAccounts",
                userAccountManagementService.getUserAccounts().stream().map(UserAccountResponse::from).toList()
        );
        model.addAttribute("currentUri", request.getRequestURI());
        return "management/user-accounts";
    }

    @ResponseBody
    @GetMapping("/{userId}")
    public UserAccountResponse userAccount(@PathVariable String userId) {
        return UserAccountResponse.from(userAccountManagementService.getUserAccount(userId));
    }

    @PostMapping("/{userId}")
    public String deleteUserAccount(@PathVariable String userId) {
        userAccountManagementService.deleteUserAccount(userId);

        return "redirect:/management/user-accounts";
    }


}
