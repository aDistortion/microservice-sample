--create user and db with tablespace for alfresco
CREATE ROLE demoalf WITH LOGIN PASSWORD 'demoalf';
CREATE DATABASE alfresco OWNER demoalf;