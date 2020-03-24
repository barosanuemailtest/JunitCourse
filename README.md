## Eclipse project setup

* Open Eclipse
* File/New Maven Project
* Create sample class - StringStuff.java
* Create new Junit test case - scr.test - new Junit test case
* Select JUnit 4, same package, select class under test
* Add JUnit 4 to project structure
* Observe project structure
* Run initial test
* Debug initial test
* observe call-stack - no main method

## Unit tests structure

* Typical test structure
* Test workflow annotations - @Before, @BeforeClass, @After, @AfterClass - renamed in JUnit 5
* Tests should be separated and independent
* Demonstration

## Test assertions

* basic assertions: true, equals, arrayEquals, expecting exceptions

## Practice project - basic tests and stubs

* Write 2 classes - User and Project class

![Overview](doc/4Files/ProjectClass.PNG)

![](doc/4Files/WPclass.PNG)

![](doc/4Files/UserClass.PNG)

* Generate constructor and accessors using Eclipse.
* Test driven development: write test first
* Advanced assertion: AssertThat
* Hamcrest matchers

![](doc/4Files/Hamcrest.PNG)


* Why is this test working?

![](doc/4Files/WorkingTest.PNG)

* correct test setUp:

![](doc/4Files/before.PNG)

* What should be tested?

![](doc/4Files/Useless.PNG)

## Mocks

* Why do we need mocks?

* Project setUp:

![](doc/5Files/DataBaseAcc.PNG)

* Now out test has an error
* We can fix it like this:

![](doc/5Files/UnitTestFix1.PNG)

* But what if we extend the interface?

![](doc/5Files/NoASollution.PNG)

### Solution: MOCKS

![](doc/5Files/MockInitialSetUp.PNG)

* Mock testing functionality: Verify

![](doc/5Files/firstVerify.PNG)

* Mock behavior: what is returned by the mock?

![](doc/5Files/WhatIsReturned.PNG)

* Mock behavior: when -> then return

![](doc/5Files/WhenReturn.PNG)

## Mocking project: HttpRequestBuilder

Write unit tests for this class:

![](doc/5Files/HttpRequestLoader.PNG)

* Inject mocks
* use when -> thenReturn
* asserts
* verify

### Further reading:
https://www.vogella.com/tutorials/Mockito/article.html
https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882
https://www.manning.com/books/test-driven