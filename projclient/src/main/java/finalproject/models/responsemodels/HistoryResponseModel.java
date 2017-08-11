package finalproject.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Iterator;
import java.util.List;

@XmlRootElement
public class HistoryResponseModel implements Iterable<HistoryEntryResponseModel> {
    private List<HistoryEntryResponseModel> history;

    public HistoryResponseModel() {
    }

    public HistoryResponseModel(List<HistoryEntryResponseModel> history) {
        this.history = history;
    }

    public void setHistory(List<HistoryEntryResponseModel> history) {
        this.history = history;
    }

    public List<HistoryEntryResponseModel> getHistory() {
        return history;
    }

    @Override
    public Iterator<HistoryEntryResponseModel> iterator() {
        return history.iterator();
    }
}
