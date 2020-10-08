package co.simplon.downloadexample.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public interface DownloadService {

    public Resource loadFileAsResource(String fileName);
}
