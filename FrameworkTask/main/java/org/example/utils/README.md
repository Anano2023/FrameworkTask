### Running framework task tests

- Launch parameters for tests execution are stored in .properties files:
- There is a test of type `smoke`

For example to run tests For Dev environment:
```commandline
 mvn clean test -Pdev 
```
For Prod environment:
```commandline
 mvn clean test -Pprod 
```

To run tests in `dev` environment with `smoke` tag

```commandline
 mvn clean test -Denv=dev -Dtests=smoke
```