# REST API Test Project

Using Rest-assured and TestNG
---
In this project, you can find how to automate REST APIs using Rest-Assured library and TestNG. Rest Assured is a Java library that we can test 
and validate the REST web services. Rest-assured provides its own validating mechanism(assertions for validating response). TestNG is used for clear 
test results, it is supported by a variety of tools and plug-ins (Eclipse, IDEA, Maven, etc...).

There are three test scenarios in the project:
---
1. Control Turkey's information from Region service:

*Verify that "nativeName" value is "Türkçe".

*Verify that "name" value is "Turkish".

*Verify that "iso639_2" value is String.

2. Control Ankara's information from Capital City service:

*Verify that "region" value is "Asia".

*Verify that "borders" list's length is 8.

3. After getting Ankara's information from Capital City service fetch "AZE" value from "border" list. Control Name service information by fetching this "AZE" value:

*Verify that "name" value is "Azerbaijan".

*Verify that "capital" value is "Baku".

*Verify that "IRN" and "TUR" values exist in "border" list.

Environment Preparation
---
Belows will be used:

*RestCountries API (http://restcountries.eu)

*Rest-Assured and its dependencies (https://code.google.com/p/rest-assured/wiki/Downloads)

*TestNG as testing framework

## Installation and Configuration steps

1-Install latest Java JDK from Oracle site. (Tests were run on java version "9.0.1" 64 bit installed PC.)

2-Install latest version of Eclipse. (Tests were run on eclipse Oxygen 64 bit installed PC.)

3-Download project from Project Download link below to a folder in your PC.

4-Open Eclipse IDE-->New-->Project-->type "maven"-->choose "Maven Project"-->click Next-->choose Workspace location which you download from GitHub-->Next

5-Click Help in Eclipse-->Eclipse Marketplace-->type "testng" to find-->click Magnifier to find-->install "TestNG for Eclipse"

6-If everythings are correct you should not see any error and ready to run tests.

How to run tests
---

There are seperate classes under 1>src/main/java-->region for three scenarios: 

scenario 1: RegionTurkey class

scenario 2: CapitalAnkara class

scenario 3: CapitalNameAze class

*for all test scenarios Open related test class-->right click in class-->Run As-->TestNG Test

*After run a test you can see test result under Console. For RegionTurkey test result is like below:

PASSED: iso

PASSED: nameTurkish

PASSED: nativeNameTurkce

Note: RegionTurkey and CapitalAnkara test classes have seperate tests for every steps. However, CapitalNameAze test class has one one test
,and also test result, for its three steps.
 
Project source can be downloaded from https://github.com/selahattingarip/eucountriesTest.git
---

Author & Contributor List
-----------
Selahattin Garip

Keywords
-----------
Rest Api, Rest Assured, TestNG, Maven, Json, Test Automation

Links
-----------
https://mvnrepository.com/artifact/org.testng/testng/6.14.3 (TestNG » 6.14.3 )

https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2018-09/R/eclipse-inst-win64.exe

https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

https://restcountries.eu

https://artoftesting.com/automationTesting/restAPIAutomationGetRequest.html

https://github.com/rest-assured/rest-assured
