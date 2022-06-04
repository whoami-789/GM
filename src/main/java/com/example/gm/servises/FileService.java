package com.example.gm.servises;

import com.example.gm.models.Conclusion;
import com.example.gm.models.Dicom;
import com.example.gm.models.User;
import com.example.gm.repositories.ConclusionRepository;
import com.example.gm.repositories.DicomRepository;
import com.example.gm.repositories.UserRepository;
import com.example.gm.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

@Service
public class FileService {

    private final DicomRepository dicomRepository;
    private final ConclusionRepository conclusionRepository;
    private final UserRepository userRepository;
    @Autowired
    public FileService(DicomRepository dicomRepository, ConclusionRepository conclusionRepository, UserRepository userRepository) {
        this.dicomRepository = dicomRepository;
        this.conclusionRepository = conclusionRepository;
        this.userRepository = userRepository;
    }

    public String UploadDicom(@RequestParam("dicom") MultipartFile dicom, Principal principal) {
        User user = getUserByPrincipal(principal);

        if(!dicom.isEmpty()) {
            // Получить имя файла, включая суффикс
            String fileName = dicom.getOriginalFilename();

            // Сохранение по этому пути: Этот путь находится в статическом файле в каталоге проекта: (Примечание: этот файл может потребоваться создать самостоятельно)
            // Причиной помещения его в static является то, что он хранит статические файловые ресурсы, то есть адрес локального сервера вводится через браузер, к которому можно получить доступ при добавлении имени файла
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"dicom/" + user.getSurname() + user.getName();
            File file = new File(path);
            boolean status = file.exists();
            try {
                if(status == false) {
                    file.mkdir();
                    FileUtil.fileupload(dicom.getBytes(), path, fileName);
                }else{
                    FileUtil.fileupload(dicom.getBytes(), path, fileName);
                }
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

    public String UploadConclusion(@RequestParam("conc") MultipartFile conc, Principal principal) {
        User user = getUserByPrincipal(principal);

        if(!conc.isEmpty()) {
            // Получить имя файла, включая суффикс
            String fileName = conc.getOriginalFilename();

            // Сохранение по этому пути: Этот путь находится в статическом файле в каталоге проекта: (Примечание: этот файл может потребоваться создать самостоятельно)
            // Причиной помещения его в static является то, что он хранит статические файловые ресурсы, то есть адрес локального сервера вводится через браузер, к которому можно получить доступ при добавлении имени файла
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"conclusions/" + user.getSurname() + user.getName();
            File file = new File(path);
            boolean status = file.exists();

            try {
                // Этот метод является оберткой для записи в файл. В классе util вы можете использовать этот пакет после его импорта. Метод будет дан позже
                if (status == false){
                    file.mkdir();
                    FileUtil.fileupload(conc.getBytes(), path, fileName);
                }else{
                    FileUtil.fileupload(conc.getBytes(), path, fileName);
                }
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

    private User getUserByPrincipal(Principal principal) {
        String email = principal.getName();
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found" + email));
    }
}
