# AppleCrypto
To run this project   
1. clone the repo  
2. run mvn package  
3. java -jar target/crypto-1.0-SNAPSHOT.jar server hello-world.yml   
These are the following API endpoints in the project  
/PushAndRecalculate - input a double and returns the average and standard deviation of the list  
/PushRecalculateAndEncrypt - input a double and returns encrypted strings of the average and standard deviation of the list  
/Decrypt - input an encrypted string, and it returns the decrypted double value  

Sample requests:  
curl --location --request POST 'http://localhost:8080/crypto/PushAndRecalculate?number=9'  
curl --location --request POST 'http://localhost:8080/crypto/PushRecalculateAndEncrypt?number=8'   
curl --location --request POST 'http://localhost:8080/crypto/Decrypt?encryptedNumber=xjHckqlsQfgDxUbKfHFfsogsol7GQma5hjlPcDhjd00='  
