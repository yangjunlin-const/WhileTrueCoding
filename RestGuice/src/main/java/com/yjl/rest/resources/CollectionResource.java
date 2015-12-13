package com.yjl.rest.resources;

import com.google.inject.Inject;
import com.yjl.rest.Util.GlobalConfigurations;
import com.yjl.rest.core.Container;
import org.jboss.resteasy.spi.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by on 12/10/15.
 */
@Path("/")
@Consumes({"application/json", "application/xml"})
@Produces({"application/json", "application/xml"})
public class CollectionResource {

    private Container container;

    @Inject
    public CollectionResource(Container container) {
        this.container = container;
    }

    @POST
    @Path("/collection")
    @Produces("application/json")
    public void collection(String data, @Context HttpRequest request, @Context HttpHeaders headers, @Context HttpServletRequest servletReq) {
        String tenant = headers.getHeaderString("host");
        System.out.println(tenant);
        File file = new File(GlobalConfigurations.getHomePath(), tenant);
        if (!file.exists()) {
            file.mkdirs();
        }
        File dataFile = new File(file, "data");
        if (!dataFile.exists()) {
            dataFile.mkdirs();
            System.out.println(dataFile.getName());
        }
        File logFile = new File(file, "log");
        if (!logFile.exists()) {
            logFile.mkdirs();
            System.out.println(logFile.getName());
        }
        File tmp = new File(file, "data.xml");
        if (!tmp.exists()) {
            try {
                tmp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmp, true))) {
            bufferedWriter.write(data);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
