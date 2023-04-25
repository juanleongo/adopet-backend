package AdoPet.adopet.back.picturess;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;


@Configuration
public class StorageConfig {

    @Value("adopetimg")
    private String accountName;

    @Value("iVm7G0P1uJdZbM4DWkzo3uyN9YLzgDmGCYPciVo7GGI/FCauoKdLvh9qiOAX7O+sHk89i5+33z1r+AStT8nwIQ==")
    private String accountKey;

    @Bean
    public CloudBlobClient cloudBlobClient() throws InvalidKeyException, URISyntaxException, StorageException {
        String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=adopetimg;AccountKey=iVm7G0P1uJdZbM4DWkzo3uyN9YLzgDmGCYPciVo7GGI/FCauoKdLvh9qiOAX7O+sHk89i5+33z1r+AStT8nwIQ==;EndpointSuffix=core.windows.net";
        CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
        return account.createCloudBlobClient();
    }
}