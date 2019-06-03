package csw.java.log;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LogBackTest.class);

    public static void main(String[] args) throws InterruptedException {
        configureLogbackPath("src/main/resources/scheduler-logback.xml");
        while (true) {
            LOGGER.error("sduuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuhnhn");
//			Thread.sleep(1000);

        }

    }

    /**
     * 配置logback配置文件路径
     *
     * @param logbackPath
     */
    public static void configureLogbackPath(String logbackPath) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);

        // Call context.reset() to clear any previous configuration, e.g. default
        // configuration. For multi-step configuration, omit calling
        // context.reset().
        context.reset();

        try {
            configurator.doConfigure(logbackPath);
        } catch (JoranException e) {
            e.printStackTrace();
        }

        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }
}
