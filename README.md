# dynamo

ทดลอง การเขียน RestApi เชื่อมต่อ DynamoDB ด้วย Spring Reactive

Config 
# AmazonDynamoDB:DynamoDBMapper
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
