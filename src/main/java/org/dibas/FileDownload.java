package org.dibas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path("/download")
public class FileDownload {

    @GET
    @Path("/pdf")
    public Response downloadPdfFile(){

        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {

                try{
                    java.nio.file.Path path = Paths.get("D:/temp/sample.pdf");
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                }catch (Exception e){
                    throw  new WebApplicationException("File Not Found !!!");
                }

            }
        };

        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = sample.pdf")
                .build();

    }

}
