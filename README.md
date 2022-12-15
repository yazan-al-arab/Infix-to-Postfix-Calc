# CS2800 Calculator
This Maven project is about creating a Calculator which can solve Reverse Polish notation expressions through a user-friendly interface.

## Requirements
#### - Java SE 11
#### - Eclipse 2022.06 (or later)

## How to Use
1. The radio buttons ONLY support Reverse Polish (PostFix) notation.
2. Enter your Reverse Polish expression into the Expression field.
3. Click the 'Calculate' button and wait for the result to appear in the Result field. 

## Eclipse Run Configuration Goals
#### Run as JavaFX*:
```mvn javafx:run```

#### Export a jar file :
```mvn clean validate package```

Note: Uses 'Maven Shade Plugin' rather than 'Maven Assembly Plugin' so that it can work on Apple Sillicon Macs.

#### *Apple Sillicon Macs not supported.

##  How to Run Calculator

#### 1. Directly running the Jar file.
- Locate the jar file and double click.

#### 2. Running the jar file in a terminal.
```java -jar Calculator.jar```

#### 3. Running the application as a Java Application in Eclipse.
- Create a new run configuration and set uk.ac.rhul.cs2800.Driver as the main class
- Run the configuration

## License

[MIT](https://choosealicense.com/licenses/mit/)