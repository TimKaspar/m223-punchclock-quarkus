package ch.zli.m223.kti.punchclock.controller;

import ch.zli.m223.kti.punchclock.domain.User;
import ch.zli.m223.kti.punchclock.service.AuthenticationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class AuthenticationController {
    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(User user) {
        if (user == null) {
            throw new NotAuthorizedException("User does not exist");
        }

        return authenticationService.GenerateValidJwtToken(user.getUsername());
    }
}
