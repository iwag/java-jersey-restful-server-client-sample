package io.github.iwag.jerseystarter;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * If you deal with a class as JAXB, following parts are important at least.
 * If you want to output with JSON, add "org.glassfish.jersey.media" into dependencies
 */

@XmlRootElement // important
public class Task {
    private String description;
    private Integer priority;
    private String untilDate;

    public Task(String description, Integer priority, String untilDate) {
        this.description = description;
        this.priority = priority;
        this.untilDate = untilDate;
    }

    public Task() { // important
    }

    // all fields' setter and getter are necessary
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(String untilDate) {
        this.untilDate = untilDate;
    }
}
