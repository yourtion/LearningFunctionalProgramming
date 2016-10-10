package com.yourtion.Pattern03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yourtion on 10/10/2016.
 */
public class PurchaseInvoker {
    private List<Command> executedPurchases = new ArrayList<Command>();

    public void executePurchase(Command purchase) {
        purchase.execute();
        executedPurchases.add(purchase);
    }

    public List<Command> getPurchaseHistory() {
        return executedPurchases;
    }
}
