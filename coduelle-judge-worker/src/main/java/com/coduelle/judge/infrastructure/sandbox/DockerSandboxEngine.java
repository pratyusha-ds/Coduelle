package com.coduelle.judge.infrastructure.sandbox;

public interface DockerSandboxEngine {
    ExecutionResult runQuarantined(String sourceCode, String language);
}
