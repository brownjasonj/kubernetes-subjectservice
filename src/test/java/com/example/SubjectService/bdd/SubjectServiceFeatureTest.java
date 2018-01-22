package com.example.SubjectService.bdd;

import com.example.SubjectService.SubjectServiceApplication;
import com.example.SubjectService.bdd.support.RestSupport;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration
@SpringBootTest(
        classes = SubjectServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles(value = "test")
public abstract class SubjectServiceFeatureTest extends RestSupport {
}
