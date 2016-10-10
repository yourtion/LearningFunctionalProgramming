package com.yourtion.Pattern03;

import java.util.List;

/**
 * Created by Yourtion on 10/10/2016.
 */
public class RegisterClient {
    private static CashRegister cashRegister = new CashRegister(0);
    private static PurchaseInvoker purchaseInvoker = new PurchaseInvoker();

    public void run() {
        Command purchase1 = new Purchase(cashRegister, 100);
        Command purchase2 = new Purchase(cashRegister, 50);

        // Invoke commands, check register total.
        purchaseInvoker.executePurchase(purchase1);
        purchaseInvoker.executePurchase(purchase2);
        System.out.println("After purchases: " + cashRegister.getTotal());

        // Replay purchases
        cashRegister.reset();
        System.out.println("Register reset to 0");
        List<Command> purchases = purchaseInvoker.getPurchaseHistory();
        for (Command purchase : purchases) {
            purchase.execute();
        }
        System.out.println("After replay: " + cashRegister.getTotal());
    }
}
