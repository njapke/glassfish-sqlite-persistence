# How to configure Glassfish to use an SQLite database

## Prerequisites
* Java SE JDK 8 ([Link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* Eclipse Neon for Java EE Developers ([Link](https://www.eclipse.org/downloads/eclipse-packages/))
* Glassfish 4 Full ([Link](https://javaee.github.io/glassfish/download))
* SQLite 3 ([Link](https://www.sqlite.org/download.html))
* SQLite JDBC ([Link](https://bitbucket.org/xerial/sqlite-jdbc/downloads/))
* SQLiteConnectionPoolDataResource ([Link](https://sourceforge.net/projects/sqlite-connpool/files/))

Download all programs to a safe location and setup Glassfish to be usable in Eclipse (using Glassfish Tools from the Eclipse Marketplace) and SQLite to be accessible via command-line.

## Setting up an SQLite database
Open SQLite3 inside the command-line. Then type `.save mydatabase.db` to save the (currently empty) in-memory database to a file called `mydatabase.db`. This file will be used by Glassfish and can be inspected using SQLites command-line utility.

## Setting up the SQLite JDBC driver in Glassfish
* Copy `sqlite-connection-pool_v1.2.0.jar` and `sqlite-jdbc-3.18.0.jar` into `[path to glassfish]/glassfish4/glassfish/lib`.
* Start Glassfish (e.g. inside Eclipse) and open `http://localhost:4848/` (Glassfishs admin page) inside your browser.
* Navigate to `Resources > JDBC > JDBC Connection Pools` and click `New`.
* Enter:
    * Pool Name: `SQLite`
    * Resource Type: `javax.sql.ConnectionPoolDataSource`
    * Datbase Driver Vendor (below the drop-down menu): `SQLiteJDBC`
    * Click `Next`
* Enter:
    * Datasource Classname (below the drop-down menu): `org.sqlite.SQLiteConnectionPoolDataSource`
    * Click `Finish`
* Click on the newly created SQLite connection pool and navigate to `Additional Properties` (above the page).
* Click `Add Property` and enter:
    * Name: `url`
    * Value: `jdbc:sqlite:[path to your database file]/mydatabase.db`
    * Click `Save`
    * !Caution! On windows, the path has to include the drive letter and must use forward slashes instead of backslashes.
* Now navigate to `Resources > JDBC > JDBC Resources` and click `New`.
* Enter:
    * JNDI Name: `jdbc/SQLite`
    * Pool Name: `SQLite`
    * Click `OK`
* Now you are done and can proceed to use the database in a project.

## Create a project using the SQLite database

