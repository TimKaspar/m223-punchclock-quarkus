package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.domain.Entry;
import ch.zli.m223.kti.punchclock.domain.Expense;
import ch.zli.m223.kti.punchclock.service.ExpenseService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/expenses")
@Tag(name = "Expenses", description = "Handling of expenses")
public class ExpenseController {

    @Inject
    ExpenseService expenseService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JsonIgnore
    @Operation(summary = "List all Expenses", description = "return List of all Expenses")
    public List<Expense> list() {
        return expenseService.getAllExpenses();
    }

    @GET
    @Path("/{id}")
    public Expense get(@PathParam("id") Long expenseId) {
        return expenseService.getExpense(expenseId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Expense", description = "The newly created Expense is returned. The id may not be passed.")
    public Expense add(Expense expense) {
        return expenseService.createExpense(expense);
    }
}
