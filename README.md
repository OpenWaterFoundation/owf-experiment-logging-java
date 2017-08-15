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

1.) Under the [pom.xml](https://github.com/OpenWaterFoundation/owf-experiment-logging-java/blob/master/SLF4J-Logging/pom.xml) file, uncomment the section that reads binding for System.out using SLf4J. This will then allow the java class to print the logging information to the console. If any of the other dependencies were uncommented, comment them back out before running the java class.

## Log4j2
### What is Log4j2?
Log4j2 is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. Log4j is a popular logging package written in Java. Log4j has been ported to the C, C++, C#, and Perl, Python, Ruby, and Eiffel languages.

1.) Under the [pom.xml](https://github.com/OpenWaterFoundation/owf-experiment-logging-java/blob/master/SLF4J-Logging/pom.xml) file, uncomment the section that reads binding for Log4J2. Make sure that the log4j2.xml file is under the src/main/resources folder. If any of the other dependencies were uncommented, comment them back out before running the java class.

[Configuration Documentation](https://logging.apache.org/log4j/2.0/manual/configuration.html)

## Logback
### What is Logback?
Logback is intended as a successor to the popular log4j project. It builds upon a decade of experience gained in designing industrial-strength logging systems. The resulting product, i.e. logback, is faster and has a smaller footprint than all existing logging systems, sometimes by a wide margin. Just as importantly, logback offers unique and rather useful features missing in other logging systems.

1.) Under the [pom.xml](https://github.com/OpenWaterFoundation/owf-experiment-logging-java/blob/master/SLF4J-Logging/pom.xml) file, uncomment the section that reads binding for logback. Make sure that the logback.xml file is under the src/main/resources folder. If any of the other dependencies were uncommented, comment them back out before running the java class.

[Configuration Documentation](https://logback.qos.ch/manual/configuration.html)

## java.util.logging
### What is java.util.logging?
A Java logging framework is a computer data logging package for the Java platform. Logging refers to the recording of activity. Logging is a common issue for development teams. Several frameworks ease and standardize the process of logging for the Java platform.

1.) Under the [pom.xml](https://github.com/OpenWaterFoundation/owf-experiment-logging-java/blob/master/SLF4J-Logging/pom.xml) file, uncomment the section that reads binding for JDK14 (java.util.logging). Make sure that the logging.properties file is under the src/main/resources folder.

2.) Then in the run configuration options make sure to add the following code in the VM arguments section, select apply and then run. If any of the other dependencies were uncommented, comment them back out before running the java class.

-Djava.util.logging.config.file=src/main/resources/logging.properties

[Configuration Documentation](http://tutorials.jenkov.com/java-logging/configuration.html)
[Filehandler Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/logging/FileHandler.html)
