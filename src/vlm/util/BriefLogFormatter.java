package vlm.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * A Java logging formatter that writes more compact output than the default
 */
class BriefLogFormatter extends Formatter {

    /**
     * Format used for log messages
     */
    private static final ThreadLocal<MessageFormat> messageFormat = ThreadLocal.withInitial(() -> new MessageFormat("[{1}] {0,date,yyyy-MM-dd HH:mm:ss} {4} - {2}\n{3}"));

    /**
     * LoggerConfigurator instance at the top of the name tree
     */
    private static final Logger logger = Logger.getLogger("");

    /**
     * singleton BriefLogFormatter instance
     */
    private static final BriefLogFormatter briefLogFormatter = new BriefLogFormatter();

    private BriefLogFormatter() {
    }

    /**
     * Configures JDK logging to use this class for everything
     */
    static void init() {
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers)
            handler.setFormatter(briefLogFormatter);
    }

    /**
     * Format the log record as follows:
     * <p>
     * Date Level Message ExceptionTrace
     *
     * @param logRecord The log record
     * @return The formatted string
     */
    @Override
    public String format(LogRecord logRecord) {
        Object[] arguments = new Object[5];
        arguments[0] = new Date(logRecord.getMillis());
        arguments[1] = logRecord.getLevel().getName();
        arguments[2] = logRecord.getMessage();
        arguments[4] = logRecord.getLoggerName();

        Throwable exc = logRecord.getThrown();
        if (exc != null) {
            Writer result = new StringWriter();
            exc.printStackTrace(new PrintWriter(result));
            arguments[3] = result.toString();
        } else {
            arguments[3] = "";
        }

        arguments[4] = logRecord.getLoggerName();

        return messageFormat.get().format(arguments);
    }

}
