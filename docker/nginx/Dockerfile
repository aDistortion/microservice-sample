FROM nginx:latest

ADD ./default.conf /etc/nginx/conf.d/

RUN mkdir -p /var/www/shop
#ADD ../frontend/shop/dist/*.* /var/www/shop
RUN chown -R www-data:www-data /var/www

#substitude env vars...
#CMD ["/bin/bash", "-c", "envsubst < /etc/nginx/conf.d/mysite.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'"]


