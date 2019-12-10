# TasksSpringBoot
A Java API for creating, getting and deleting tasks with SpringBoot, JPA, PostgreSQL, and Hibernate.

## Setup Steps

### Setup PostgreSQL
##### 1. Install PostgreSQL with Brew.
```
brew install postgresql
```

##### 2. Run the following command...
```$xslt
ln -sfv /usr/local/opt/postgresql/*.plist ~/Library/LaunchAgents
```

##### 3. Add the following alias's.
```
alias psql-start="brew services start postgresql"
alias psql-stop="brew services stop postgresql"
alias psql-restart="brew services restart postgresql"
```

##### 4. Connect to your psql session.
```$xslt
psql
```
OR
```$xslt
$psql
```

#### TroubleShoot

`brew reinstall readline` - If needed.

`createuser -s postgres` - fixes role "postgres" does not exist.

Full Guide [Here](https://gist.github.com/ibraheem4/ce5ccd3e4d7a65589ce84f2a3b7c23a3).

### Create Database

##### 1. Access psql

```$xslt
psql
```

##### 2. Create InsightGoal database

```$xslt
Create Database InsightGoal;
```

### Run Build in IntelliJ

1. Click Gradle on right pannel of IntelliJ.
2. Click demo -> Tasks -> application -> bootRun