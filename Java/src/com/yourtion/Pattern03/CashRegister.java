package com.yourtion.Pattern03;

/**
 * Created by Yourtion on 10/10/2016.
 */
public class CashRegister {
    private Integer total;

    public CashRegister(Integer startingTotal) {
        total = startingTotal;
    }

    public void addCash(Integer toAdd) {
        total += toAdd;
    }

    public Integer getTotal() {
        return total;
    }

    public void reset() {
        total = 0;
    }
}
