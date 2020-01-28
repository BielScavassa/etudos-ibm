package camelxmlparser.processor;

import camelxmlparser.util.MapConverter;
import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class XmlParserMapProcessor implements Processor {

    @Autowired
    public XmlParserMapProcessor() {
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        XStream xStream = new XStream();
        xStream.registerConverter(new MapConverter());
        xStream.alias("customer", Map.class);
        Map<String, String> extractedMap = (Map<String, String>) xStream.fromXML((InputStream) exchange.getIn().getBody());
        System.out.println(extractedMap);

    }
}
