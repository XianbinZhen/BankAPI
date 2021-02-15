package dev.zhen.daotests;

import dev.zhen.daos.AccountDAO;
import dev.zhen.daos.ClientDAO;
import dev.zhen.daos.LocalAccountDAO;
import dev.zhen.daos.LocalClientDAO;
import dev.zhen.entities.Account;
import dev.zhen.entities.Client;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTests {

//    private static ClientDAO clientDAO = new LocalClientDAO();
    private static AccountDAO accountDAO = new LocalAccountDAO();
    private static Account account = null;

    @Test
    @Order(0)
    void create_account() {
//        Client client1 = new Client(0, "client1");
//        clientDAO.createClient(client1);
        Account account1 = new Account(0,0,0, "", 0);
        accountDAO.createAccount(account1);
        account = account1;
        Assertions.assertEquals(1, account1.getAccountId());
        Assertions.assertEquals(System.currentTimeMillis() / 1000, account1.getCreateDate(), 100);
//        System.out.println(account1.getCreateDate());
        System.out.println("TEST 0 passed: create account");
    }

    @Test
    @Order(1)
    void update_account() {
        double oldBalance = account.getBalance();
        accountDAO.updateAccount(account.getAccountId(), 100);
        Assertions.assertEquals(100 + oldBalance, account.getBalance());
        System.out.println("TEST 1 passed: Update account");
    }

    @Test
    @Order(2)
    void get_all_account() {
        Set<Account> allAccount = new HashSet<>(accountDAO.getAllAccount());
        Assertions.assertEquals(1, allAccount.size());
        System.out.println("TEST 2 passed: Get all account");
    }

    @Test
    @Order(3)
    void delete_account_by_id() {
        Set<Account> allAccount = new HashSet<>(accountDAO.getAllAccount());
        int sizeBeforeDelete = allAccount.size();
        boolean isDeleted = accountDAO.deleteAccount(account.getAccountId());
        int sizeAfterDelete = accountDAO.getAllAccount().size();
        Assertions.assertTrue(isDeleted);
        Assertions.assertEquals(sizeAfterDelete + 1, sizeBeforeDelete);
        System.out.println("TEST 3 passed: Delete account by id");

    }


}
