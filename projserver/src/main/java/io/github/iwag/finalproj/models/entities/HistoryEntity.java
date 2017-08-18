package io.github.iwag.finalproj.models.entities;

import java.util.List;

public class HistoryEntity {
    private List<HistoryEntryEntity> list;

    public HistoryEntity(List<HistoryEntryEntity> list) {
        this.list = list;
    }

    public List<HistoryEntryEntity> getList() {
        return list;
    }

    public void setList(List<HistoryEntryEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HistoryEntity{" +
                "list=" + list +
                '}';
    }
}
