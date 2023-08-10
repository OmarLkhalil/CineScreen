# CineScreen TV App

CineScreen is a TV application for browsing and watching movies. It allows users to view movie details, watch movie trailers, and enjoy a user-friendly interface designed using Jetpack Compose. The app follows a clean architecture with modularization, pagination, and dependency injection using Dagger Hilt. It also integrates with a REST API using Retrofit to fetch movie data.

## Features

- Browse a collection of movies
- View detailed information about each movie
- Watch movie trailers
- User-friendly UI with TV components and carousel views

## Screenshots

![CineScreen TV App](https://github.com/OmarLkhalil/CineScreen/raw/master/s1.png)
*Screenshot of CineScreen TV App showcasing the user interface.*

## Architecture

CineScreen follows a clean architecture pattern, allowing for clear separation of concerns and easy maintainability. The project is modularized for improved scalability, and Dagger Hilt is used for dependency injection.

## Modules

The app follows a modular architecture, dividing functionality into the following modules:

- **app**: Main entry point, UI, and presentation logic. This module also handles dependency injection.
- **common**: Contains shared components, domain logic, and data handling used across different features.
- **feature-home**: Module for the home screen feature, including UI, presentation logic, and data handling specific to this feature.
- **feature-details**: Module for the movie details screen feature, including UI, presentation logic, and data handling specific to this feature.
- **feature-search**: Module for the search screen feature, including UI, presentation logic, and data handling specific to this feature.

Each module is designed to encapsulate specific functionality, promoting a clean and organized codebase. The `app` module serves as the main entry point, orchestrating the various features and handling dependency injection.

## Tech Stack

- Jetpack Compose: Modern UI toolkit for building native UIs.
- Dagger Hilt: Dependency injection library for Android.
- Retrofit: HTTP client for making API requests.
- Pagination: Handling large data sets efficiently.
- TV Components: Specialized components for TV apps.
- Carousel Component: Creating interactive carousels in the UI.

## Getting Started

1. Clone the repository: `git clone https://github.com/yourusername/CineScreen.git`
2. Open the project in Android Studio.
3. Build and run the app on a TV emulator or device.

## Contributions

Contributions are welcome! If you'd like to contribute to CineScreen, please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Create a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](/LICENSE) file for details.

## Reach Me

Feel free to connect with me on LinkedIn:

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue.svg?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/omarlkhalil/)

Happy coding! 🎬📺
