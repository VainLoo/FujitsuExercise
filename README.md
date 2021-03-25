# FujitsuExercise
Fujitsu internship exercise by Allan Loo

Java version: 11  
Database MongoDB version: 2.4.1  
SpringBoot version: 2.4.3  
Docker Engine version: 20.10.5  

Also added the Delete all entries button for more convenient testing.

# Running The project using Docker:
(Requires Docker to be installed obviously)  
Make sure Docker is running.  

Run ```runProject.bat``` in the root directory of the project  
OR  
Run the following commands from the project root directory. 

For the backend:  
```
docker build --file=backend/backend.dockerfile  -t exercise-web-backend .  
```
For the frontend:  
```
docker build --file=frontend/frontend.dockerfile  -t exercise-web-frontend .  
```

To run the built project:  
docker-compose -f docker-compose.yml up  

---

The project is now running on the following URLs:  
frontend: http://localhost:3000  
backend: http://localhost:8080  
database: http://localhost:27017  
