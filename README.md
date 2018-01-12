# Bloomberge
Bloomberg to analyze FX deals

Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to import deals details from files into DB. The requested performance is to be able to import the file containing 100,000 records in less than 5 seconds.

//Read Me:
1. Bloomberg Project
2. Java8, Maven, Spring MVC, Hibernate, MySQl are concept used to build this application.
3. 
//Steps to run Bloomberg project:
0. Download project from git hub.
1. Import project to eclipse IDE.
1. Create MySQL Schema progress_soft and create all the required tables.
2. create table iso_currency_code, file_info, valid_deal, invalid_deal, accumulative_count as in puted in MySql_Scripts.sql file.
3. first insert all iso currency code into the iso_currency_code table as listed in MySql_Scripts.sql file.
4. Make all neccessory changes and run the project.
5. use sample csv date file for upload i.e : sample1.cvs and sample2.csv stored in project resources folder (Deal Unique Id, From Currency ISO Code "Ordering Currency", To Currency ISO Code, Deal timestamp, Deal Amount in ordering currency)
5. After Run project, it will open http://localhost:8081/Bloomberg/fileUploadPage , to upload only csv file and click upload button and you can file uploaded successfully.
6. After uploading file, it will display list of alll valid and invalid deals on http://localhost:8081/Bloomberg/listValidAndInvalidDeals.
7. use can run mysql query on mysql workbench to check whether file is stored on database.
8. In valid deal table use see all the valid deals and in Invalid deal table you can see all invalid deals with reason.
9. Iso currency code table store all currency code with country name.
10. In accumulative_count table you can see all accumulative_count.
11. You can list listValid And Invalid Deals by selecting file from drop down.
