package base.template.template.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import java.nio.file.Paths;

@Service
public class S3Service {
    private final S3Client s3Client;

    public S3Service(){
        this.s3Client = S3Client.builder()
        .region(Region.<Specify_Region_Here - format US_EAST_2>)
        .credentialsProvider(ProfileCredentialsProvider.create("default")) //we will specify the credentials for this aws account Adjust as needed
        .build();
    }
    public void uploadFile(String bucketName, String key, String filePath){
        try{
            PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
            s3Client.putObject(request, Paths.get(filePath));
            System.out.println("File Successfully Uploaded to S3");
        } catch (S3Exception e) {
            e.printStackTrace();
        }
    }
}
