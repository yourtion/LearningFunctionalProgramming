package com.yourtion.Pattern03;

/**
 * Created by Yourtion on 10/10/2016.
 */
public class Purchase implements Command {
    private CashRegister cashRegister;
    private Integer amount;

    public Purchase(CashRegister cashRegister, Integer amount) {
        this.cashRegister = cashRegister;
        this.amount = amount;
    }

    @Override
    public void execute() {
        System.out.println("-> Purchase in amount: " + amount);
        cashRegister.addCash(amount);
    }
}
