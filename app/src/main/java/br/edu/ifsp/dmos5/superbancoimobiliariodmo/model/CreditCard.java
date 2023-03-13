package br.edu.ifsp.dmos5.superbancoimobiliariodmo.model;

public class CreditCard {

    private int id; //ID
    private double balance; //saldo
    private static int LAST_CARD_ID = 1; //contador de ID

    public CreditCard() {
        this.id = LAST_CARD_ID;
        this.balance = 0;
        LAST_CARD_ID += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getLastCardId() {
        return LAST_CARD_ID;
    }

    public static void setLastCardId(int lastCardId) {
        LAST_CARD_ID = lastCardId;
    }


    public void creditValue(double value) {
        this.balance = getBalance() + value;

    }

    public void debitValue(double value) throws SaldoNegativoException {

        if (getBalance() >= value) {
            this.balance = getBalance() - value;
        } else {
            throw new SaldoNegativoException();
        }


    }


}
