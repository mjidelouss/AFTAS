## Aftas Club Competition Management App

AFTAS Club is a sports club located in Tiznit, precisely in Mirleft, offering a range of services and activities including Surf, Tennis, Quad, Pêche sous-marine, Parapente, and more.
The club regularly organizes spearfishing competitions in various regions of Morocco. Club members can participate in competitions by paying a participation fee.
The club handles the logistics, defines a jury, calculates results, and displays the podium.
Aflas club aims to modernize its competition management by developing a responsive web application that meets the needs of the club's administration and the jury.

# Table of Contents
- Features
- Technologies
- Installation
- Usage
- API Endpoints
- Angular Components
- Contributing
- Testing
- License

# Features
- Add Competition: Add a new spearfishing competition.
- List Competitions: View a list of competitions with filtering options (ongoing, closed).
- Member Registration: Allow club members to register for competitions.
- Record Competition Results: Record the results of the competition on the same day.
- Display Podium: Display the top 3 participants.
- Administration Interface: Search for a club member by number, name, or first name.

# Technologies
- Spring Boot: Used for developing the API.
- Angular: Used for providing user interfaces.
- Database: (Specify the database used, e.g., PostgreSQL, MySQL).
- Pagination: Implemented for better data organization.
- Validation: Data validation is enforced.
- Exception Handling: Centralized exception handling using RestControllerAdvice.
- Testing: Unit tests for the competition result calculation service.

# Installation
1- Clone the repository: git clone https://github.com/mjidelouss/AFTAS.git
2- Navigate to the project directory: cd AFTAS
3- (Include any specific setup steps, e.g., setting up the database, configuring application properties).

# Usage
1- Start the Spring Boot application.
2- Start the Angular application.
3- Access the application at http://localhost:8080.

# API Endpoints
/api/competitions (POST, GET)
/api/members (GET)
/api/results (POST)

# Angular Components
- CompetitionFormComponent: Component for adding a new competition.
- CompetitionListComponent: Component for listing competitions.
- MemberRegistrationComponent: Component for member registration.
- ResultRecordingComponent: Component for recording competition results.
- PodiumComponent: Component for displaying the podium.
- AdminInterfaceComponent: Component for the administration interface.

# Contributing
1- Fork the repository.
2- Create a new branch: git checkout -b feature-name.
3- Commit your changes: git commit -m 'Add new feature'.
4- Push to the branch: git push origin feature-name.
5- Open a pull request.

# Testing
- Run unit tests for the competition result calculation service.
- Include any specific instructions for running tests.

# License
- This project is licensed under the SIMPLON License.