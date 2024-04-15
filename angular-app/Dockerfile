FROM nginx:1.23.3
EXPOSE 80
ENV DOGS_URL http://localhost:8080/dogs
ADD dist/ng-dogs /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
