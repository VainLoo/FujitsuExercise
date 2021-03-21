# FujitsuExercise
Fujitsu internship exercise by Allan Loo

Java version: 11  
Database MongoDB version: 2.4.1  
SpringBoot version: 2.4.3  
Docker Engine version: 20.10.5  

# Running The project using Docker:
(Requires Docker to be installed obviously)  
Run the following commands from the project root directory. 

For the backend:  
docker build --file=backend/backend.dockerfile  -t exercise-web-backend .  
For the frontend:  
docker build --file=frontend/frontend.dockerfile  -t exercise-web-frontend .  

To run the built project:  
docker-compose -f docker-compose.yml up  
