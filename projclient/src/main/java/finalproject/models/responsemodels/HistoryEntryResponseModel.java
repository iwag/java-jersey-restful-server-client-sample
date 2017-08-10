package finalproject.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HistoryEntryResponseModel {
    private String topic;
    private String date;
    private String score;

    public HistoryEntryResponseModel() {
    }

    public HistoryEntryResponseModel(String topic, String date, String score) {
        this.topic = topic;
        this.date = date;
        this.score = score;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
