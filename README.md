# RobotController
A program to report the current position of a room in a given room after following the given navigation commands


## 📖 Table of Contents
- [Getting Started](#getting-started)
- [License](#license)

## 🛠️ Getting Started

### Prerequisites
Ensure you have the following installed:
- Java21
- Maven 3.9.x

### Assumptions
Based on the sample examples given in the problem documentation, following points are assumed in the program:
- The field in the floor starts from top left corner and is 0-indexed
- The orientation is the general map orientation with North at the top, South at the bottom, East to the right, and west to the left
- The input for the fields are assumed to be integers.
- The program execution happens only for one scenario. The jar file needs to be re-executed to run one more scenario.


### Installation
Clone the repository and install dependencies:
```bash
git clone https://github.com/rajadwarampudi/RobotController.git
cd RobotController
mvn clean package


# To Compile the project
mvn package

# To run unit testcases
mvn test

# To build the project without testcase runs
mvn clean package -DskipTests

```

### Execution instructions

- A pre-compiled jar file called RobotController-1.0-SNAPSHOT.jar is placed in the root directory of the project.
- A new jar file can be generated from the instruction above from #Installation section and the jar fill generated in target folder of the project directory
- The jar file can be executed using following command

```bash
java -jar RobotController-1.0-SNAPSHOT.jar
```

The program waits for the input as mentioned in the problem documentation.


Ex:  
5 5  
1 2 N  
RFRFFRFRF  

The output will be printed in the next line.  
Report: 1 3 N