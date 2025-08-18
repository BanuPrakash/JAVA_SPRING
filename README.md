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







