# Bus Schedule App

A simple Android application that displays bus schedules, built with modern Android development tools and best practices.

## Features

- **Bus List:** View a list of all bus stops and their scheduled arrival times.
- **Stop Details:** Click on a bus stop to see the full schedule for that specific stop.
- **Smooth Navigation:** Uses Jetpack Compose Navigation with custom slide animations between screens.
- **Offline Support:** Powered by a local SQLite database via Room.

## Tech Stack

- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android's modern toolkit for building native UI.
- **Navigation:** [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) with custom transitions.
- **Database:** [Room](https://developer.android.com/training/data-storage/room) - A persistence library that provides an abstraction layer over SQLite.
- **Architecture:** MVVM (Model-View-ViewModel).
- **Dependency Injection:** Manual Dependency Injection using a Container pattern (`AppContainer`).
- **Concurrency:** [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) and [Flow](https://developer.android.com/kotlin/flow).

## Project Structure

- **`data`**: Contains the database logic (Room entities, DAOs, and Database class), repositories, and the Dependency Injection container.
- **`ui`**: Contains the Compose UI components, including screens, view models, and navigation logic.
    - **`navigation`**: Defines destinations and the `NavHost`.
    - **`screens`**: Individual app screens (Home, Stop Details).
    - **`reusable`**: Common UI components like top bars and list items.

## How to Run

1. Clone this repository.
2. Open the project in Android Studio (Ladybug or newer recommended).
3. Build and run the app on an emulator or a physical device.

## Database

The app comes pre-populated with a bus schedule database located in `assets/database/bus_schedule.db`. Room is configured to create the database from this asset file.

## Manual Dependency Injection

This project demonstrates manual dependency injection. The `AppContainer` interface and its implementation `AppContainerImpl` manage the instantiation and lifetime of the `StopRepository`, which is then provided to the ViewModels via a custom `ViewModelProvider.Factory`.
