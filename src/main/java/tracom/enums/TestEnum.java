package tracom.enums;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestEnum {

    /*private static final String mpesa = "MPESA";
    private static final String payPal = "PAYPAL";
    private static final String cheque = "CHEQUE";
    private static final String eft = "EFT";*/

    public static void main(String args []){
        Scanner input = new Scanner(System.in);

        System.out.println("Please input the amount:");

        BigDecimal amount = input.nextBigDecimal();

        System.out.println("Payment methods accepted are: ");
        for (PaymentMethod paymentMethod : PaymentMethod.values()){
            if (paymentMethod.getMaxTxnAmount().compareTo(amount) > 0)
                System.out.println(paymentMethod.getName() + paymentMethod.showDetails());

        }

    }
}
