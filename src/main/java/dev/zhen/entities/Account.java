package dev.zhen.entities;

public class Account {

    private int accountId;
    private int clientID;
    private double balance;
    private String number;
    private long createDate;

    public Account() {
    }

    public Account(int accountId, int clientID, double balance, String number, long createDate) {
        this.accountId = accountId;
        this.clientID = clientID;
        this.number = number;
        this.createDate = createDate;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getNumber() {
        return number;
    }

    public long getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", clientID=" + clientID +
                ", balance=" + balance +
                ", number='" + number + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
