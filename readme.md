

## Overview and Requirements
* Java 8
* Maven

Maven Surefire is being used to manage configuration and test runs. You may run the tests from the base directory by 
running...

`mvn clean install test -Dtmdb.apiKey="<<api_key>>"`

While this project has been created in IntelliJ, I did not check-in any shared configurations. If you attempt to run
from IntelliJ you will get exceptions. Provide your API key via a TestNG run configuration to fix this.

### Summary 
There are Java docs, and also block comments throughout the code. Java Docs are written like I would typically write
java docs. The Block comments are commentary specifically related to this assignment for you.

#### Design Notes
* Library vs Implementation

    There are multiple instances here, both simple and complex, where I have implemented something I would typically 
    default to a library for. I did this so that the assignment was more than including a few libraries and writing
    tests using those libraries. 
    
    In particular, my implementation of the network calls is really limited, and would be pretty nasty to extend. I 
    would not hesitate to use a framework.

##### Misc. Tidbits
* 120 character line limit is imposed, if you see strange line breaks, that is why :smiley:
* Test naming convention is based UnitOfWork_StateUnderTest_ExpectedBehavior via
 [Roy Osherove](http://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html) 
* AAA is followed for test design
* I created two Model objects, and then used a generator to create the rest of the POJOs.
* I did not include any annotations which provide a translation of the naming convention of the API to Java. My variable
names match the API, but generally I think the language should define the naming convention.

###### Thank you! 