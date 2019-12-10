package byhasmap;

import com.thoughtworks.xstream.XStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;

public class MainXmlParserHashMap {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Instant start = Instant.now();
        for (int i = 0; i < 100000; i++) {
//Root sem saber nome, mas é necessário fazer um parse no arquivo.
            //Cria factory & builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("C:\\Users\\GABRIELBEVILACQUASCA\\Documents\\ASCG021_60701190_20191203_002.xml"));
            //Normaliza estrutura xml
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            //Cria xStream e mapper
            XStream magicApi = new XStream();
            magicApi.allowTypesByWildcard(new String[] {"com.ibm.byhasmap"}); //Remove security error
            magicApi.registerConverter(new AnotherMapEntryConverter());

            magicApi.alias(root.getTagName(), Map.class);
            InputStream input = MainXmlParserHashMap.class.getResourceAsStream("/ASCG021_60701190_20191203_002.xml");
            Map<String, String> extractedMapFromXml = (Map<String, String>) magicApi.fromXML(input);
            System.out.println(Collections.singletonList("By Hash Map = " + extractedMapFromXml));
        }
        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toMillis());
    }

}
