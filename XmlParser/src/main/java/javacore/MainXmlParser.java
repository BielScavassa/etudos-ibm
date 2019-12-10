package javacore;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class MainXmlParser {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Instant start = Instant.now();
        for (int i = 0; i < 100000; i++) {

            //Cria factory & builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\GABRIELBEVILACQUASCA\\Documents\\ASCG021_60701190_20191203_002.xml"));

            //Normaliza estrutura xml
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            NodeList nList = document.getElementsByTagName(root.getTagName());
            System.out.println("============="+ i + "===============");

            visitChildNodes(nList);
        }
        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toMillis());
    }

    private static void visitChildNodes(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
                //Confere atributos
                if (node.hasAttributes()) {
                    //Get attributes names and values
                    NamedNodeMap nodeMap = node.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node tempNode = nodeMap.item(i);
                        System.out.println("Attr name : " + tempNode.getNodeName() + "; Value = " + tempNode.getNodeValue());
                    }
                    if (node.hasChildNodes()) {
                        visitChildNodes(node.getChildNodes());
                    }
                }
            }
        }
    }
}
