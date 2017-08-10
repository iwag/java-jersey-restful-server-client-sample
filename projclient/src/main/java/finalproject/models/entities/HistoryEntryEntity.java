package finalproject.models.entities;

import java.time.LocalDate;

public class HistoryEntryEntity {
    private String topic;
    private LocalDate date;
    private String score;

    public HistoryEntryEntity(String topic, LocalDate date, String score) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "HistoryEntryEntity{" +
                "topic='" + topic + '\'' +
                ", date=" + date +
                ", score='" + score + '\'' +
                '}';
    }
}
