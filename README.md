# CCP Hall Booking Android App

The **CCP Hall Booking App** is an Android application that allows users to request bookings for various campus venues (like Seminar Hall, Smart Room, etc.). The booking is then reviewed and approved by an Admin. The app ensures that venues cannot be double-booked and streamlines communication between users and admin for event organization.

## 📱 Features

- View list of available venues by type
- Request bookings for selected date & time
- Prevents overlapping/double bookings
- Admin login to view and approve booking requests
- Notifies users once their request is approved or rejected
- Stores venue data in **SQLite** (offline/local)
- Simple, clean UI for easy navigation

## 🛠 Tech Stack

- **Java** (Android SDK)
- **SQLite** (Local database)
- **XML** for layout design

## 🏛 Modules

- `User Module`: Can browse venues, request bookings
- `Admin Module`: View all requests and approve/reject them
- `Venue Management`: Predefined venues saved in local DB

## 📁 Folder Structure


