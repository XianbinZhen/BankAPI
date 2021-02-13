package dev.zhen.entities;

public class Account {

    private int accountId;
    private String number;
    private long createDate;

    public Account() {
    }

    public Account(int accountId, String number, long createDate) {
        this.accountId = accountId;
        this.number = number;
        this.createDate = createDate;
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
                ", number='" + number + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
