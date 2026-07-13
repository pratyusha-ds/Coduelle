package com.coduelle.judge.infrastructure.sandbox;

public class ExecutionResult {
    private String stdout;
    private String stderr;
    private int exitCode;

    public ExecutionResult() {}

    public String getStdout() { return stdout; }
    public void setStdout(String stdout) { this.stdout = stdout; }

    public String getStderr() { return stderr; }
    public void setStderr(String stderr) { this.stderr = stderr; }

    public int getExitCode() { return exitCode; }
    public void setExitCode(int exitCode) { this.exitCode = exitCode; }
}
