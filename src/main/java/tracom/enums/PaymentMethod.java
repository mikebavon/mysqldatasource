package tracom.enums;

import java.math.BigDecimal;

public enum PaymentMethod {

    CASH("Kash", BigDecimal.valueOf(10000)),
    EFT("Electronic Fund transfer", BigDecimal.valueOf(100000000)),
    CHEQUE("Cheque", BigDecimal.valueOf(999999)),
    MPESA("M-Pesa - for safaricom",BigDecimal.valueOf(238000)),
    PAYPAL("Paypal - International",BigDecimal.valueOf(20000));

    private String name;

    private BigDecimal maxTxnAmount;

    PaymentMethod(String name, BigDecimal maxTxnAmount){
        this.name = name;
        this.maxTxnAmount = maxTxnAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMaxTxnAmount() {
        return maxTxnAmount;
    }

    public void setMaxTxnAmount(BigDecimal maxTxnAmount) {
        this.maxTxnAmount = maxTxnAmount;
    }

    public String showDetails(){
        return " :The max amount "  + getName() + " is " + getMaxTxnAmount();
    }
}
