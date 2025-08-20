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

Recap:

JRE, JVM, Metaspace, stack, heap

Main Thread is started; for main thread a stack is created and main() method is pushed on the stack
once main() method is popped out, the main thread dies.
In single threaded application if main thread dies, Java application terminates.

local variables --> Stack [ life of method]
static variables --> metaspace [life of JRE]
instance variables --> heap [life of object]

Generalization and Specialization relationship --> inheritance --> extends
* java.lang.Object is the root class for all objects in Java
It's a single root hierarchy
* Java doesn't support multiple inheritance
* override: a class inherits a method, but need to redefine it

Rules for overriding:
1) method name has to be same
2) parameters has to be same
3) return type can be same or sub type
```
  class Account {
    public Account getAccount() {

    }
  }

  class SavingsAccount extends Account {
    @Override
    public SavingsAccount getAccount() { // valid

    }
  }
```
4) while overriding visibility can be same or we can enhance the visibility; can't weaken the visiblity
default or protected can be made public.


Day 2:

Realization relationship: Contract
a realization relationship is a relationship between two model elements, in which one model element (the client) realizes the behavior that the other model element (the supplier) specifies.

Tv specfies HDMI contract;
Set-top box / Camcorder / dVD player realizes the contract

In java like in real world we use interfaces to achive Realization relationship.

interfaces are like complete abstract class
```
    interface UserRepo {
        void register(User user); // public and abstract by default --> pure virtual fn
        User login(String username, String password); // public and abstract by default --> pure virtual fn
    }

    class UserRepoFileImpl implements UserRepo {
        ...

         public void register(User user) {
            ///
         }

         public User login(String username, String password) {
            ...
         }
    }

     class UserRepoDatabaseImpl implements UserRepo {
        ...

         public void register(User user) {
            ///
         }

         public User login(String username, String password) {
            ...
         }
    }
```

Why Program to interface?
1) DESIGN
```
  interface UserRepo {
        void register(User user); 
        User login(String username, String password); 
    }
```
Common module is developed which contains entiies, exceptions, interfaces and pushed to the Git.
Front end and backend developers can pull them and start working concurrently

2) IMPLEMENTATION
Both the ends like supplier and producer can start developing parallely
Example: UI developers might use Andriod or Web
Backend coders will start writing code to store in database

3) INTEGRATION
Integration of supplier and producer can be done without any issues because both the ends are programmed to contract.

4) TESTING
    testing can be done using mock 
5) LOOSE COUPLING

======================

Scenario 1: Code is getting changed in client; there could be many clients like web / mobile / tv / desktop...
Solution: Use a factory method; this factory is common to all clients; instead of changing in all clients we change in factory

Scenario 2: Code is getting changed in factory to switch between strategies instead of client.
Problem: Switching between straties code changes in factory which leads to again testing, bundling and redeploying on server...
Solution : use Configuration files like XML / properties / YAML files
Factory reads from config files and instantiates different objects.
Changes happens only in config files and not in java.

XML needs SAX or DOM Parser
YAML needs Jackson / Jettison libraries.

================

Different ways of creating an object:
1) if we know class name in advance new Mobile() --> prefer
2) if class name is dynamic, like comming from XML / properites file
Class.forName("java.util.Date"); // loads the class into METASPACE
Class.forName("com.adobe.prj.dao.MobileDaoDatabaseImpl") // loads the class
Class.forName("com.adobe.prj.dao.MobileDaoDatabaseImpl").getConstructor().newInstance(); // create object


```
    Create objects based on arguments.

    class PlantFactory {
        public static Plant[] getPlants(String season) {
            switch(season) {
                case "SUMMER":
                case "WINTER":
                case "RAINY":
                default:

            }
        }
    }

    Plant[] plants = PlantFactory.getPlants("SUMMER");
```

Generic Type: class , method, interface.

```
TypeWrapper classes: Integer, Short, Byte, Double, Float, Long

Generics works only with objects and not primitive types
 
Without Generics:
public class IRectangle {
    private int width;
    private int height;

}

public class DRectangle {
    private double width;
    private double height;

}


public class Rectangle <T> {
    private T width;
    private T height;

    // Constructor
    public Rectangle(T width, T height) {
        this.width = width;
        this.height = height;
    }

..

Rectangle<Integer> r1 = new Rectangle<>(10, 5);
Rectangle<Double> r2 = new Rectangle<>(10.5, 7.2);
Rectangle<String> r3 = new Rectangle<>("A", "B"); // valid


public class Rectangle<T extends Number> {
    private T width;
    private T height;
    ...

Rectangle<Integer> r1 = new Rectangle<>(10, 5);
Rectangle<Double> r2 = new Rectangle<>(10.5, 7.2);
Rectangle<String> r3 = new Rectangle<>("A", "B"); // invalid   


int x = 100;
Integer iX = x; // boxing or wrapping

int y = iX; // unboxing
```

Java Collection Framework: provides data containers
1) interfaces
2) implementation classes
3) algorithm / utility classes

Array is a data container, has to be the first choice as data container
Limitations:
1) size is fixed, can't grow nor shrink
2) adding or removing in arbitrary position is not efficient
3) needs contiguous memory location


Comparable vs Comparator
* both are for comparison
* Comparable: comparison logic is a part of object itself on which comparision has happen; example like in Product, String has compareTo() methods
For String comparison is based on lexical based
* Comparator: comparision logic is a part of client and not object; client might need different way of comparison
Client needs to compare string based on length

Example: File Object of OS can display files in a particular order, uses Comparable

Finder is a client for file system which allows me to compare the same files ordered by date / kind / size / name

Arrays and Collections classes are utility / algorithm classes which contain methods like sort(), max(), min(), binarySearch(), ... which works on contract like Comparable / Comparator

Arrays works on array data container
Collections works on List type of data container


Without Generics:
````
public class Product implements Comparable {
@Override
    public int compareTo(Object o) {
        Product p = (Product) o;
        return 0;
    }
```

With Generics:

```
public class Product implements Comparable<Product>{
    @Override
    public int compareTo(Product o) {
        return 0;
    }

```

Lambda expression are for Functional interface.
Functional interface is one which has only one method to implement.


List vs Set
List:
1) data container which supports duplicate elements
2) ordered
3) re-ordered [sort / reverse / shuffle]
4) supports index based operations [ get(5), add("", 4), remove(1)]

Implementation classes: Vector(legacy), ArrayList, LinkedList, Apache Collections, Vavr collections

```
ArrayList:
Uses a dynamic array internally to store elements. When the array reaches its capacity, a new, larger array is created, and elements are copied over.
LinkedList:
Uses a doubly linked list structure. Each element (node) stores the data and references to the next and previous nodes in the list.
2. Performance Characteristics:
Random Access (getting an element by index):
ArrayList: Provides O(1) constant-time access due to direct array indexing.
LinkedList: Offers O(n) linear-time access because it requires traversing the list from the beginning or end to reach a specific index.
Insertions and Deletions (in the middle of the list):
ArrayList: Involves shifting elements to make space for insertions or to close gaps after deletions, leading to O(n) linear-time complexity.
LinkedList: More efficient for insertions and deletions at any position (O(1) if you have a reference to the node, otherwise O(n) due to traversal) as it only requires updating a few pointers.

ArrayList list = new ArrayList(); // avoid this, not typesafe
list.add("A");
list.add(33);
list.add(new Date());

if(list.get(0) instanceof String) {
    String s = (String) list.get(0);
}

ArrayList<Integer> list = new ArrayList<>(); // typesafe
list.add("A"); // not supported
list.add(33); // supports

int x = list.get(0); // no need to do type checking
```

Set:
1) unique collection
2) not ordered, position of insertion depends on different algorithm/logic
3) can't re-order nor supports index operations

=================================
https://rxmarbles.com/

High Order Functions: 
1) functions which accept function as argument
2) function which returns a function
Simple: treat function as first class member like primitive or object

Commonly used HOF:
1) filter [ to get subset] function takes a predicate function as argument
2) map [ to transform data] function takes a transformFn
3) forEach [ iterate] function takes a actionFn
4) reduce [ aggregate like sum(), count(), avg()]

Java 8 Streams provide a powerful and functional approach to processing sequences of elements, such as those found in collections (Lists, Sets, etc.) and arrays.
Streams support various functional operations like filter (to select elements based on a condition), map (to transform elements), reduce (to combine elements into a single result), forEach (to iterate and perform an action on each element), and sorted (to sort elements).

Intermediary functions: filter, map, limit, skip
Terminal functions: collect, forEach, reduce

stream -> skip(10) -> filter() -> map() -> collect()
stream -> limt(100) -> map() -> filter() -> forEach()
stream -> filter() -> map() -> reduce()


Set --> HashSet and TreeSet implementations
TreeSet is rearly used [ RedBlack Tree]

HashCode
1) a hash code is an integer value generated for an object, 
used primarily in data structures which are  hash based for efficient storage and retrieval
2) If two objects are equal according to the equals() method, their hashCode() values must be equal. 
However, the reverse is not necessarily true: unequal objects can have the same hash code (a collision)

Bad HashCode Example:
```
    public class Rectangle {
        int width;
        int breadth;

        public int hashCode() {
            retur width * breadth;
        }
    }

    Rectangle r1 = new Rectangle(4,5); // hascode = 20
    Rectangle r2 = new Rectangle(5,4); // hascode = 20
    Rectangle r3 = new Rectangle(10,2); // hascode = 20
    Rectangle r4 = new Rectangle(20,1); // hascode = 20
    Rectangle r5 = new Rectangle(2,10); // hascode = 20
    Rectangle r6 = new Rectangle(1,20); // hascode = 20
 
 Good hashCode:
 @Override
    public int hashCode() {
        int result = 17; // Initial prime number
        result = 31 * result + width.hashCode();
        result = 31 * result + Integer.hashCode(breadth); // For primitive int
        // ... and so on for other fields
        return result;
    }

```

HashSet, HashMap uses hashCode() and equals() method for finding duplicates and positioning of element in container

if hashCode() collides then only call equals() to check if its duplicate or not.

========

Map :
A map data structure, also known as a dictionary, associative array
Key-Value Pairs: Data is organized as pairs, where a unique key maps to a specific value.
Unique Keys: Each key within a map must be unique, ensuring that each value can be unambiguously accessed.

Task:
1) Patient entity with id, name and age
2) create PriorityQueue implementation of Queue interface to give priority to senior citizens

Queue --> FIFO

====================

Recap:
1) Realization relationship using interface and implements
a class can realize multiple interfaces / contract
2) Anonymous class

```
interface Flyable {
    fly();
}
class Bird implements Flyable {
    name;
    age;
    colour;
    // behaviour
    public void fly() {
        // 
    }
} 

class AeroPlane implements Flyable {
    name
    capacity
    make
    // behaviour
    public void fly() {
        //
    }
}

Flyable f = new Flyable() {
    public void fly() {
        //
    }
}
```

3) Lambda expression: if the interface is Functional interface [ interface with only one method to define] we can use lamba [arrow function] instead of anonymous class

Flyable f = () -> {}

4) Comparable vs Comparator
5) List, Set, Arrays and Collections
6) Stream and HOF like filter, map, reduce, collect, forEach


=================

Day 3:

Introduction to Exception Handling:
Any abnormal condition that arises during program execution is an exception.
A) Error type of exception: abnormal condition that can't be rectified during program execution
Examples: StackOverflowError [ issue with bad recursive code without exit condition]
java -Xss:64kb MyCode
OutOfMemoryError: no space in Metaspace [ too many classes are loaded into the JVM]; too many objects in heap area

B) Exception type of exception: abnormal condition which can be handled in application [ as in can provide an alternate flow]
Exception type of exception can be classified as:
1) Checked Type of exception
should be handled using try / catch / finally block
Compiler enforces you to handle it
Generally these exceptions are triggred from outside of JRE

```
    try {
         FileInputStream fis = new FileInputStream("a.txt");  // OS might thro exception if file is not present
        ...
    } catch(FileNotFoundException ex) {
        ..
    }

    try {
        Connection con = DriverManager.getConnection(URL, USER, PWD); // Database might throw exception

    } catch(SQLException ex) {
        ...
    }
```
2) Unchecked type of exception
    should be handled using conditional statement; Compiler will not enforce you to have handling mechanism
    All Unchecked exceptions happens because of a reason within JRE
    ```
        public void addProduct(Product p) {
            if(p != null) { // NullPointerException is avoided
                save product in database...
            }
        }

        int[] data = {5,55,11};
        int index = 4;
        if(index >= 0 and index < data.length) { // ArrayIndexOutOfBoundsException is avoided
            System.out.println(data[index]); 
        }
    ```

=========================

JDBC: Java Database Connectivity -> Integration Library to connect to RDBMS

Java Application <----> JDBC <----> RDBMS

Java provides a set of interfaces for JDBC; implementation classes are provided by database vendors

Steps involved in using JDBC:
1) Load database implmentation classes into JVM Class.forName(...)
2) Establish a database connection
```
    Connection is a interface provided by JDBC
    getConnection() is a factory Method, based on URL it creates OracleConnection / PostgresConnection / MySQLConnection
    Oracle URL: jdbc:oracle:thin:@192.22.134.13:1521:emp_db
    MySQL URL: jdbc:mysql://192.34.14.14:3306/emp_db

    java.sql.Connection con = DriverManager.getConnection(URL, USER, PWD);

```

3) Send SQL statements for DML [ INSERT / DELETE / UPDATE / SELECT]
3.1) Statement
if SQL is same for n requests
select * from products
3.2) PreparedStatement
if SQL takes IN parameters
select * from accounts where acc_no = ?
insert into users values (?, ?, ?, ?);

Automatically handles the escaping of special characters in input parameters, preventing malicious SQL injection attacks. 

https://owasp.org/Top10/A03_2021-Injection/
Don't concat SQL instead use PreparedStatement
 http://example.com/app/accountView?id='100 OR 1 = 1' --
 String query = "SELECT \* FROM accounts WHERE custID='" + request.getParameter("id") + "'";

ResultSet executeQuery(SELECT)
int executeUpdate( INSERT / DELETE / UPDATE)


3.3) CallableStatement



4) ResultSet

=============================

Maven /Gradle
Maven and Gradle are both popular build automation tools primarily used for Java projects, though they support other languages as well. 
They aim to automate the process of building, testing, and deploying software, as well as managing project dependencies.

pom.xml --> Project Object Model a file where goals for build / test / package and depenency entries are configured

pom.xml will be pushed to Git / Repo where all team members uses the same pom.xml and download dependencies

Local Repository:
/Users/banuprakash/.m2

```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.38</version>
</dependency>
```

Docker is an open source platform that enables developers to build, deploy, run, update and manage containerized applications.
Softwares are available as images in docker hub.
Docker Container --> running application.


```

mysql> create database NCG_JAVA;

mysql> use NCG_JAVA;

mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name varchar(100), price double);


mysql> insert into products values (0, 'iPhone 16', 89000.00);


mysql> insert into products values (0, 'Wacom', 5000.00);


mysql> select * from products;
+----+-----------+-------+
| id | name      | price |
+----+-----------+-------+
|  1 | iPhone 16 | 89000 |
|  2 | Wacom     |  5000 |
+----+-----------+-------+


```

JEE: Java Enterprise Edition

Java Enterprise Edition (Java EE), now known as Jakarta EE, is a set of specifications that extends Java Standard Edition (Java SE) to provide a platform for developing and deploying large-scale, multi-tiered, and secure enterprise applications. It is designed for use in distributed environments and handles features like web services, distributed computing, and database management.

Web based application
Tomcat / Jetty / Netty are Servlet engines / Containers to serve dynamic content written in Java

request and response objects are created for every client requests:
request: encapsulates all data coming from client; like form data; query params; browser; OS
response: used to write data back to client

Once response is commited to the client; request and response objects are destroyed; thread is released back to the pool

How does the Servlet container / engine know which Servlet to inoke for a given URL?
ANS: metadata in the form of XML [web.xml] or annotation

Servlet is an interface
GenericServlet implements Servlet interface
HttpServlet extends GenericServlet

Any Servlet we write should extend from HttpServlet and provide methods to handle HTTP methods [ GET / POST / PUT / DELETE / PATCH...]

GET: method of request when client makes a request from Address Bar / HYPERLINK; to fetch data; no payload
POST: method of request for sending payload/data from client to be inserted in server side


```
database
  |
   HTML /CSS / JS  
  |
  WEB-INF
    web.xml
   classes
     |
     LoginServlet.class
     RegisterServlet.class
     ProductServlet.class

mvn clean
mvn compile
mvn package --> creates war file

mvn jetty:run
    starts jetty server in default port 8080 using embedded plugin
    triggers war plugin --> trigger compiler plugin
    war is deployed on jetty

http://localhost:8080/products

    name : ...
    price: ...


```
In java class /interface /annotation / enum / record types

Annotation:
Metadata --> data about data.

1) Who uses it?
a) COMPILER
b) CLASSLOADER
c) RUNTIME [JRE]

2) Where can I use it?
a) METHOD [@Override]
b) CLASS [@WebServlet]
c) FIELD
d) PARAMETERS

COMPILER USED Annotation:
Source --> Compiler uses annotation --> bytecode [wont have annotation]

RUNTIME used Annotation:
Annotations will be present in JRE and used at runtime [@WebServlet]


CLASSLOADER used annotation: [made up]
@Mobile(make="Samsung")
public class CandyCrush extends Game {

}

Source --> Compiler --> bytecode [ has annotation]
bytecode --> classloader --> metaspace [ annotation is removed]

Samsung Team will write there own classloaders;
Cisco also writes there own classloaders [ Webx Cam, Hathway ]

=============

We as developers can easily write annotations to be used @ RUNTIME

ORM simulation using annotation;
we map class to table
fields to columns
generate DDL and DML statements

```
    @Table(name="books")
    public class Book {
        @Column(name="BID", type="NUMERIC(12,2)")
        int id;

        @Column(name="TITLE")
        String name;
    }

CREATE table books (BID NUMERIC(12,2) TITLE VARCHAR(200));
INSERT into books ...


```