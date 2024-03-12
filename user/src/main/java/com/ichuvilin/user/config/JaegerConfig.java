package com.ichuvilin.user.config;

import feign.RequestInterceptor;
import io.micrometer.tracing.Tracer;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaegerConfig {

    @Bean
    public RequestInterceptor feignTraceInterceptor(Tracer tracer) {
        return requestTemplate -> {
            var span = tracer.currentSpan();
            if (span == null) {
                return;
            }
            var spanContext = span.context();
            requestTemplate.header("X-B3-TraceId", spanContext.traceId());
            requestTemplate.header("X-B3-SpanId", spanContext.spanId());
        };
    }

    @Bean
    public OtlpGrpcSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
        return OtlpGrpcSpanExporter.builder().setEndpoint(url).build();
    }
}
