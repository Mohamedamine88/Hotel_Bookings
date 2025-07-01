# Hotel bookings

A Java Swing application for managing hotel or room reservations. This project allows users to manage clients, rooms, categories, and reservations through a graphical user interface.

## Features
- User authentication
- Manage clients, rooms, categories, and reservations (CRUD operations)
- Simple and intuitive Swing-based GUI
- Database connectivity for persistent storage

## Project Structure
```
GestiondesRéservations/
  ├── src/
  │   ├── Connexion/         # Database connection
  │   ├── Entities/          # Entity classes (Categorie, Chambre, Client, Reservation)
  │   ├── Forms/             # GUI forms (Swing)
  │   ├── IDAO/              # DAO interface
  │   └── Service/           # Business logic/services
  ├── nbproject/             # NetBeans project files
  ├── build.xml              # Ant build script
  └── manifest.mf            # Java manifest file
```

## Requirements
- Java JDK 8 or higher
- NetBeans IDE or any Java IDE
- Database (MySQL, SQLite)

## Build & Run
1. **Clone the repository:**
   ```
   git clone https://github.com/Mohamedamine88/Hotel_Bookings.git
   ```
2. **Open the project in NetBeans or your preferred IDE.**
3. **Configure the database connection** in `src/Connexion/Connexion.java` as needed.
4. **Build and run the project** using your IDE or with Ant:
   ```
   ant run
   ```

## License
This project was developed as part of the Java subject projects in my 4IIR program.
