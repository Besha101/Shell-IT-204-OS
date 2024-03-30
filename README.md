# 🚀 Advanced Shell Project

## Group Members
- Ajdin Bešić
- Emir Murselović

## 📁 Submission Contents
- src/
  - AdvancedShell.java
  - BasicSystemCalls.java
  - IntermediateSystemCalls.java
  - ForkBomb.java
- README.md

## ✏️ Answers to Assignment Questions
### 1. System Call Analysis (Question 1.5.1)
#### Reading from Disk
Reading from disk requires the operating system to use kernel mode. This is because accessing disk hardware directly requires privileged access, which is only available in kernel mode.

#### Reading the Current Time
Reading the current time from the hardware clock can typically be done in user mode. Modern operating systems provide system calls that allow user mode processes to request the current time from the hardware clock or system timer.

### 2. Purpose of System Calls (Question 1.5.2)
System calls serve the purpose of providing a controlled interface for user programs to access system resources in a safe and controlled manner. There are different sets of system calls, including:
- 🔄 **Process control system calls:**
   - `fork()`: Create a new process.
   - `exec()`: Execute a new program within the current process.
- 📂 **File management system calls:**
   - `open()`: Open a file for reading or writing.
   - `read()`: Read data from an open file descriptor.
   
System calls provide access to various resources managed by the operating system, allowing user programs to interact with hardware, file systems, and other system resources.

### 3. Possible Outputs (Question 1.5.3)
The program provided in the question can have several possible outputs depending on the success or failure of the system calls involved. These outputs include:
- Printing "Hello3" if both `fork()` and `exec()` calls succeed.
- Printing "Hello4" if the `fork()` call fails.
- Printing "Hello1", "Hello2", and "Hello3" in various orders if the `exec()` call fails or if the `wait()` call fails or if the parent process terminates before the child process.
- Each scenario represents different outcomes based on the success or failure of the system calls `fork()`, `exec()`, and `wait()`.

## 📋 Project Outline
The project implements a robust shell interface in Java, providing functionalities such as colored prompts, basic system calls, and command execution. Each component of the shell is designed to enhance user experience and provide seamless interaction with the system.

## 🛠️ Compiling Instructions
To compile the programs, navigate to the directory containing the Java files and run the following command:

## 🤔 Challenges Encountered
Honestly everything was a challenge.

## 📚 Sources/Tutorials Used
- [Java documentation](https://docs.oracle.com/en/java/)
- [Stack Overflow](https://stackoverflow.com/)

## ⚠️ Known Issues
Currently, there are no known issues with the implementation. However, further testing and refinement may be required to ensure optimal performance and robustness.



