package camelxmlparser.rout;

import camelxmlparser.processor.XmlParserProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XmlParserRoute extends RouteBuilder {

    private static final String DIRECT_ROUTE_XML_PARSER = "direct:xml_parser_route";
    private static final String ID_ROUTE_XML_PARSER = "xml_parser_route";
    private final XmlParserProcessor xmlParserProcessor;

    @Autowired
    public XmlParserRoute(XmlParserProcessor xmlParserProcessor) {
        this.xmlParserProcessor = xmlParserProcessor;
    }

    @Override
    public void configure() throws Exception {
        from(DIRECT_ROUTE_XML_PARSER).routeId(ID_ROUTE_XML_PARSER)
                .description("Esta rota trnsforma um arquivo xml em json")
                .process(xmlParserProcessor)
                .end();

    }
}
