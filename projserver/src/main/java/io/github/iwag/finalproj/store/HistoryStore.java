package io.github.iwag.finalproj.store;


import io.github.iwag.finalproj.models.entities.HistoryEntryEntity;

import java.time.LocalDate;
import java.util.*;

public class HistoryStore {
    Map<Integer, List<HistoryEntryEntity>> map;

    public HistoryStore() {
        map = new HashMap<>();
    }

    public void addHistory(Integer userid, String topic, LocalDate date, String score) {
        if (!map.containsKey(userid)) {
            map.put(userid, new LinkedList<>());
        }

        map.get(userid).add(new HistoryEntryEntity(topic, date, score));
    }

    public List<HistoryEntryEntity> getByUser(Integer userid) {
        if (!map.containsKey(userid)) {
            return Arrays.asList();
        }
        return map.get(userid);
    }
}
