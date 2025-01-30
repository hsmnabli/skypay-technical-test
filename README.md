# Project Setup and Testing
## Prerequisites

Make sure you have the following installed on your machine:
- Java JDK (version 17 or higher)
- Maven (version 3.6.3 or higher)
- Git

## Steps to Run Unit Tests

1. **Clone the GitHub Repository**
   - Open your terminal or command prompt.
   - Use the following command to clone the repository:
     ```bash
     git clone https://github.com/hsmnabli/skypay-technical-test
     ```

2. **Navigate to the Project Folder**
   - Change the directory to project folder.
     ```bash
     cd path/to/kata/project
     ```

3. **Compile and Run Unit Tests**
   - Once you are in the project folder, run the following command to compile the project and execute the unit tests:
     ```bash
     mvn compile test
     ```
## Project structure
```bash
kata
│
├── pom.xml
└── src
	└── main
		└── java
			└── com.skypay.kata
				└──Account.java
				└──AccountService.java
				└──Transaction.java
				└──exceptions
					└──DisabledAccountException.java
					└──InvalidAmountException.java
					└──InvalidWithdrawAmountException.java

	└── test
		└── java
			└── com.skypay.kata
				└── AccountTest.java
└── .gitignore
└── README.md
└── kata.iml
```
