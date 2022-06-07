package org.alonso.o11y.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppPatient {
    public static void main(String[] args) {
        SpringApplication.run(AppPatient.class, args);
    }

   /* @Bean
    OtlpGrpcMetricExporter otelOtlpGrpcMetricExporter(OtelExporterProperties properties) {
        OtlpGrpcMetricExporterBuilder builder = OtlpGrpcMetricExporter.builder();
        String endpoint = properties.getOtlp().getEndpoint();
        if (StringUtils.hasText(endpoint)) {
            builder.setEndpoint(endpoint);
        }

        Long timeout = properties.getOtlp().getTimeout();
        if (timeout != null) {
            builder.setTimeout(timeout, TimeUnit.MILLISECONDS);
        }

        Map<String, String> headers = properties.getOtlp().getHeaders();
        if (!headers.isEmpty()) {
            Objects.requireNonNull(builder);
            headers.forEach(builder::addHeader);
        }

        return builder.build();
    }

    @Bean
    SdkMeterProvider otelMeterProvider(Resource resource, OtlpGrpcMetricExporter otlpGrpcMetricExporter) {
        return SdkMeterProvider.builder()
            .setResource(resource)
            .registerMetricReader(PeriodicMetricReader.builder(otlpGrpcMetricExporter).setInterval(Duration.ofSeconds(10)).build())
            .build();
    }

    @Bean
    OpenTelemetry otel(SdkTracerProvider tracerProvider, SdkMeterProvider sdkMeterProvider, ContextPropagators contextPropagators) {
        return OpenTelemetrySdk.builder()
            .setTracerProvider(tracerProvider)
            .setMeterProvider(sdkMeterProvider)
            .setPropagators(contextPropagators)
            .build();
    }

    @Bean
    public MeterRegistry otelRegistry(OpenTelemetry openTelemetry) {
        return OpenTelemetryMeterRegistry.builder(openTelemetry)
            .setPrometheusMode(true)
            .build();
    }*/
}
