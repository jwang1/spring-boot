package com.iExpress.notes.notes.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PropertyServiceForJasyptStarterTest {
    @Autowired
    private ApplicationContext ctx;

    private PropertyServiceForJasyptStarter svc;

    @Before
    public void setup() {
        svc = ctx.getBean(PropertyServiceForJasyptStarter.class);
    }

    @Test
    public void whenDecryptedPwdNeeded_GetFromServer() {
        System.setProperty("spring.datasource.password", "password");
        System.out.println(svc.getProperty());

        Environment env = ctx.getBean(Environment.class);
        System.out.println(svc.getPasswordUsingEnv(env));
    }

}