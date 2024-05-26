# Calculates

This project contains TestNG tests to validate a `calculate` method, which performs arithmetic calculations based on input parameters.

## Test Cases

The test cases cover various scenarios including:

- Valid input values.
- Cases where the denominator is zero, leading to undefined or NaN results.
- Positive and negative input values.

## How to Run Tests

### Prerequisites

Make sure you have [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) installed on your machine.

### Steps

1. **Clone the Repository**: Clone or download this repository to your local machine.

2. **Open the Project**: Open [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) and load the project by selecting `File > Open` and navigating to the directory where you cloned the repository.

3. **Run the Tests**: Open the `Main.java` file located in the `src` directory. Right-click on the file and choose `Run 'Main'` from the context menu.

4. **Review Test Results**: After running the tests, IntelliJ IDEA will display the results in a test runner window. Ensure that all tests pass successfully.

## Understanding the Code

- The `Main` class contains a `testCalculate` method, which tests the `calculate` method with various input values.
- Test data is provided through the `testCases` data provider method.
- The `calculate` method performs a simple arithmetic calculation based on the input parameters (`a`, `b`, `c`, `d`).
