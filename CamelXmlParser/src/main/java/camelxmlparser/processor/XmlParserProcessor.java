package camelxmlparser.processor;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLOutputFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class XmlParserProcessor implements Processor {

    @Autowired
    public XmlParserProcessor() {
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        InputStream input = XmlParserProcessor.class.getResourceAsStream("XmlParser.txt");
        OutputStream output = System.out;

        JsonXMLConfig config = new JsonXMLConfigBuilder()
                .autoArray(true)
                .autoPrimitive(false)
                .prettyPrint(true)
                .build();
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            Source source = new StAXSource(reader);

            XMLStreamWriter writer = new JsonXMLOutputFactory(config).createXMLStreamWriter(output);
            Result result = new StAXResult(writer);

            TransformerFactory.newInstance().newTransformer().transform(source, result);
        } finally {

            output.close();
            input.close();
        }
    }
}
