package io.github.iwag.finalproj.controllers;


import io.github.iwag.finalproj.models.entities.*;
import io.github.iwag.finalproj.models.responsemodels.*;
import io.github.iwag.finalproj.store.Stores;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class History {
    @RequestMapping(method = RequestMethod.GET, path = "/interview/history/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HistoryResponseModel getJSON(@PathVariable("id") Integer id) {
        List<HistoryEntryEntity> ex = Stores.historyStore.getByUser(id);
        if (ex==null) throw new OurApplicationException(HttpStatus.BAD_REQUEST, "bad request");

        List<HistoryEntryResponseModel> list = new LinkedList<>();
        for (HistoryEntryEntity qe : ex ) {
            HistoryEntryResponseModel qrm = new HistoryEntryResponseModel(qe.getTopic(), qe.getDate().toString(), qe.getScore());
            list.add(qrm);
        }

        HistoryResponseModel historyResponseModel = new HistoryResponseModel(list);

        return historyResponseModel;
    }

}
