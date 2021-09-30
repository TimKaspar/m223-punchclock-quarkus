package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.service.ExpenseService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/expenses")
@Tag(name = "Expenses", description = "Handling of expenses")
public class ExpenseController {

    @Inject
    ExpenseService expenseService;
}
