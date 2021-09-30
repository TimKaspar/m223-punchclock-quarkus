package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.domain.Absence;
import ch.zli.m223.kti.punchclock.domain.Expense;
import ch.zli.m223.kti.punchclock.service.AbsenceService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    @Operation(summary = "List all Absences", description = "return List of all Absences")
    public List<Absence> list() {
        return absenceService.getAllAbsences();
    }

}
