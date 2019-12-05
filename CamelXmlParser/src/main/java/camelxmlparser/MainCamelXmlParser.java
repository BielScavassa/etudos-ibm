package camelxmlparser;

import camelxmlparser.processor.XmlParserProcessor;
import camelxmlparser.rout.XmlParserRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.io.InputStream;

public class MainCamelXmlParser {

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        RouteBuilder xmlParseRoute = new XmlParserRoute(new XmlParserProcessor());
        XmlParserProcessor xmlParserProcessor = new XmlParserProcessor();

        try {
            camelContext.addRoutes(xmlParseRoute);
            camelContext.start();
            ProducerTemplate producerTemplate= camelContext.createProducerTemplate();
            InputStream input = MainCamelXmlParser.class.getResourceAsStream("/XmlParser.txt");
            producerTemplate.sendBody("direct:xml_parser_route", input);
            Thread.sleep(20000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
