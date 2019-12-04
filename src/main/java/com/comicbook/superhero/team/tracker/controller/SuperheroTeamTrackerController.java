package com.comicbook.superhero.team.tracker.controller;

import com.comicbook.superhero.team.tracker.dto.SuperHero;
import com.comicbook.superhero.team.tracker.service.SuperheroTeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class will be the controller exposing the API's needed by the Justice league tracker system.
 *
 * @author dinuka
 */
@RestController
@RequestMapping("/v1/")
public class SuperheroTeamTrackerController {

    private static Logger LOGGER = LoggerFactory.getLogger(SuperheroTeamTrackerController.class);

    @Autowired
    private SuperheroTeamService superheroTeamService;

    @ResponseBody
    @GetMapping(path = "justiceleague", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SuperHero> getJusticeLeague() {
        LOGGER.info("Received a request to retrive the Justice League");
        return superheroTeamService.getJusticeLeague();
    }

    @ResponseBody
    @GetMapping(path="avengers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SuperHero> getAvengers() {
        LOGGER.info("Handling request have the Avengers Assemble!");
        return superheroTeamService.avengersAssemble();
    }


}
