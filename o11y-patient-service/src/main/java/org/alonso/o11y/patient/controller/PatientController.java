package org.alonso.o11y.patient.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PatientController {
    private static final Logger LOGGER = Logger.getLogger(PatientController.class.getName());;
    private final MeterRegistry meterRegistry;

    public PatientController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/first-patient")
    public String firstPatient() {
        this.meterRegistry.counter("micro_patient_query_first").increment();
        LOGGER.info("Querying the first patient");
        return "First patient has the id ".concat(UUID.randomUUID().toString());
    }
}