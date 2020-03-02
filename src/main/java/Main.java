import individual.Individual;
import reader.ReaderIndividual;
import tax.TaxManager;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderIndividual readerIndividual = ReaderIndividual.getInstance();
        TaxManager manager = TaxManager.getInstance();
        List<Individual> individuals = readerIndividual.readFile(new File("src\\main\\java\\input.xml"));
        for (Individual individual : individuals) {
            System.out.println(individual.getName());
            System.out.println("Payments : " + individual.sumPayments());
            System.out.println("Taxes : " + manager.taxes(individual.getPayments()));
        }

    }
}
