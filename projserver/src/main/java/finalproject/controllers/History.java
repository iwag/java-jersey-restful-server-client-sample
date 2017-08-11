package finalproject.controllers;

import finalproject.models.entities.ExInterviewEntity;
import finalproject.models.entities.ExInterviewQuestionEntity;
import finalproject.models.entities.HistoryEntryEntity;
import finalproject.models.responsemodels.HistoryEntryResponseModel;
import finalproject.models.responsemodels.HistoryResponseModel;
import finalproject.models.responsemodels.InterviewQuestionResponseModel;
import finalproject.models.responsemodels.InterviewResponseModel;
import finalproject.store.Stores;

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
