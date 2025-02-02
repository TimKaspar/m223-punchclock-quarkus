package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.domain.Entry;
import ch.zli.m223.kti.punchclock.service.EntryService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JsonIgnore
    @Operation(summary = "List all Entries", description = "Returns a List of all Entries")
    public List<Entry> list() {
        return entryService.getAllEntries();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Provides a specific Entry", description = "Returns the Entry with the matching id")
    public Entry get(@PathParam("id") Long entryId) {
        return entryService.getEntry(entryId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created Entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
        return entryService.createEntry(entry);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a Entry", description = "Deletes the Entry with the matching id")
    public void delete(@PathParam("id") Long entryId) {
        entryService.deleteEntry(entryId);
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update a Entry", description = "Updates the Entry with new values")
    public Entry update(Entry entry) {
        return entryService.update(entry);
    }

}
