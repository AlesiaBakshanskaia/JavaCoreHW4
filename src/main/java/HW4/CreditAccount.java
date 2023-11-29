package HW4;

public class CreditAccount extends Account {

    private CreditAccount(int balance) {
        super(balance);
    }

    public static  CreditAccount createrCreditAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Начальный баланс счета не может быть отрицательным");
        }
        return new CreditAccount(balance);
    }
}

