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

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@RestController
public class History extends BaseController {
    @RequestMapping(method = RequestMethod.GET, path = "/interview/history/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HistoryResponseModel getJSON(@PathVariable("id") Integer id) {
        List<HistoryEntryEntity> ex = Stores.historyStore.getByUser(id);
        if (ex == null || ex.isEmpty()) throw new OurApplicationException(HttpStatus.NOT_FOUND, "not found");

        List<HistoryEntryResponseModel> list = new LinkedList<>();
        for (HistoryEntryEntity qe : ex ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

            String dateStr = qe.getDate().format(formatter);

            HistoryEntryResponseModel qrm = new HistoryEntryResponseModel(qe.getTopic(), dateStr, qe.getScore());
            list.add(qrm);
        }

        HistoryResponseModel historyResponseModel = new HistoryResponseModel(list);

        return historyResponseModel;
    }

}
