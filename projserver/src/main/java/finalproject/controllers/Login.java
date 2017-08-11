package finalproject.controllers;

import finalproject.models.entities.ProfileEntity;
import finalproject.models.requestmodels.CredientialRequestModel;
import finalproject.models.responsemodels.CredientialResponseModel;
import finalproject.store.Stores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.UUID;

@Path("login")
public class Login {

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public CredientialResponseModel login(CredientialRequestModel crm) {
        if (!crm.validate()) throw new BadRequestException();

        LocalDate date = LocalDate.now();
        ProfileEntity pe = Stores.userStore.loginUser(crm.getUsername(), crm.getPassword(), date, UUID.randomUUID().toString());
        if (pe==null) throw new BadRequestException();
        return new CredientialResponseModel(pe.getUserEntity().getFirstName(), pe.getUserEntity().getLastName(), pe.getUserEntity().getUserName(), pe.getUserId().toString(), pe.getUserEntity().getCountryLocation(), pe.getDate().toString(), pe.getAuthToken());
    }

}
