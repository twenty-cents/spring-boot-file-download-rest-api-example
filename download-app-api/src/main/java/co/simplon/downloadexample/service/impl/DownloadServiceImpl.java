package co.simplon.downloadexample.service.impl;

import co.simplon.downloadexample.exception.MyFileNotFoundException;
import co.simplon.downloadexample.service.DownloadService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DownloadServiceImpl implements DownloadService {
    private Path fileStorageLocation;

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = Paths.get(fileName).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
