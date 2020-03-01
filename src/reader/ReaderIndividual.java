package reader;

import individual.Individual;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderIndividual {
    private static ReaderIndividual reader;

    private ReaderIndividual() {
    }

    public static ReaderIndividual getInstance() {
        if (reader == null) {
            reader = new ReaderIndividual();
        }
        return reader;
    }

    public List<Individual> readFile(File file) {
        List<Individual> individuals = new ArrayList<>();
        try {
            DocumentBuilderFactory products = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = products.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList elements = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < elements.getLength(); i++) {
                Node node = elements.item(i);
                String nodeName = node.getNodeName();
                if (nodeName.equals("individual")) {
                    individuals.add(new Individual(node));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return individuals;
    }
}
