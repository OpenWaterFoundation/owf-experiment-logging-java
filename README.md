# owf-experiment-logging-java
Open Water Foundation experiment to understand different Java logging frameworks

## Getting Started

```
> C:
> cd \Users\user
> mkdir Experiment-Logging
> cd Experiment-Logging
> mkdir git-repos
> cd git-repos
> git clone https://github.com/OpenWaterFoundation/owf-experiment-logging-java.git
```

The repository contains an Eclipse project made up of a single java class.

Within this README will be four different sections explaining how to properly run the java class with each logging framework.

## SLF4J

### What is SLF4j?
Simple Logging Facade for Java (SLF4J) provides a Java logging API by means of a simple facade pattern. The underlying logging backend is determined at runtime by adding the desired binding to the classpath and may be the standard Sun Java logging package java.util.logging, log4j, logback or tinylog. The separation of the client API from the logging backend reduces the coupling between an application and any particular logging framework. This can make it easier to integrate with existing or third-party code or to deliver code into other projects that have already made a choice of logging backend.

Enable the SLF4J framework in a Java application as follows:

1.) Include the following Maven dependencies, which will provide jar files to the application:

**(Use the latest stable version. Do Not use the alpha versions. Make sure to use the same version for both dependencies.)**
* [SLF4J-API](https://mvnrepository.com/artifact/org.slf4j/slf4j-api)
* [SLF4J-Simple](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple)

2.) Write logging messages using the SLF4J API

3.) Run the program as a Java Application

4.) Advanced: Add the following code to the VM arguments in the Run Configurations in order to set what log level will be printed to the console:
```
-Dorg.slf4j.simpleLogger.defaultLogLevel=DEBUG
```
This can be set to one of the following:
* TRACE (the least serious)
* DEBUG
* INFO
* WARN
* ERROR
* FATAL (the most serious)

## Log4j2
### What is Log4j2?
Log4j2 is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. Log4j is a popular logging package written in Java. Log4j has been ported to the C, C++, C#, and Perl, Python, Ruby, and Eiffel languages.

Enable the Log4j2 framework in a Java application as follows:

1.) Include the following Maven dependencies, which will provide jar files to the application:

**(Use the latest stable version. Make sure to use the same version for both dependencies.)**

* [LOG4J-SLF4J-IMPL](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl)
* [LOG4J-CORE](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core)

2.) Create a configuration file to control behavior of logging including levels, files and formatting. The following example rotates the log file through a sequence of 4 files, each capped at 1 KB.
```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="DEBUG">
	<Properties>
		<!-- Specifies what directory/pathway to create the new log files -->
		<Property name="log-path">C:/logs/</Property>
	</Properties>
	<Appenders>
		<!-- 		Creates a log file with the name my-example-year-month-day-logfileindex -->
		<RollingFile name="RollingFile" fileName="${log-path}/myexample.log"
			filePattern="${log-path}/myexample-%d{yyyy-MM-dd}-%i.log">
			<PatternLayout>
			<!-- Pattern defines how the logger will log information. This will log the day/month/year as well as the hour:minute:seconds:milliseconds
			%c{1} specifies how many decimals to log for the category.
			%m is used to output the application supplied message associated with the logging event
			%n outputs the platform dependent line separator character or characters.

			An example of this logging pattern would look similar to below:
			18/Aug/2017 12:28:40,829- LOG4J2Logger: Entering Main
			-->
				<pattern>%d{dd/MMM/yyyy HH:mm:ss,SSS}- %c{1}: %m%n</pattern>
			</PatternLayout>
			<Policies>
			<!-- Limits the size of the logging file to 1 KB. -->
				<SizeBasedTriggeringPolicy size="1 KB" />
			</Policies>
			<!-- Will create 4 logging files and proceed to 'rollover' using just those four files. -->
			<DefaultRolloverStrategy max="4" />
		</RollingFile>
	</Appenders>
	<Loggers>
		<!-- Sets the level of what messages are allowed to be logged to the log file -->
		<Logger name="root" level="debug" additivity="false">
			<appender-ref ref="RollingFile" level="debug" />
		</Logger>
		<Root level="debug" additivity="false">
			<AppenderRef ref="RollingFile" />
		</Root>
	</Loggers>
</Configuration>
```
**NOTE:** This file should live under the path: src/main/resources. This is important because the LOG4J2 logger looks for a configuration file here by default.

3.) Write logging messages using the SLF4J API

4.) Run the program as a Java Application

* [PatternLayout Documentation](https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html)
* [Configuration Documentation](https://logging.apache.org/log4j/2.0/manual/configuration.html)

## Logback
### What is Logback?
Logback is intended as a successor to the popular log4j project. It builds upon a decade of experience gained in designing industrial-strength logging systems. The resulting product, i.e. logback, is faster and has a smaller footprint than all existing logging systems, sometimes by a wide margin. Just as importantly, logback offers unique and rather useful features missing in other logging systems.

Enable the Logback framework in a Java application as follows:

1.) Include the following Maven dependencies, which will provide jar files to the application:

**(Use the latest stable version. Make sure to use the same version for both dependencies.)**

* [LOGBACK-CORE](https://mvnrepository.com/artifact/ch.qos.logback/logback-core)
* [LOGBACK-CLASSIC](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic)

2.) Create a configuration file to control behavior of logging including levels, files and formatting. The following example rotates the log file through a sequence of 30 days worth of files, each capped at 5MB.
```
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true">
    <appender name="consoleAppender" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <charset>UTF-8</charset>
			<!-- This pattern will configure how the logger will print to the console.
			Pattern defines how the logger will log information. This will log the year-month-day,
			hour, minute, second, milliseconds, the level of the log (TRACE, DEBUG, INFO, ETC.), the class, and the
			actual message.

			An example of what this pattern prints out is below:

			2017-08-18 13:17:32,298 191  [main] INFO  LOGBACKLogger - Entering Mai

			-->
            <Pattern>%d %-4relative [%thread] %-5level %logger{35} - %msg%n</Pattern>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
    	<!-- The file element is the pathway and file name where the logging file will be created. -->
        <file>/srv/logs/application.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover. Make sure the path matches the one in the file element or else
             the rollover logs are placed in the working directory. -->
            <fileNamePattern>/srv/logs/application_%d{yyyy-MM-dd}.%i.log</fileNamePattern>

            <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
            	<!-- Specifies how big the logging files can be. In this case it will be 5 MB. -->
                <maxFileSize>5MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
            <!-- keep 30 days' worth of history -->
            <maxHistory>30</maxHistory>
        </rollingPolicy>

        <encoder>
            <charset>UTF-8</charset>
            <!-- This is the pattern that will be displayed in the file. It is the exact same as what will be displayed
            in the log file. -->
            <pattern>%d %-4relative [%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="DEBUG">
    	<!-- This will configure what level of messages is allowed to be printed to the console and the log file. In this case
    	any log message that is debug or lower will be logged. -->
        <appender-ref ref="consoleAppender" />
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```
**NOTE:** This file should live under the path: src/main/resources. This is important because the Logback logger looks for a configuration file here by default.

3.) Write logging messages using the SLF4J API

4.) Run the program as a Java Application

[Configuration Documentation](https://logback.qos.ch/manual/configuration.html)

## java.util.logging
### What is java.util.logging?
A Java logging framework is a computer data logging package for the Java platform. Logging refers to the recording of activity. Logging is a common issue for development teams. Several frameworks ease and standardize the process of logging for the Java platform.

Enable the java.util.logging framework in a Java application as follows:

1.) Include the following Maven dependencies, which will provide jar files to the application:

**(Use the latest stable version. Do Not use the alpha versions. Make sure to use the same version as the SLF4J-API dependency.)**
* [SLF4J-JDK14](https://mvnrepository.com/artifact/org.slf4j/slf4j-jdk14)

2.) Create a configuration file to control behavior of logging including levels, files and formatting. The following example rotates the log file through a sequence of 4 files, each capped at 1KB.

```
handlers=java.util.logging.FileHandler, java.util.logging.ConsoleHandler
java.util.logging.ConsoleHandler.level=INFO
java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter

# Write logging messages that are INFO or below
java.util.logging.FileHandler.level=INFO

# Write to the file Log_File_(the generation number to distinguish rotated logs)
java.util.logging.FileHandler.pattern=C:/logs/Log_File_%g.log

# Write 1 KB before rotating this file
java.util.logging.FileHandler.limit=1000

# Number of rotating files to be used
java.util.logging.FileHandler.count=4
java.util.logging.FileHandler.formatter=java.util.logging.SimpleFormatter

.level=INFO
```
3.) In the Run Configuration under the VM Arguments add the following piece of code:
```
-Djava.util.logging.config.file=src/main/resources/logging.properties
```
This specifies where the logging.properties file lives so the java.util.logging logger knows what logging configuration file to use.

4.) Run the program as a Java Applicaiton

* [Configuration Documentation](http://tutorials.jenkov.com/java-logging/configuration.html)
* [Filehandler Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/logging/FileHandler.html)
