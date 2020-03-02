package tax;

import payment.Payment;

class Tax {
    private double percent;

    public Tax(double value) {
        this.percent = value;
    }

    public double value(Payment payment) {
        return payment.getValue() * percent;
    }
}
