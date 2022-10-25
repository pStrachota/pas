package pl.lodz.p.pas.service;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import pl.lodz.p.pas.dto.ArticleDto;
import pl.lodz.p.pas.dto.BookDto;
import pl.lodz.p.pas.exception.ItemNotFoundException;
import pl.lodz.p.pas.manager.RentableItemManager;


@Path("/rentable-item")
@Produces("application/json")
@Consumes("application/json")
public class RentableItemService {

    @Inject
    RentableItemManager rentableItemManager;

    @GET
    public Response getAllRentableItems() {
        return Response.ok(rentableItemManager.getRentableItems()).build();
    }

    @GET
    @Path("{id}")
    public Response getRentableItemById(@PathParam("id") @Min(0) Long id) {

        try {
            return Response.ok(rentableItemManager.getRentableItem(id)).build();
        } catch (ItemNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/book")
    public Response createBookRentableItem(BookDto bookDto) {
        rentableItemManager.addRentableItem(bookDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/article")
    public Response createArticleRentableItem(ArticleDto articleDto) {
        rentableItemManager.addRentableItem(articleDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/book/{id}")
    public Response updateBookRentableItem(@PathParam("id") @Min(0) Long id, BookDto bookDto) {

        rentableItemManager.updateRentableItem(id, bookDto);
        return Response.status(Response.Status.NO_CONTENT).build();

    }

    @PUT
    @Path("/article/{id}")
    public Response updateArticleRentableItem(@PathParam("id") @Min(0) Long id,
                                              ArticleDto articleDto) {

        rentableItemManager.updateRentableItem(id, articleDto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteRentableItem(@PathParam("id") @Min(0) Long id) {
        rentableItemManager.deleteRentableItem(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response DeleteRentableItem(@PathParam("id") @Min(0) Long id) {
        rentableItemManager.deleteRentableItem(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
