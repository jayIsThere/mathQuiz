# Math Quiz App

The Math Quiz app is an Android application that allows users to solve addition problems based on pre-defined JSON data. Users select the correct answer from a list of options for each problem. The game ends when all problems are solved correctly or an incorrect answer is selected.

## Features

- Solve addition problems from pre-defined JSON data
- Verify the correctness of the chosen answer
- Option to restart the game after completion

## Installation

1. Clone or download the source code.
2. Open the project in Android Studio.
3. Run the app on an emulator or a physical device.

## Usage

1. Launch the app to display an addition problem from the pre-defined JSON data.
2. Select one of the four options provided.
3. Verify the accuracy of the chosen answer.
4. Continue solving problems or exit the game.

## JSON Data Format

The app reads addition problems from pre-defined JSON data. Each JSON object represents an addition problem and includes the following fields:

- `question`: The addition problem in string format.
- `answer`: The correct answer to the addition problem.
- `example1`, `example2`, `example3`, `example4`: Four options for the user to choose from.

Example JSON format:
```json
{
  "question": "1 + 2 = ?",
  "answer": "3",
  "example1": "1",
  "example2": "3",
  "example3": "2",
  "example4": "4"
}
```

## Screenshots

![Screenshot of the Math Quiz app](screenshot.png)

## Contributing

To contribute to this project, follow these steps:

1. Fork this repository.
2. Develop new features or fix bugs.
3. Commit and push your changes.
4. Open a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
