package com.projetoequifax;

import org.springframework.boot.SpringApplication;

public class TestProjetoEquifaxApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProjetoEquifaxTrampoCertoRattingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
