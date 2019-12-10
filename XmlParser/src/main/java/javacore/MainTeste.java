package javacore;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MainTeste {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        //Get Document Builder
        DocumentBuilderFactory factory;
        factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(new File("C:\\Users\\GABRIELBEVILACQUASCA\\Documents\\XlmParser.txt"));

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        String nodeName = root.getChildNodes().item(1).getNodeName();

        //Get all employees
        NodeList nList = document.getElementsByTagName(nodeName);
        System.out.println("============================");

        visitChildNodes(nList);
    }

    //This function is called recursively
    private static void visitChildNodes(NodeList nList)
    {
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
                //Check all attributes
                if (node.hasAttributes()) {
                    // get attributes names and values
                    NamedNodeMap nodeMap = node.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++)
                    {
                        Node tempNode = nodeMap.item(i);
                        System.out.println("Attr name : " + tempNode.getNodeName()+ "; Value = " + tempNode.getNodeValue());
                    }
                    if (node.hasChildNodes()) {
                        //We got more childs; Let's visit them as well
                        visitChildNodes(node.getChildNodes());
                    }
                }
            }
        }
    }
}
