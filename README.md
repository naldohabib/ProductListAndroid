# Product Listing App (Jetpack Compose)

A product listing application built using **Kotlin** and **Jetpack Compose**,

## Key Features

- Fetch products from API on initial load
- Display product name and price
- Quantity management with stock limitation
- Dynamic total price calculation
- Sorting products by:
    - Default (API order)
    - Highest price
    - Lowest price
    - Name (A–Z)
- Checkout flow with success dialog
- Reset cart functionality
- Loading and error handling

## Architecture & State Management

- **Architecture:** MVVM (Model–View–ViewModel)
- **UI:** Jetpack Compose (component-based)
- **State Management:** ViewModel + `mutableStateOf`
- **Reactive UI:** UI automatically updates on state changes

## How to Run

1. Clone the repository
2. Open with **Android Studio**
3. Sync Gradle
4. Run on emulator or physical device (API 24+)