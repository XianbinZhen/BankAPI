package dev.zhen.daos;

import dev.zhen.entities.Account;
import dev.zhen.entities.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocalAccountDAO implements AccountDAO {

    private final Map<Integer, Account> accountTable = new HashMap<>();
    private int idCounter = 0;



    @Override
    public Account createAccount(Account account) {
        account.setAccountId(++idCounter);
        account.setCreateDate(System.currentTimeMillis()/1000);
        accountTable.put(idCounter, account);
        return account;
    }

    @Override
    public Account updateAccount(int id, double balance) {
        Account account = accountTable.get(id);
        account.setBalance(account.getBalance() + balance);
        return account;
    }

    @Override
    public Set<Account> getAllAccount() {
        return new HashSet<>(accountTable.values());
    }

    @Override
    public boolean deleteAccount(int id) {
        Account account = accountTable.remove(id);
        if (account == null)
            return false;
        return true;
    }
}
