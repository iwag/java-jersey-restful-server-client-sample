package io.github.iwag.finalproj.controllers;


import io.github.iwag.finalproj.models.entities.*;
import io.github.iwag.finalproj.models.responsemodels.*;
import io.github.iwag.finalproj.store.Stores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@Path("history")
public class History {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public HistoryResponseModel getJSON(@PathParam("id") Integer id) {
        List<HistoryEntryEntity> ex = Stores.historyStore.getByUser(id);
        if (ex==null) throw new BadRequestException();

        List<HistoryEntryResponseModel> list = new LinkedList<>();
        for (HistoryEntryEntity qe : ex ) {
            HistoryEntryResponseModel qrm = new HistoryEntryResponseModel(qe.getTopic(), qe.getDate().toString(), qe.getScore());
            list.add(qrm);
        }

        HistoryResponseModel historyResponseModel = new HistoryResponseModel(list);

        return historyResponseModel;
    }

}
