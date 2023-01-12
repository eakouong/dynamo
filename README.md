# DynamoDB

ทดลอง การเขียน RestApi เชื่อมต่อ DynamoDB ด้วย Spring Reactive

 
# Config AmazonDynamoDB:DynamoDBMapper
```
@Configuration
public class DynamoDbConfiguration {
    @Value("${dynamo.accessKey}")
    private String accessKey;
    @Value("${dynamo.secretKey}")
    private String secretKey;
    @Value("${dynamo.serviceEndpoint}")
    private String serviceEndpoint;
    @Value("${dynamo.signingRegion}")
    private String signingRegion;

    @Bean
    DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        serviceEndpoint, signingRegion))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey, secretKey)))
                .build();
    }
}

```

# Set application.yaml
```
server:
  port: 8081

---
spring:
  profiles:
    active: dev


---
spring:
  config:
    activate:
      on-profile: dev
server:
  port: 1150
dynamo:
  secretKey: TtP3D6rhlmRehd+3IvuXwijZNpOX0naDjhTDDTR0
  accessKey: AKIAQFI4U3I63F3I47VE
  serviceEndpoint: dynamodb.ap-southeast-1.amazonaws.com
  signingRegion: ap-southeast-1

---
spring:
  config:
    activate:
      on-profile: uat

---
spring:
  config:
    activate:
      on-profile: prod
server:
  port: 5000
```


