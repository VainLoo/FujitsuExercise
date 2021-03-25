docker build --file=backend/backend.dockerfile  -t exercise-web-backend .
docker build --file=frontend/frontend.dockerfile  -t exercise-web-frontend .
docker-compose -f docker-compose.yml up