package camelxmlparser;

import camelxmlparser.processor.XmlParserProcessor;
import camelxmlparser.rout.XmlParserRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MainCamelXmlParser {

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        RouteBuilder xmlParseRoute = new XmlParserRoute(new XmlParserProcessor());

        try {
            camelContext.addRoutes(xmlParseRoute);
            camelContext.start();
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
