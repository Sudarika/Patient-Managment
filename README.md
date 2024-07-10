# Patient Management App

This is a simple Android application for managing patient details using Room for local database management. The app allows users to add, view, and delete patient records.

## Features

- Add new patient details
- View a list of all patients
- Delete selected patients

## Technologies Used

- **Kotlin**: Programming language for Android development
- **Android Room**: For local database management
- **ViewModel and LiveData**: For managing UI-related data in a lifecycle-conscious way
- **RecyclerView**: For displaying the list of patients
- **Coroutines**: For asynchronous programming

## Prerequisites

- Android Studio
- Kotlin

## Installation

- Clone this repository to your local machine.
- Open the project in Android Studio.
- Build the project to download the necessary dependencies.
- Run the app on an Android device or emulator.

## Usage
### Adding a Patient
Open the app.
1. Click on the "Add" button (labelled as btnadd in the code).
2. A dialog will appear prompting you to enter the patient's name, doctor's name, and the date.
3. Fill in the details and click "Save".
4. The new patient will be added to the list.
