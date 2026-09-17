# QuickChat - Part 1 (Registration and Login)

This is my Part 1 submission for PROG5121 - Programming 1A. This part of
the PoE is about building a simple registration and login feature for a
chat app called QuickChat, using a console application (no GUI).

## What this app does

1. Asks the user to register by entering:
   - A username (must contain an underscore `_` and be 5 characters or less)
   - A password (must be 8+ characters, and include a capital letter, a
     number and a special character)
   - Their first name and last name
   - A South African cell phone number (must start with `+27` followed by
     9 digits)
2. Tells the user if any of their details are wrong, and lets them try
   again until registration is successful.
3. Once registered, asks the user to log in with their username and
   password, and shows a welcome message if it's correct, or an error
   message if it's not.

## Project structure

```
QuickChat_Part1/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/
│   │   ├── Login.java     -> all the validation + login logic
│   │   └── Main.java      -> the console app itself
│   └── test/java/
│       └── LoginTest.java -> JUnit tests for the Login class
```

## How to run it

**In NetBeans / IntelliJ / Eclipse:**
Open the folder as a Maven project, then run `Main.java`.

**From the command line (if you have Maven installed):**
```
mvn compile exec:java -Dexec.mainClass="Main"
```

**To run the unit tests:**
```
mvn test
```

## Notes

- All the test data used in `LoginTest.java` (like `kyl_1`,
  `Ch&&sec@ke99!` and `+27838968976`) is taken directly from the test
  data table in the assignment brief, as instructed.
- I referenced a regex tutorial site to help me write the pattern for
  checking the cell phone number - the reference is in a comment above
  `checkCellPhoneNumber()` in `Login.java`.
- This is meant to run purely as a console app - I did not use any
  JOptionPane or GUI elements, as per the rules.

## Still to do (not part of Part 1)

- Sending messages feature (Part 2)
- Storing data and the task report (Part 3)
- Pushing this to GitHub with the required number of commits, and
  recording the video presentation.
