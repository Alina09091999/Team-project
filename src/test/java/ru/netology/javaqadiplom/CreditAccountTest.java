package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void NegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount (100, 5_000, -15);
        });

    }

    @Test
    public void NegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount (-100, 5_000, 15);
        });

    }

    @Test
    public void NegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount (100, -5_000, 15);
        });

    }

    @Test
    public void CreditLimit0() {
        CreditAccount account = new CreditAccount(
                100,
                0,
                15
        );
        account.pay(200);

        Assertions.assertEquals(100, account.getBalance());
        }

    @Test
    public void shouldPayForAPositivePurchase() {
        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayForAPositivePurchaseLessThanTheLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3_000, account.getBalance());
    }

    @Test
    public void shouldPayForAPositivePurchaseMoreThanTheLimitWith0InitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayForAPositivePurchaseMoreThanTheLimit() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void shouldPayForA0Purchase() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void shouldPayForANegativePurchase() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.pay(-3_000);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceWithPositiveInitialBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_100, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalanceWith0InitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalanceWithPositiveInitialBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void shouldAddTo0BalanceWithPositiveInitialBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void shouldCalculateToYearChangeWithNegativeBalance() {
        CreditAccount account = new CreditAccount(0,
        1500,15);


        account.pay(200);
        account.yearChange();

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldCalculateToYearChangeWithPositiveBalance() {
        CreditAccount account = new CreditAccount(400,
                1500,15);


        account.pay(200);
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculateToYearChangeWithTheRejectionOfTheFractionalPart() {
        CreditAccount account = new CreditAccount(500,
                1500,15);


        account.pay(887);
        account.yearChange();

        Assertions.assertEquals(-58, account.yearChange());
    }

    @Test
    public void shouldCalculateToYearChangeWith0Rate() {
        CreditAccount account = new CreditAccount(100,
                1500,0);


        account.pay(200);
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculateToYearChangeWithPositiveInitialBalance() {
        CreditAccount account = new CreditAccount(100,
                1500,15);


        account.pay(200);
        account.yearChange();

        Assertions.assertEquals(-15, account.yearChange());
    }
}
