package com.sis.jhs.perfit.domain.account;

import com.sis.jhs.perfit.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(unique = true, length = 20, nullable = false)
    private String accountId;

    @Column(nullable = false, length = 16)
    private String accountPassword;

    @Column(nullable = false, length = 10)
    private String accountName;


    @Builder
    public Account(String accountId, String accountPassword, String accountName) {
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.accountName = accountName;
    }

    public boolean checkPassword(String accountPassword) {
        return this.accountPassword.equals(accountPassword);
    }

}
