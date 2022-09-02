package Resources;

import dto.EmployeeDto;
import io.dropwizard.auth.Auth;
import models.User;
import services.EmployeeService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final EmployeeService employeeService;

    @Inject
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @RolesAllowed("ADMIN")
    @Path("/{employeeId}")
    public EmployeeDto findEmployeeById(@Auth User user, @NotNull @PathParam("employeeId") Integer employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @POST
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EmployeeDto addEmployee(@Auth User user, EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PUT
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployee(@Auth User user,@NotNull EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto);
    }

    @DELETE
    @RolesAllowed("ADMIN")
    @Path("/{employeeId}")
    public void deleteEmployee(@Auth User user,@NotNull @PathParam("employeeId") Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}