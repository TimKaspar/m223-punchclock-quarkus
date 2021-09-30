package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.service.AbsenceService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/absences")
@Tag(name = "Absences", description = "Handling of absences")
public class AbsenceController {

    @Inject
    AbsenceService absenceService;
}
