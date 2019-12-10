package camelxmlparser.rout;

import camelxmlparser.processor.XmlParserMapProcessor;
import camelxmlparser.processor.XmlParserProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XmlParserRoute extends RouteBuilder {

    public static final String DIRECT_ROUTE_XML_PARSER = "direct:xml_parser_route";
    public static final String ID_ROUTE_XML_PARSER = "xml_parser_route";
    private final XmlParserProcessor xmlParserProcessor;
    private final XmlParserMapProcessor xmlParserMapProcessor;
    @Autowired
    public XmlParserRoute(XmlParserProcessor xmlParserProcessor, XmlParserMapProcessor xmlParserMapProcessor) {
        this.xmlParserProcessor = xmlParserProcessor;
        this.xmlParserMapProcessor = xmlParserMapProcessor;
    }

    @Override
    public void configure() throws Exception {
        from(DIRECT_ROUTE_XML_PARSER).routeId(ID_ROUTE_XML_PARSER)
                .description("Esta rota trnsforma um arquivo xml em json")
//                .process(xmlParserProcessor)
                .process(xmlParserMapProcessor)
                .end();

    }
}
