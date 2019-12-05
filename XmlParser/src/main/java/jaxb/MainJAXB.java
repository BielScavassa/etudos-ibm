package jaxb;

import de.odysseus.staxon.json.jaxb.JsonXMLMapper;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class MainJAXB {
    /**
     * @param args ignored
     * @throws IOException
     * @throws XMLStreamException
     * @throws JAXBException
     */
    public static void main(String[] args) throws JAXBException, XMLStreamException, IOException {
        /*
         * Search for tweets containing the #JAXB" hashtag.
         */
        InputStream input = new URL("https://twitter.com/search?q=JAXB").openStream();

        /*
         * Create mapper instance.
         */
        JsonXMLMapper<SearchResults> mapper = new JsonXMLMapper<SearchResults>(SearchResults.class);

        /*
         * Read tweets.
         */
        SearchResults searchResults = mapper.readObject(input);
        input.close();

        /*
         * Add an item for fun...
         */
        Result result = new Result();
        result.setCreatedAt(new Date());
        result.setFromUser("ChristophBeck");
        result.setText("You can do #JAXB with StAXON too:)");
        searchResults.getResults().add(0, result);

        /*
         * Write back to console.
         */
        mapper.writeObject(System.out, searchResults);
    }
}
