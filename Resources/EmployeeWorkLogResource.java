package Resources;

import adapters.EmployeeWorkLogAdapter;
import dto.EmployeeWorkLogDto;
import io.dropwizard.auth.Auth;
import models.User;
import services.EmployeeWorkLogService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/workLogResource")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeWorkLogResource {
    EmployeeWorkLogService employeeWorkLogService;

    @Inject
    public EmployeeWorkLogResource(EmployeeWorkLogService employeeWorkLogService, EmployeeWorkLogAdapter employeeWorkLogAdapter) {
        this.employeeWorkLogService = employeeWorkLogService;
    }

    @GET
    @Path("/{employeeWorkLogId}")
    public EmployeeWorkLogDto findEmployeeWorkLogById(@PathParam("employeeWorkLogId") Integer employeeWorkLogId) {
        return employeeWorkLogService.findEmployeeWorkLogById(employeeWorkLogId);
    }

    @POST
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EmployeeWorkLogDto addEmployeeWorkLog(@Auth User user, EmployeeWorkLogDto employeeWorkLogDto) {
        return employeeWorkLogService.addEmployeeWorkLog(employeeWorkLogDto);
    }

    @PUT
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployeeWorkLog(@Auth User user,EmployeeWorkLogDto employeeWorkLogDto) {
        employeeWorkLogService.updateEmployeeWorkLog(employeeWorkLogDto);
    }

    @DELETE
    @RolesAllowed("ADMIN")
    @Path("/{employeeWorkLogId}")
    public void deleteEmployeeWOrkLog(@Auth User user,@PathParam("employeeWorkLogId") Integer employeeWokLogId) {
        employeeWorkLogService.deleteEmployeeWorkLog(employeeWokLogId);
    }
}
