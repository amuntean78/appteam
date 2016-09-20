package com.app.controller;


import com.app.AppTeamApplication;
import com.app.entity.App;
import com.app.entity.State;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = AppTeamApplication.class)
    @WebAppConfiguration
    public class AppControllerTest extends BaseControllerTest {

     private List<App> apps;

        @Autowired
        private AppController appcontroller;

        @Autowired
        private StateController statecontroller;

        @Before
        public void initApp() throws Exception {

            App app1 = new App(123, "Skype", "Skype 123");
            App app2 = new App(1234, "Chrome", "Chrome 1234");

            State startState = new State();
            State idleState = new State();
            State activeState = new State();
            State stopState = new State();



//
//            app1.getStates().add(startState);
//            app1.getStates().add(idleState);
//            app1.getStates().add(activeState);
//            app1.getStates().add(stopState);
//
//            app2.getStates().add(startState);
//
//            apps = new ArrayList<>();
//
//            apps.add(app1);
//            apps.add(app2);
//


            List<State> states = Arrays.asList(startState, idleState,activeState,stopState);

            app1.setStates(states);
            appcontroller.addApp(app1);
            appcontroller.addApp(app2);

        }

        @After
        public void tearDown() throws Exception {

        }

        @Test
        public void getApps() throws Exception {


            mockMvc.perform(get("/apps")
                    .accept(MediaType.APPLICATION_JSON)
            )
                    .andDo(print())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].states", hasSize(4)))
                    .andExpect(status().isOk());
        }


        @Test
        public void getInexistentApp() throws Exception {
            mockMvc.perform(get("/apps/2")).andDo(print()).andExpect(status().isNotFound());
        }

        @Test
        public void getAppById() throws Exception {

            mockMvc.perform(get("/apps/1")).andDo(print()).andExpect( status().isOk() );
        }
        @Test
        public void getApp() throws Exception {
//            App app = new App();
//            mockMvc.perform(get("/apps/{1}", app.getId())
//                    .accept( MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect( (ResultMatcher) jsonPath("$.id", is((int) app.getId())) )
//                    .andExpect( (ResultMatcher) jsonPath("$.processname", is(app.getProcessName())) )
//                    .andExpect( (ResultMatcher) jsonPath("$.processtitle", is(app.getTitle())) )
//                    .andExpect(status().isOk());
       }

    }
