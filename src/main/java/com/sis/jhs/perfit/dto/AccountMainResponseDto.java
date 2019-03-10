package com.sis.jhs.perfit.dto;

import com.sis.jhs.perfit.domain.account.Account;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class AccountMainResponseDto {
    private Long no;
    private String id;
    private String password;
    private String name;
    private String createdDate;
    private String modifiedDate;

    public AccountMainResponseDto(Account entry) {
        no = entry.getNo();
        id = entry.getAccountId();
        password = entry.getAccountPassword();
        name = entry.getAccountName();
        createdDate = toStringDateTime(entry.getCreatedDate());
        modifiedDate = toStringDateTime(entry.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}