-- Application User should be defined in application configuration
CREATE USER 'kekapp'@'localhost' IDENTIFIED BY '7V651VazaALhzshRpOoM';
GRANT Delete ON kek.* TO 'kekapp'@'localhost';
GRANT Insert ON kek.* TO 'kekapp'@'localhost';
GRANT Select ON kek.* TO 'kekapp'@'localhost';
GRANT Update ON kek.* TO 'kekapp'@'localhost';
FLUSH PRIVILEGES;

-- Administration User should be used for managing the database
CREATE USER 'kekadmin'@'localhost' IDENTIFIED BY '8dMMhxChYyncRBEtIQZf';
GRANT Create user ON *.* TO 'kekadmin'@'localhost';
GRANT Event ON *.* TO 'kekadmin'@'localhost';
GRANT Process ON *.* TO 'kekadmin'@'localhost';
GRANT Reload ON *.* TO 'kekadmin'@'localhost';
GRANT Replication client ON *.* TO 'kekadmin'@'localhost';
GRANT Replication slave ON *.* TO 'kekadmin'@'localhost';
GRANT Show databases ON *.* TO 'kekadmin'@'localhost';
GRANT Shutdown ON *.* TO 'kekadmin'@'localhost';
GRANT Super ON *.* TO 'kekadmin'@'localhost';
GRANT Create tablespace ON *.* TO 'kekadmin'@'localhost';
GRANT Alter ON kek.* TO 'kekadmin'@'localhost';
GRANT Create ON kek.* TO 'kekadmin'@'localhost';
GRANT Create view ON kek.* TO 'kekadmin'@'localhost';
GRANT Delete ON kek.* TO 'kekadmin'@'localhost';
GRANT Drop ON kek.* TO 'kekadmin'@'localhost';
GRANT Grant option ON kek.* TO 'kekadmin'@'localhost';
GRANT Index ON kek.* TO 'kekadmin'@'localhost';
GRANT Insert ON kek.* TO 'kekadmin'@'localhost';
GRANT References ON kek.* TO 'kekadmin'@'localhost';
GRANT Select ON kek.* TO 'kekadmin'@'localhost';
GRANT Show view ON kek.* TO 'kekadmin'@'localhost';
GRANT Trigger ON kek.* TO 'kekadmin'@'localhost';
GRANT Update ON kek.* TO 'kekadmin'@'localhost';
GRANT Alter routine ON kek.* TO 'kekadmin'@'localhost';
GRANT Create routine ON kek.* TO 'kekadmin'@'localhost';
GRANT Create temporary tables ON kek.* TO 'kekadmin'@'localhost';
GRANT Execute ON kek.* TO 'kekadmin'@'localhost';
GRANT Lock tables ON kek.* TO 'kekadmin'@'localhost';
FLUSH PRIVILEGES;
