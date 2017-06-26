--create user and db with tablespace for alfresco
CREATE ROLE demoworkflow WITH LOGIN PASSWORD 'demoworkflow';
CREATE DATABASE camunda OWNER demoworkflow;