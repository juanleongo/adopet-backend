package AdoPet.adopet.back.controller;

import AdoPet.adopet.back.picturess.Image;
import AdoPet.adopet.back.picturess.ImageRepository;

import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CloudBlobClient cloudBlobClient;

    @PostMapping("/subir")
    public void uploadImage(@RequestParam("file") MultipartFile file) throws Exception {

        // obtener el nombre del archivo
        String fileName = file.getOriginalFilename();

        // crear un nuevo Blob de Azure con el nombre del archivo
        CloudBlobContainer container = cloudBlobClient.getContainerReference("pictures");
        CloudBlockBlob blob = container.getBlockBlobReference(fileName);

        // subir la imagen al Blob de Azure
        blob.upload(file.getInputStream(), file.getSize());

        // crear una nueva entidad Image y guardar los detalles de la imagen en la base de datos
        Image image = new Image();
        image.setName(fileName);
        image.setContentType(file.getContentType());
        image.setUrl(blob.getUri().toString());

        imageRepository.save(image);

        // devolver una respuesta con la entidad Image creada

    }
}