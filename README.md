# Currency Converter Android App

This project is an Android application that allows users to convert currencies in real-time. The app fetches the latest exchange rates from an external API and provides an intuitive user interface for conversion.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Usage](#usage)
- [Contributing](#contributing)

## Features

- Real-time currency conversion
- Supports multiple currencies
- Simple and user-friendly interface
- Data persistence using Azure MySQL database

## Technologies Used

### Backend

- **Spring Boot**: A Java-based framework used to create a standalone application.
- **Maven**: A build automation tool used for project management.
- **Exchange Rates Data API**: External API to fetch real-time exchange rates.
- **Azure Virtual Machine**: Hosting the backend application.
- **Azure MySQL Database**: Storing exchange rates and application data.

### Frontend

- **Android Studio**: IDE for Android development.
- **Retrofit2**: A type-safe HTTP client for Android and Java.
- **Gson**: A Java library to convert JSON to Java objects and vice versa.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Android Studio
- Maven
- Azure account

### Backend Setup

1. Clone the repository
    ```sh
    git clone https://github.com/ayoubmesquiny/Currency-Converter-Android-Spring-boot-Application.git
    cd Currency-Converter-Android-Spring-boot-Application/backend-SpringBoot/currency_converter
    ```

2. Configure application properties
    - Update the `src/main/resources/application.properties` file with your Azure MySQL database credentials and Exchange Rates Data API key.

3. Build the project
    ```sh
    mvn clean install
    ```

4. Run the Spring Boot application
    ```sh
    mvn spring-boot:run
    ```

5. Deploy to Azure Virtual Machine
    - Set up an Azure Virtual Machine.
    - Install Java and Maven on the VM.
    - Transfer your project files to the VM.
    - Run the application on the VM.

### Frontend Setup

1. Clone the repository
    ```sh
    git clone https://github.com/ayoubmesquiny/Currency-Converter-Android-Spring-boot-Application.git
    cd Currency-Converter-Android-Spring-boot-Application/frontend-AndroidStudio/CurrencyExchange
    ```

2. Open the project in Android Studio
    - Start Android Studio.
    - Select "Open an existing Android Studio project".
    - Navigate to the cloned repository and select it.

3. Update Retrofit base URL
    - Update the base URL in Retrofit initialization to point to your backend API hosted on the Azure VM.

4. Build and run the application
    - Connect an Android device or start an emulator.
    - Click the "Run" button in Android Studio.

## Usage

1. Open the app on your Android device.
2. Select the currency you want to convert from and to.
3. Enter the amount.
4. Get the converted amount in real-time.
5. Example of usage:

![exemple d'utilisation 1](https://github.com/ayoubmesquiny/Currency-Converter-Android-Spring-boot-Application/assets/74786469/c0fc6ccc-1cd0-4e93-b994-d5405c8e95b0)

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.
