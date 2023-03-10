# Get File .Jar   version 1
clean: 
```
./mvnw clean install
```
package:
````
./mvnw package -DskipTests
````
run build:
````
{spring v2}
./mvnw spring-boot:run -Dspring-boot.run.profiles=local

{spring v1-2} 
./mvnw spring-boot:run -Dspring.profiles.active=local  
````
run dev:
````
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
````
run uat:
````
./mvnw spring-boot:run -Dspring-boot.run.profiles=uat
````
run production:
````
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
````
---
# DynamoDB 
* [อ่านเบื้องต้นได้ที่]( https://aws.amazon.com/th/dynamodb/getting-started/?trk=50d74611-ef80-4ac1-996c-e2e43bc4b423&sc_channel=ps&s_kwcid=AL!4422!3!536393758234!e!!g!!dynamodb&ef_id=CjwKCAiAqt-dBhBcEiwATw-ggAE7zI39uFEuL_Gbpk3BXa-pepLQ5lOOLqmbEztf8a7_1ovWS_ntrhoCvJIQAvD_BwE:G:s&s_kwcid=AL!4422!3!536393758234!e!!g!!dynamodb
  ) - AWS Dynamo


Set in application.properties

secretKey:
``````
dynamo.secretKey= TtP3D6rhlmRehd+3IvuXwijZNpOX0naDjhTDDTR0
``````
accessKey:
``````
dynamo.accessKey= AKIAQFI4U3I63F3I47VE
``````
use connect dynamoDB for AWS


---
# Environment

how to set evn in application.yaml
````
//call dev
spring:
  profiles:
    active: dev

//evn dev
spring:
  config:
    activate:
      on-profile: dev
````
env: dev
````
spring:
  config:
    activate:
      on-profile: dev
````
env: uat
````
spring:
  config:
    activate:
      on-profile: uat
````
env: prod
````
spring:
  config:
    activate:
      on-profile: prod
````
# Git
clone  && run
````
 git clone https://github.com/eakouong/dynamo.git
 git checkout master
 ./mvnw clean install
 ./mvnw spring-boot:run
````
check out
````
git branch //check branch
git branch <name> //create new branch

git checkout <branch>
````
commit & push
````
git add . or git add <namefile>
git commit -m "commit message"
git push //ถ้ามี branch เเล้ว
git push --set-upstream origin <branch> //ถ้ายังไม่มีต้อง new branchใหม่ ใช้ตัวนี้
````
pull
````
git pull --rebase
````

merge
````
git checkout <your_current_branch>  //branch ที่จะmerge
git merge  <your_current_branch>    //branch ที่แก้ไขแล้วจะ mergeไปใส่ตัวบน
git push
get log 
````