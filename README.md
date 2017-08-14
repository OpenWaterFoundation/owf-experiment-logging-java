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

The repository contains an Eclipse project that will contain four different main java files. These files
correspond to the four different frameworks that can be used with SLF4J (Simple Logging Facade for Java).

Within this readme will be four different sections explaining how to properly run each java class and the necessary steps to setup these projects.

## SLF4J

### What is SLF4j?
Simple Logging Facade for Java (SLF4J) provides a Java logging API by means of a simple facade pattern. The underlying logging backend is determined at runtime by adding the desired binding to the classpath and may be the standard Sun Java logging package java.util.logging, log4j, logback or tinylog. The separation of the client API from the logging backend reduces the coupling between an application and any particular logging framework. This can make it easier to integrate with existing or third-party code or to deliver code into other projects that have already made a choice of logging backend.

## Log4j2
### What is Log4j2?
Log4j2 is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. Log4j is a popular logging package written in Java. Log4j has been ported to the C, C++, C#, and Perl, Python, Ruby, and Eiffel languages.

## Logback
### What is Logback?
Logback is intended as a successor to the popular log4j project. It builds upon a decade of experience gained in designing industrial-strength logging systems. The resulting product, i.e. logback, is faster and has a smaller footprint than all existing logging systems, sometimes by a wide margin. Just as importantly, logback offers unique and rather useful features missing in other logging systems.

## java.util.logging
What is java.util.logging?
A Java logging framework is a computer data logging package for the Java platform. Logging refers to the recording of activity. Logging is a common issue for development teams. Several frameworks ease and standardize the process of logging for the Java platform.
