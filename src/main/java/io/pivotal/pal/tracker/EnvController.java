package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvnController {

    EnvController(@Value("${welcome.message}") String greeting)

      @GetMapping("/env")
    public String getEnv() {
        return greeting;
    }
}

