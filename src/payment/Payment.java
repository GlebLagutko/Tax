package payment;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Payment {
    private Integer value;
    private PaymentType paymentType;

    public Payment(Integer value, PaymentType paymentType) {
        this.value = value;
        this.paymentType = paymentType;
    }

    public Payment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Payment(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        this.value = Integer.parseInt(attributes.getNamedItem("value").getNodeValue());
        this.paymentType = PaymentType.valueOf(attributes.getNamedItem("paymentType").getNodeValue());
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


}
