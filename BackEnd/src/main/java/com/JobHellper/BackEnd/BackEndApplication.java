package com.jobhellper.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

@SpringBootApplication
@Theme("my-theme")
public class BackEndApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }
}
