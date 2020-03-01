package individual;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class Individual {
    private List<Payment> payments = new ArrayList<>();
    private String name;

    public Individual() {
    }

    public Individual(List<Payment> payments, String name) {
        this.payments = payments;
        this.name = name;
    }

    public Individual(String name) {
        this.name = name;
    }

    public Individual(Node node) {
        List<Payment> payments = new ArrayList<>();
        Node paymentsNode = node.getFirstChild().getNextSibling();
        NodeList paymentsList = paymentsNode.getChildNodes();
        for (int i = 0; i < paymentsList.getLength(); i++) {
            Node nodePayment = paymentsList.item(i);
            String nodeName = nodePayment.getNodeName();
            if (nodeName.equals("payment")) {
                payments.add(new Payment(nodePayment));
            }
        }
        NamedNodeMap attributes = node.getAttributes();
        this.name = attributes.getNamedItem("name").getNodeValue();
        this.payments = payments;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int sumPayments() {
        return payments.stream().mapToInt(Payment::getValue).sum();
    }


}
