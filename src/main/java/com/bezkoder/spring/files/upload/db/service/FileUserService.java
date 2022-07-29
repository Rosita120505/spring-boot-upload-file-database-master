package com.bezkoder.spring.files.upload.db.service;

import com.bezkoder.spring.files.upload.db.model.FileDB;
import com.bezkoder.spring.files.upload.db.model.FotoUser;
import com.bezkoder.spring.files.upload.db.repository.FileDBRepository;
import com.bezkoder.spring.files.upload.db.repository.FotoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileUserService {

    @Autowired
    private FotoUserRepository fotoUserRepository;

    public FotoUser store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FotoUser FotoUser = new FotoUser(fileName, file.getContentType(), file.getBytes());

        return fotoUserRepository.save(FotoUser);
    }

    public FotoUser getFile(String id) {
        return fotoUserRepository.findById(id).get();
    }

    public Stream<FotoUser> getAllFiles() {
        return fotoUserRepository.findAll().stream();
    }
}
