1. Jasypt Encryption
 
 (having notes how to create/generate the encrypted password by using Jasypt Jar file)
 https://www.ricston.com/blog/encrypting-properties-in-spring-boot-with-jasypt-spring-boot/
 https://www.baeldung.com/spring-boot-jasypt
 
 

  
 
 
     (Note, the ***** was with real password,  just obfuscated)
 
     The param named “input” should be string you wish to encrypt, and the password param is the decryption key used to decode your password as it’s being ingested by Spring during app startup.
   
     java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="database-login-password" algorithm=PBEWithMD5AndDES password=password-as-salt-to-encrypt-db-pwd_will-be-used-during-App-start_set-as-JVM-prop
 
     
        ----ENVIRONMENT-----------------

        Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 9.0.1+11 



        ----ARGUMENTS-------------------

        input: database-login-password"
        password: password-as-salt-to-encrypt-db-pwd_will-be-used-during-App-start_set-as-JVM-prop
        algorithm: PBEWithMD5AndDES



        ----OUTPUT----------------------

        kbg0F6YcSX89fOpDGWxFwR0Dx9GQx5pe   (<=== NOTE, this will be put to spring.datasource.password in application.property;  this encrypted password, contains encrypted-DB-pwd, with the Jasypt-app-pwd (as a salt)) 


NOTE: Baeldung's way for decoding the pwd may be better.

    When running the app, make sure you don’t forget to pass in a value of supersecretz for the argument (command line or JVM) jasypt.encryptor.password e.g:

    mvn -Djasypt.encryptor.password=******* spring-boot:run

    You can then verify the connection to the database by hitting the REST endpoint:


 

2. Original post:

   https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial
   
3. The gotcha:

   3.1 Do not forget mysql dependency, otherwise, will get strange HikariCp error not connecting the mysql
   
   3.2 For User Entity, the columnName for user_name,  needs to use userName, otherwise, not able to generate DDLs
   
   3.3 Once everything setup, the application along with the annotation, hibernate generates the DDL and tables 
       (yes, I ddid create notes database from mysql command line, not sure if this impacts)   
       
       
4. TODOs:  

   4.1 try to add Gradle build
   
   4.2 continue to build the Restful apis; so that
       we can use them in mobile apps.       
       
5. Comments:
       