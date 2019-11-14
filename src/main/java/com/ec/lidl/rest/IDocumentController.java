package com.ec.lidl.rest;

import com.ec.lidl.beans.DetailsBean;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/document")
public interface IDocumentController {

    @POST
    @Path(value = "/generate")
    @Consumes("application/json")
    @Produces("application/octet-stream")
    Response generateDocumentAndReturn(DetailsBean detailsBean) throws IOException;
}
