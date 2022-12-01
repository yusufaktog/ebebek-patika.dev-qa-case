package com.aktog.yusuf.ebebekpatika.devqacase.log;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {
    protected final Log logger = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.warn(context.getDisplayName() + " is disabled\t reason: " + reason.orElse(" "));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info(context.getDisplayName() + " is successful");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.warn(context.getDisplayName() + " is aborted\t cause: " + cause.getCause());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error(context.getDisplayName() + " is failed\t cause: " + cause.getCause());
    }
}
