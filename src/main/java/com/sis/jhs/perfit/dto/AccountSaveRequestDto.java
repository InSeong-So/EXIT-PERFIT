package com.sis.jhs.perfit.dto;

import com.sis.jhs.perfit.domain.account.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountSaveRequestDto {

    private String id;
    private String name;
    private String password;

    @Builder
    public AccountSaveRequestDto(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Account toEntity() {
        return Account.builder()
                .accountId(id)
                .accountName(name)
                .accountPassword(password)
                .build();
    }

}