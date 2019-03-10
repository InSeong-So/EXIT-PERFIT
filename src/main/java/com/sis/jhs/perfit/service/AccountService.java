package com.sis.jhs.perfit.service;

import com.sis.jhs.perfit.domain.account.Account;
import com.sis.jhs.perfit.domain.account.AccountRepository;
import com.sis.jhs.perfit.dto.AccountMainResponseDto;
import com.sis.jhs.perfit.dto.AccountSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Transactional
    public Long save(AccountSaveRequestDto dto) {
        return accountRepository.save(dto.toEntity()).getNo();
    }

    @Transactional
    public List<AccountMainResponseDto> findAllDesc() {
        return accountRepository.findAllDesc()
                .map(AccountMainResponseDto::new)
                .collect(Collectors.toList());
    }

    public Account login(String accountId, String accountPassword) {
        Optional<Account> user = accountRepository.findByAccountId(accountId);
        if (!user.isPresent())
            throw new IllegalStateException();

        Account account = user.get();
        if (!account.checkPassword(accountPassword))
            throw new IllegalStateException();
        return account;
    }
}
