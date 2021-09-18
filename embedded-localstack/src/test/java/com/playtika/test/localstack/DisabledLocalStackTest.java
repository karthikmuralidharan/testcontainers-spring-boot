package com.playtika.test.localstack;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.testcontainers.containers.Container;

import static org.assertj.core.api.Assertions.assertThat;

public class DisabledLocalStackTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                    EmbeddedLocalStackBootstrapConfiguration.class));

    @Test
    public void contextLoads() {
        contextRunner
                .withPropertyValues(
                        "embedded.localstack.enabled=false"
                )
                .run((context) -> assertThat(context)
                        .hasNotFailed()
                        .doesNotHaveBean(Container.class));
    }

}
