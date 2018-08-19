package com.iExpress.notes.notes.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring-Boot Integration tests for {@link PropertyServiceForJasyptStarter}
 * @author jwang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties"
)
public class PropertyServiceForJasyptStarterIntegrationTest {
    @Autowired
    private ApplicationContext ctx;

    private PropertyServiceForJasyptStarter svc;

    @Before
    public void setup() {
        svc = ctx.getBean(PropertyServiceForJasyptStarter.class);
    }

    @Test
    public void whenDecryptedPwdNeeded_GetFromServer() {
        // System.setProperty("jasypt.encryptor.password", "CANNOT-PROVIDER-HERE__otherwise_DB-PWD_exposed----can-try-from-run-config-...");
        System.out.println(svc.getProperty());

        Environment env = ctx.getBean(Environment.class);
        System.out.println(svc.getPasswordUsingEnv(env));
    }

}