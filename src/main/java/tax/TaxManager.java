package tax;

import payment.Payment;
import payment.PaymentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxManager {
    private Map<PaymentType, Tax> taxRegistry = new HashMap<>();
    private static TaxManager taxManager;

    static public TaxManager getInstance() {
        if (taxManager == null) {
            taxManager = new TaxManager();
        }
        return taxManager;
    }

    private TaxManager() {
        taxRegistry.put(PaymentType.BENEFIT, new Tax(0.05d));
        taxRegistry.put(PaymentType.SALARY, new Tax(0.13d));
        taxRegistry.put(PaymentType.SALE, new Tax(0.15d));
        taxRegistry.put(PaymentType.GIFT, new Tax(0.20d));
        taxRegistry.put(PaymentType.MATERIALHELP, new Tax(0.003d));
        taxRegistry.put(PaymentType.ROYALTIES, new Tax(0.3d));
        taxRegistry.put(PaymentType.TRANSFER, new Tax(0.16d));
    }

    public double taxes(List<Payment> paymentList) {
        return paymentList.stream().mapToDouble(value -> taxRegistry.get(value.getPaymentType()).value(value)).sum();
    }

}
