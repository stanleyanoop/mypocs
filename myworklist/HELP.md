# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.4/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.4/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Pre-requisites

#### DB startup

The DB startup is required for the web services  to work fine, as the data persistence is managed through the DB.
In order to start the DB, execute the rundb script at the root of the repository.

If needed, please ensure to set the environment "DB_HOME" to the local sql server home where the DB server scripts are located
prior to the invocation of the rundb.sh script on the same terminal.

##### To start the SQL Tool CLI - HSQLDB

Please execute the below command to run the CLI

`cd /Users/anoopstanley/hsqldb-2.7.4/hsqldb/lib && java -cp sqltool.jar org.hsqldb.cmdline.SqlTool`

Once the SQL CLI pops up, execute the below command:
```
wluser adm1n jdbc:hsqldb://localhost:9001
CONNECT worklistdb
```

##### To start the SQL Tool CLI - MySQL

Please execute the below command to run the CLI
```
/usr/local/mysql/bin/mysql -u wluser -p
```
When prompted, use the password "wlAdm1n"

#### Starting the server

Please execute the mvn command to start the web server
`mvn spring-boot:run`
