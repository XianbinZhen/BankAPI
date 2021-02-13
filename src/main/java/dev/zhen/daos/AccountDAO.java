package dev.zhen.daos;

import dev.zhen.entities.Account;

import java.util.Set;

public interface AccountDAO {

    Account createAccount(Account account);
    Account updateAccount(int id, double balance);
    Set<Account> getAllAccount();
    boolean deleteAccount(int id);
}
