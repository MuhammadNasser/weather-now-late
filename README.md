# 🌦️ Weather Now & Later

A clean and modern Android weather app built with Jetpack Compose, Clean Architecture, and OpenWeatherMap API.  
It provides current weather and 7-day forecast with offline support for search history.

---

## 📱 Features

- 🌍 Search weather by city name
- 🌡️ Current weather details (temperature, condition, icon, units)
- 📆 7-day forecast
- 📶 Offline support for last-searched city
- 🔁 Toggle temperature unit (°C / °F)
- 🕘 Recent city search history
- 🧪 Unit testing for use cases and view models

---

## 🧱 Tech Stack

| Layer       | Tools / Libraries                        |
|-------------|------------------------------------------|
| UI          | Jetpack Compose                          |
| DI          | Hilt                                     |
| Architecture| Clean Architecture (Modular), MVVM + MVI |
| Networking  | Retrofit, OkHttp, Moshi                  |
| Persistence | Room                                     |
| Navigation  | Jetpack Navigation Compose               |
| Async       | Kotlin Coroutines, StateFlow             |
| Testing     | JUnit, Turbine                           |

---

## 🧭 Module Structure

```text
📦 weather-app
├── core           // Shared constants & interfaces
├── data           // Repositories, data sources, DTOs, mappers
├── domain         // Use cases and domain models
├── ui
│   ├── cityinput        // City search screen
│   ├── currentweather   // Current weather screen
│   └── forecast         // 7-day forecast screen
├── di             // Hilt modules
└── app            // App entry point and navigation
```

---

## 🚀 Getting Started

### ✅ Requirements
- Android Studio Giraffe or newer
- Android SDK 33+
- Internet connection
- OpenWeatherMap API Key

### 🔧 Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/MuhammadNasser/weather-app.git
   ```

2. Add your OpenWeatherMap API key:
    - Inside `gradle.properties` :  
      add `YOUR_API_KEY_HERE`

3. Build and run the app.

---

## 🧪 Testing

Unit tests available for:
- Use cases
- Repositories
- ViewModels

Run tests with:
```bash
./gradlew test
```

---

## 📸 Screenrecord
![Preview](screenshots/screenrecord.gif)