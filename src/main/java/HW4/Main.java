package HW4;

import java.util.Scanner;

import static HW4.CreditAccount.createrCreditAccount;
import static HW4.DebitAccount.createrDebitAccount;
import static HW4.Transaction.transferMoney;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String accountsStatusMessage = "Баланс вашего дебетового счета: %d, баланс вашего кредитного счета: %d\n";
        Account dA = null;
        Account cA = null;


        while (dA == null) {
            try {
                System.out.println("Для открытия дебетового счета введите начальный баланс");
                int sumDebit = Integer.parseInt(in.nextLine());
                dA = createrDebitAccount(sumDebit);
                System.out.printf("Баланс дебетового счета составляет: %d%n", dA.getBalance());
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (cA == null) {
            try {
                System.out.println("Для открытия кредитного счета введите начальный баланс");
                int sumCredit = Integer.parseInt(in.nextLine());
                cA = createrCreditAccount(sumCredit);
                System.out.printf("Баланс кредитного счета составляет: %d%n", cA.getBalance());
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) {
            System.out.print("""
                    Выберите действие со счетами, нажав соответствующую цифру:
                    "1" -> пополнить дебетовый счёт
                    "2" -> пополнить кредитный счёт
                    "3" -> снять деньги с дебетового счёта
                    "4" -> снять деньги с кредитного счёта
                    "5" -> перевести деньги с дебетового на кредитный счет
                    "6" -> перевести деньги с кредитного на дебетовый счет
                    "0" -> выйти из приложения
                    """);
            String inputString = in.nextLine();

            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой. Попробуйте ещё раз!\n");
                continue;
            }

            if (inputString.equals("0")) {
                System.out.println("Работа программы завершена.\n");
                break;
            }

            if (inputString.equals("1")) {
                try {
                    System.out.println("Введите сумму внесения: ");
                    int sum = Integer.parseInt(in.nextLine());
                    dA.replenishAccount(sum);
                    System.out.printf(accountsStatusMessage, dA.getBalance(), cA.getBalance());
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }

            if (inputString.equals("2")) {
                try {
                    System.out.println("Введите сумму внесения: ");
                    int sum = Integer.parseInt(in.nextLine());
                    cA.replenishAccount(sum);
                    System.out.printf(accountsStatusMessage, dA.getBalance(), cA.getBalance());

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }

            if (inputString.equals("3")) {
                try {
                    System.out.println("Введите сумму списания: ");
                    int sum = Integer.parseInt(in.nextLine());
                    dA.withdraw(sum);
                    System.out.printf(accountsStatusMessage, dA.getBalance(), cA.getBalance());

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            if (inputString.equals("4")) {
                try {
                    System.out.println("Введите сумму списания: ");
                    int sum = Integer.parseInt(in.nextLine());
                    cA.withdraw(sum);
                    System.out.printf(accountsStatusMessage, dA.getBalance(), cA.getBalance());

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            if (inputString.equals("5")) {
                try {
                    System.out.println("Введите сумму перевода: ");
                    int sum = Integer.parseInt(in.nextLine());
                    transferMoney(dA, cA, sum);
                    System.out.printf(accountsStatusMessage, dA.getBalance(), cA.getBalance());

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            if (inputString.equals("6")) {
                try {
                    System.out.println("Введите сумму перевода: ");
                    int sum = Integer.parseInt(in.nextLine());
                    transferMoney(cA, dA, sum);
                    System.out.printf(accountsStatusMessage, dA.getBalance(), cA.getBalance());

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Ошибка ввода команды. Попробуйте ещё раз!\n");
            }
        }


    }
}
