package me.leson.service;

import me.leson.model.Account;
import me.leson.model.User;
import me.leson.repository.AccountRepository;
import me.leson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    private AccountRepository mAccountRepository;

    @Autowired
    private UserRepository mUserRepository;

    @Async
    public void save(Account account) {
        mAccountRepository.save(account);
        User user = new User.UserBuilder().withAccount(account).withPhone(account.getUsername()).build();
        mUserRepository.save(user);
        CompletableFuture.completedFuture(user);
    }
}
