package HW4;

public abstract class Account {
    private int balance;

    protected Account(int balance) {
        this.balance = balance;
    }

    protected void replenishAccount (int sum) {
        if (sum < 0) {
            throw new IllegalArgumentException("Сумма пополнения счета не может быть отрицательной");
        }
        balance += sum;
    }

    protected void withdraw (int sum) throws InsufficientFundsException {
        if (sum < 0) {
            throw new InsufficientFundsException("Сумма снятия со счета не может быть отрицательной");
        }
        if (sum > balance) {
            throw new InsufficientFundsException("Сумма снятия превышает остаток средств на счете");
        }
        balance -= sum;
    }

    public int getBalance() {
        return balance;
    }



}
