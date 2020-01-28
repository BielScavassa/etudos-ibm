package staxon;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLOutputFactory;

public class MainXmlParserJson {

    public static void main(String[] args) throws TransformerException, XMLStreamException, IOException {
        Instant start = Instant.now();
        for (int i = 0; i < 100000; i++) {

            InputStream input = MainXmlParserJson.class.getResourceAsStream("/ASCG021_60701190_20191203_002.xml");
            OutputStream output = System.out;

            JsonXMLConfig config = new JsonXMLConfigBuilder()
                    .autoArray(true)
                    .autoPrimitive(true)
                    .prettyPrint(true)
                    .build();
            try {
                XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
                Source source = new StAXSource(reader);

                XMLStreamWriter writer = new JsonXMLOutputFactory(config).createXMLStreamWriter(output);
                Result result = new StAXResult(writer);
                System.out.println("--------------------" + i + "----------------------------");
                TransformerFactory.newInstance().newTransformer().transform(source, result);
            } finally {
//                output.close();
//                input.close();
            }
        }
        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toMillis());
    }
}
