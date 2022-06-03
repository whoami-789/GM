package com.example.gm.servises;

import com.example.gm.models.Conclusion;
import com.example.gm.models.Dicom;
import com.example.gm.repositories.ConclusionRepository;
import com.example.gm.repositories.DicomRepository;
import com.example.gm.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    private final DicomRepository dicomRepository;
    private final ConclusionRepository conclusionRepository;

    @Autowired
    public FileService(DicomRepository dicomRepository, ConclusionRepository conclusionRepository) {
        this.dicomRepository = dicomRepository;
        this.conclusionRepository = conclusionRepository;
    }

    public String UploadDicom(@RequestParam("dicom") MultipartFile dicom) {
        if(!dicom.isEmpty()) {
            // Получить имя файла, включая суффикс
            String fileName = dicom.getOriginalFilename();

            // Сохранение по этому пути: Этот путь находится в статическом файле в каталоге проекта: (Примечание: этот файл может потребоваться создать самостоятельно)
            // Причиной помещения его в static является то, что он хранит статические файловые ресурсы, то есть адрес локального сервера вводится через браузер, к которому можно получить доступ при добавлении имени файла
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"dicom/";

            try {
                // Этот метод является оберткой для записи в файл. В классе util вы можете использовать этот пакет после его импорта. Метод будет дан позже
                FileUtil.fileupload(dicom.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Затем создаем соответствующий класс сущности, добавляем следующий путь и затем записываем его через метод операции базы данных
            Dicom biaopath = new Dicom();
            biaopath.setPath("http://localhost:8080/"+fileName);
            dicomRepository.save(biaopath);

        }
        return "Dicom success";

    }

    public String UploadConclusion(@RequestParam("conc") MultipartFile conc) {
        if(!conc.isEmpty()) {
            // Получить имя файла, включая суффикс
            String fileName = conc.getOriginalFilename();

            // Сохранение по этому пути: Этот путь находится в статическом файле в каталоге проекта: (Примечание: этот файл может потребоваться создать самостоятельно)
            // Причиной помещения его в static является то, что он хранит статические файловые ресурсы, то есть адрес локального сервера вводится через браузер, к которому можно получить доступ при добавлении имени файла
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"conclusions/";

            try {
                // Этот метод является оберткой для записи в файл. В классе util вы можете использовать этот пакет после его импорта. Метод будет дан позже
                FileUtil.fileupload(conc.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Затем создаем соответствующий класс сущности, добавляем следующий путь и затем записываем его через метод операции базы данных
            Conclusion biaopath = new Conclusion();
            biaopath.setPath("http://localhost:8080/"+fileName);
            conclusionRepository.save(biaopath);

        }
        return "Dicom success";

    }
}
