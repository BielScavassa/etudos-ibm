package jaxb;


import de.odysseus.staxon.json.jaxb.JsonXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@JsonXML(
        virtualRoot = true,         // JSON will omit "searchResults" root
        multiplePaths = "/results", // trigger JSON array for "results" list
        prettyPrint = true)         // produce formatted JSON output
@XmlRootElement
public class SearchResults {
    private String
    query;
    private float completedIn;
    private List<Result> results;
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @XmlElement(name = "completed_in")
    public float getCompletedIn() {
        return completedIn;
    }

    public void setCompletedIn(float completedIn) {
        this.completedIn = completedIn;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
