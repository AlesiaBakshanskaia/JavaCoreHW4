package HW4;

public class Transaction {




    public static void transferMoney(Account donorAccount, Account recipientAccount, int sum) throws InsufficientFundsException {
        if (sum > donorAccount.getBalance()) {
            throw new InsufficientFundsException("Сумма перевода превышает остаток средств на счете списания");
            }
        donorAccount.withdraw(sum);
        recipientAccount.replenishAccount(sum);
    }
}
