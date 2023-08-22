package com.rany.service.console;

import org.apache.commons.cli.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/8/10 21:47
 * @email 18668485565163.com
 */
public class EspCmdConsole {
    private static final Options OPTIONS = new Options();
    private static CommandLine commandLine;
    private static String HELP_STRING = null;

    public static void main(String[] args) {
        initCliArgs(args);
        if (commandLine.hasOption("p")) {
            System.out.println(commandLine.getOptionValue("h"));
            System.out.println(commandLine.getOptionValue("p"));
            System.out.println(commandLine.getOptionValue("u"));
        }
    }

    /**
     * init args
     *
     * @param args args
     */
    private static void initCliArgs(String[] args) {
        CommandLineParser commandLineParser = new DefaultParser();
        // help
        OPTIONS.addOption("help", "usage help");
        // host
        OPTIONS.addOption(Option.builder("h").argName("ipv4").required().hasArg(true).longOpt("host").type(String.class).desc("the host of remote server").build());
        // port
        OPTIONS.addOption(Option.builder("p").argName("port").required().hasArg(true).longOpt("port").type(Short.TYPE).desc("the port of remote server").build());
        // user
        OPTIONS.addOption(Option.builder("u").required().hasArg(true).longOpt("user").type(String.class).desc("the user of remote server").build());
        try {
            commandLine = commandLineParser.parse(OPTIONS, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage() + "\n" + getHelpString());
            System.exit(0);
        }

    }

    /**
     * get string of help usage
     *
     * @return help string
     */
    private static String getHelpString() {
        if (HELP_STRING == null) {
            HelpFormatter helpFormatter = new HelpFormatter();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            helpFormatter.printHelp(printWriter, HelpFormatter.DEFAULT_WIDTH, "esp -help", null,
                    OPTIONS, HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, null);
            printWriter.flush();
            HELP_STRING = new String(byteArrayOutputStream.toByteArray());
            printWriter.close();
        }
        return HELP_STRING;
    }
}
