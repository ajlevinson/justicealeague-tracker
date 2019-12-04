package com.comicbook.superhero.team.tracker.controller;

import com.comicbook.superhero.team.tracker.dto.SuperHero;
import com.comicbook.superhero.team.tracker.enums.Publisher;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.comicbook.superhero.team.tracker.SuperheroTeamTrackerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {SuperheroTeamTrackerApplication.class})
@ActiveProfiles("test")
public class SuperheroTeamTrackerControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldGetJusticeLeague() throws Exception {
        String response = mockMvc.perform(get("/v1/justiceleague")).andExpect(status().isOk()).andReturn().
                getResponse().getContentAsString();
        List<SuperHero> actual = new ObjectMapper().readValue(response, new TypeReference<List<SuperHero>>() {
        });
        List<SuperHero> expected = getJusticeLeague();

        assertEquals(expected, actual);
    }

    private List<SuperHero> getJusticeLeague() {
        SuperHero superMan = new SuperHero("Clark Kent", Arrays.asList("Flight", "Super human strength",
                "X-ray vision"), "Metropolis", Publisher.DC.getName());
        SuperHero flash = new SuperHero("Barry Allen", Arrays.asList("Super speed",
                "Tapping into the speed force", "Time travel"), "Central city", Publisher.DC.getName());
        SuperHero batman = new SuperHero("Bruce Wayne", Arrays.asList("Super rich", "Cool Gadgets"),
                "Gotham", Publisher.DC.getName());
        return Arrays.asList(superMan, flash, batman);
    }
}