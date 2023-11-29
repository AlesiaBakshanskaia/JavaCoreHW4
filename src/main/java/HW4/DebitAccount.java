package HW4;

public class DebitAccount extends Account {

    private DebitAccount(int balance) {
        super(balance);
    }

    public static DebitAccount createrDebitAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Начальный баланс счета не может быть отрицательным");
        }
        return new DebitAccount(balance);
    }
}

