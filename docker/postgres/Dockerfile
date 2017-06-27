FROM postgres:latest

#set locale to german utf-8 for log output
RUN localedef -i de_DE -c -f UTF-8 -A /usr/share/locale/locale.alias de_DE.UTF-8
ENV LANG de_DE.utf8

#create init folder if not exists
RUN mkdir -p /docker-entrypoint-initdb.d

#copy the init sqls into the init folder for automatic execution
ADD *.sql /docker-entrypoint-initdb.d/
RUN chmod 755 /docker-entrypoint-initdb.d/*.sql
