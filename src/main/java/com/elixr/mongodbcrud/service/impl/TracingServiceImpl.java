package com.elixr.mongodbcrud.service.impl;

import brave.Span;
import brave.Tracer;
import com.elixr.mongodbcrud.service.TracingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracingServiceImpl implements TracingService {

    @Autowired
    private Tracer tracer;

    @Override
    public String getTraceId() {
        Span span = tracer.currentSpan();
        return span.context().traceIdString();
    }
}
