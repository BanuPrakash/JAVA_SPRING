# JAVA_SPRING

```
Banu Prakash C
Full Stack Architect, Corporate Trainer
Co-founder & CTO: Lucida Technologies Pvt Ltd.,
Email: banuprakashc@yahoo.co.in
banuprakash.cr@gmail.com
https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/JAVA_SPRING

```

Softwares Required:

```
1) openJDK 21 https://jdk.java.net/java-se-ri/21
Option 1: install and add path and JAVA_HOME
vi ~/.zshrc export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21
export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH

Option 2: [better]
USE SDKMAN to manage java
curl -s "https://get.sdkman.io" | bash
sdk install java 21.0.6-tem
sdk default java 21.0.6-tem

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.

$ java --version

2) IntelliJ Ultimate or Community edition https://www.jetbrains.com/idea/download/?section=mac

3) MySQL [ Prefer on Docker]
Install Docker Desktop
Docker steps:
a) docker pull mysql
b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql
container name given here is "local-mysql"
For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

c) CONNECT TO A MYSQL RUNNING CONTAINER:
$ docker exec -t -i local-mysql bash

d) Run MySQL client:
bash terminal> mysql -u "root" -p
mysql> exit

```

TOC:
1) Java - 2 days
2) Intro to Maven, JDBC, and Web application JEE
3) Spring Boot with JPA

OOP: Object Oriented Paradigm
Write programs which resemble real-world.
Object: state and behaviour/ actions / messages

AC : state -> temp and fan speed
Bulb: state on/off

By sending a message state of object changes.
What messages an object can take is exposed thro its interface [Remote]
Abstraction

Banking Account:
state: balance [variable] / accountNumber [constant]
behaviour: credit() / debit() / interest()

Template to create an Object:
* class -> C++ / C# / Java / TypeScript
```
    class Account {

    }
``
* function -> JavaScript
```
    function Account() {

    }
``
* Type -> Oracle

```
    Type Account

    End Type
```

SOLID Design Principles

```
Single Responsibilty: Object should have a single responsibility or task.
When a class has a single responsibility, it's easier to understand, modify, and test.

OCP: Close for Change, Open for Extesnsion: emphasizes software entities (classes, modules, functions, etc.) should be open for extension but closed for modification

Liskov Substitution Principle: emphasizes the importance of substitutability in class hierarchies. 
It states that objects of a superclass should be replaceable with objects of its subclasses without altering the correctness of the program.
Example: Account can be replaced by SavingsAccount / CurrentAccount or LoanAccount to get functionalities of Account.

Interface segregation:
TV: HDMI [ by devices like Settop box / Laptop] / POWER [UPS]/ Remote [Human]

Dependency Injection: providing objects with their dependencies from an external source rather than having them create those dependencies themselves
Tv depends on HDMI: HDMI is injected
Tv depends on Power: Power is injected

```

What is Java?
Java is a technology where it provides a platform to execute bytecode.

Programming languages like Java / Kotlin / Groovy can be used to write code and compile to bytecode.

JDK: Java Development kit
KDK: Kotlin Dev Kit

Source code --> compiler [javac] --> bytecode.

Bytecode is platform independent / architecture neutral

Account.java
```
 public class Account {
    private double balance; // state
    public void deposit(double amt) {
        this.balance += amt;
    }
    public double getBalance() {
        return this.balance;
    }
 }
```
javac Account.java --> Account.class --> bytecode

AccountClient.java

```
    public class AccountClient {
        public static void main(String[] args) {
            Account rahulAcc = new Account();
            Account swethaAcc = new Account();

            rahulAcc.deposit(4500.00);
            swethaAcc.deposit(9000.00);

            System.out.println(rahulAcc.getBalance());
        }
    }
```
javac AccountClient.java --> AccountClient.class --> bytecode

1) Compile Time Environment: Source code to bytecode
2) Runtime environment on target machine: same machine / mobile / tv / server
CLASSPATH is environment variable to specify where are my bytecodes residing

To start RTE: java AccountClient
context.behavior(parameters);

===============

Logically grouping of objects / classes in enterprise application
1) Entity / Model / Domain classes
they represent business entity like for Uber taxi:
Customer, Driver, Vehicle, Trip, PaymentDetails
They survive the system crash, generelly they have persistence in database / files,..

Ecommerce: Customer, Product, Supplier, Order, lineItems, ...

2) DAO / Repository classes
they contain CRUD operations ; INSERT, DELETE, MODIFY and FETCHING operations from persist store like MongoDB , RDBMS, file

3) Business classes: business logic
4) Utility classes: Helper classes like sorting / Date format handling, i18N
5) Service classes : facade over DAO and business tier code/logic. Generally they are used to create atomic operations involving many DAO and business logic.
```
    Client selects Beneficiary and amount to transfer from UI
    calls BankingService --> which internally has many fine grained operations

    class BankingService {
        // atomic operations; commit or rollback
        public void transferFunds(Account fromAcc, Account toAcc, double amt) {
            withdraw from fromAcc ; update
            deposit to toAcc ; update
            insert into transaction table; insert
            send SMS
            send Email
        }
     }
```

6) Client / UI specific classes: web / desktop / mobile

packages: in java are for logical grouping of objects/classes
one folder per package

```
    com
      |
      adobe
        |
        aem (prj/module)
          |
          entity
            |
             Customer.class [ mapped to Customer table / document]
             Product.class
             Order.class
          repo [per table]
            |
            CustomerDao.class [ CRUD for Customer table]
            ProductDao.class [ Crud for Product  table]
            OrderDao.class
         service
            |
            AdminService.class [for Actor Admin]
            CustomerService.class [ for Customer actor]

```

constructors, instance variables, instance methods, static var, static methods.

=======================

Relationship between objects/class
1) Generalization and Specialization
2) Realization
3) Association
4) Uses A

===============
* Java Build tools:
1) Checkstyle and PMD / Findbugs
Checkstyle is a static code analysis tool primarily used for Java programming. Its main purpose is to help developers ensure that their Java source code adheres to a predefined set of coding conventions.
FindBugs is a defect detection tool for Java that uses static analysis to look for more than 200 bug patterns.
PMD is a static code analyzer, most commonly referring to the open-source tool, which can be used to find common programming flaws, potential bugs, and code inefficiencies in various programming languages

2) Sonar 
3) Maven / Gradle
clean / Compile / package / deploy

4) Jenkins
CI / CD Pipeline


Generalization and Specialization: IS A relationship; In Java java.lang.Object is the base class / root for every object. Single root hierarchy
Keyword "extends" is used for specialization [ inheritance]

Code Reusability choose between IS A / HAS A / USES A

========================

1) How Constructors work in inheritance
2) Memory allocated
3) How methods are executed.
    Dynamic Binding / Polymorphism -> Runtime binding
    static binding is only for static methods in Java

    All instance methods in Java are Virtual by default
==============


```
Product p = new Mobile();

p instanceof Mobile ==> true

p instanceof Product ==> true

p instanceof Object ==> true

p instanceof Tv ==> false

p.getClass() == Mobile.class ==> true
p.getClass() == Object.class ==> false
p.getClass() == Product.class ==> false

```

Java Bean naming conventions are getters for accessor and setters for mutation

If we know the method in advance:
context.method(); like p.getPrice(); // works

=========

keyword "abstract"

```

abstract classes --> incomplete class, can't instantiate; such objects doesn't exist in real world
abstract classes are just meant for generalization purpose
pushing common state and behaviour to the abstract class.


I need to buy a Product. 
Sales Guy ask what type / reason

I need to open an Banking account?
Manager: Savings / Current / ...

abstract methods --> incomplete methods; enforce all inherited classes to compulsorily implement them

```

keyword "final"

1) to declare a constant

private final static double PI = 3.14159;

prefer constants to be static also ; only one copy is created

2) prevent override

```
    public class Product {

        public final String getName() {
            ...
        }
    }

    public class Tv extends Product {
        ..

          public  String getName() { // fails. Can't override final methods
            ...
        }
    }

```

3) prevent inheritance

```
public final class Tv extends Product {

}

public class SmartTv extends Tv {} // fails

```

4) constant pointer

```
    Product p = new Mobile(...);

    p = new Tv(..); // fails

    final int[] data = {62,111,45};

    data[0] = 11; // valid

    data = new int[4]; // fails

```

Task:

```
  class Time {
    private int hours;
    private int min;
    ///
  }


 class TimeClient {
    main() {
        Time t1 = new Time(4,30);
        Time t2 = new Time(3, 45);

        Time t3 = Time.add(t1, t2);

        s.o.p(t3.getHours() + " : " + t3.getMin()); // 8: 15
        s.o.p(t1.getHours() + " : " + t1.getMin()); // 4: 30
        s.o.p(t2.getHours() + " : " + t2.getMin()); // 3: 45

        Time t4 = t1.add(t2);
        s.o.p(t4.getHours() + " : " + t4.getMin()); // 8: 15
        s.o.p(t1.getHours() + " : " + t1.getMin()); // 4: 30
        s.o.p(t2.getHours() + " : " + t2.getMin()); // 3: 45
    }
 }
```
