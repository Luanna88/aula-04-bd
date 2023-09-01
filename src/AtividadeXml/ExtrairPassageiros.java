package AtividadeXml;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class ExtrairPassageiros {

	public static void main(String[] args) {
		
		try {
            File inputFile = new File("passageiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passageiro");
            int totalPassageiros = nodeList.getLength();

            System.out.println("Número de passageiros: " + totalPassageiros);
            System.out.println("Origens e destinos:");

            for (int temp = 0; temp < totalPassageiros; temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element passageiroElement = (Element) node;
                    String origem = passageiroElement.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = passageiroElement.getElementsByTagName("destino").item(0).getTextContent();

                    System.out.println("Passageiro " + (temp + 1) + ": Origem - " + origem + ", Destino - " + destino);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
