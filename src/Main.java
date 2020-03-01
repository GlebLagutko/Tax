import individual.Individual;
import payment.Payment;
import reader.ReaderIndividual;
import tax.TaxManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        ReaderIndividual readerIndividual = ReaderIndividual.getInstance();

        TaxManager manager = TaxManager.getInstance();
        Individual individual = readerIndividual.readFile(new File("src\\input.xml")).get(0);
        System.out.println("Payments : " + individual.sumPayments());
        System.out.println("Taxes : " + manager.taxes(individual.getPayments()));
    }
}
