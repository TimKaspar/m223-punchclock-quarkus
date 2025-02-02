package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.domain.Absence;
import ch.zli.m223.kti.punchclock.domain.Entry;
import ch.zli.m223.kti.punchclock.domain.Expense;
import ch.zli.m223.kti.punchclock.service.AbsenceService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/absences")
@Tag(name = "Absences", description = "Handling of absences")
public class AbsenceController {

    @Inject
    AbsenceService absenceService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JsonIgnore
    @Operation(summary = "List all Absences", description = "Returns a List of all Absences")
    public List<Absence> list() {
        return absenceService.getAllAbsences();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Provides a specific Absence", description = "Returns the Absence with the matching id")
    public Absence get(@PathParam("id") Long absenceId) {
        return absenceService.getAbsence(absenceId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Absences", description = "The newly created Absences is returned. The id may not be passed.")
    public Absence add(Absence absence) {
        return absenceService.createAbsence(absence);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a Absence", description = "Deletes the Absence with the matching id")
    public void delete(@PathParam("id") Long absenceId) {
        absenceService.deleteAbsence(absenceId);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update a Absence", description = "Updates the Absence with new values")
    public Absence update(Absence absence) {
        return absenceService.update(absence);
    }
}
