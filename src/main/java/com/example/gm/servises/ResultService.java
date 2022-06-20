package com.example.gm.servises;


import com.example.gm.exeptions.CategoryNotFoundException;
import com.example.gm.models.*;
import com.example.gm.repositories.*;
import com.example.gm.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ResultService {
    public static final Logger LOG = LoggerFactory.getLogger(ResultService.class);

    private ResultRepository resultRepository;
    private UserRepository userRepository;
    private ZapisRepository zapisRepository;
    private ConclusionRepository conclusionRepository;
    private DicomRepository dicomRepository;
    @Autowired
    public ResultService(ResultRepository resultRepository, UserRepository userRepository, ZapisRepository zapisRepository, ConclusionRepository conclusionRepository, DicomRepository dicomRepository) {
        this.resultRepository = resultRepository;
        this.userRepository = userRepository;
        this.zapisRepository = zapisRepository;
        this.conclusionRepository = conclusionRepository;
        this.dicomRepository = dicomRepository;
    }

    public Result saveResult(Principal principal, Long zapisId,
                             MultipartFile conc, MultipartFile dicom) {
        User user = getUserByPrincipal(principal);
        Result result = new Result();
        Zapis zapis = zapisRepository.findZapisById(zapisId)
                .orElseThrow(() -> new CategoryNotFoundException("Zapis not found"));
        result.setUser(user.getId());
        result.setDicom(uploadDicom(dicom, principal));
        result.setConclusion(uploadConclusion(conc, principal));
        result.setZapis(zapis);

        LOG.info("Saving new result");
        return resultRepository.save(result);
    }

    public Dicom uploadDicom(@RequestParam("dicom") MultipartFile dicom, Principal principal) {
        User user = getUserByPrincipal(principal);
        Dicom dicommodel = new Dicom();

        Dicom biaopath = null;
        if (!dicom.isEmpty()) {
            // Получить имя файла, включая суффикс
            String fileName = dicom.getOriginalFilename();

            // Сохранение по этому пути: Этот путь находится в статическом файле в каталоге проекта: (Примечание: этот файл может потребоваться создать самостоятельно)
            // Причиной помещения его в static является то, что он хранит статические файловые ресурсы, то есть адрес локального сервера вводится через браузер, к которому можно получить доступ при добавлении имени файла
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "dicom/" + user.getLastname() + user.getName();
            File file = new File(path);
            boolean status = file.exists();
            try {
                if (status == false) {
                    file.mkdir();
                    FileUtil.fileupload(dicom.getBytes(), path, fileName);
                    dicommodel.setUser(user.getId());
                } else {
                    FileUtil.fileupload(dicom.getBytes(), path, fileName);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Затем создаем соответствующий класс сущности, добавляем следующий путь и затем записываем его через метод операции базы данных
            biaopath = new Dicom();
            biaopath.setPath("http://localhost:8080/" + fileName);


        }
        return dicomRepository.save(biaopath);

    }

    public Conclusion uploadConclusion(@RequestParam("conc") MultipartFile conc, Principal principal) {
        User user = getUserByPrincipal(principal);
        Conclusion concModel = new Conclusion();
        Conclusion biaopath = null;
        if (!conc.isEmpty()) {
            // Получить имя файла, включая суффикс
            String fileName = conc.getOriginalFilename();

            // Сохранение по этому пути: Этот путь находится в статическом файле в каталоге проекта: (Примечание: этот файл может потребоваться создать самостоятельно)
            // Причиной помещения его в static является то, что он хранит статические файловые ресурсы, то есть адрес локального сервера вводится через браузер, к которому можно получить доступ при добавлении имени файла
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "conclusions/" + user.getLastname() + user.getName();
            File file = new File(path);
            boolean status = file.exists();

            try {
                // Этот метод является оберткой для записи в файл. В классе util вы можете использовать этот пакет после его импорта. Метод будет дан позже
                if (status == false) {
                    file.mkdir();
                    FileUtil.fileupload(conc.getBytes(), path, fileName);
                    concModel.setUser(user.getId());
                } else {
                    FileUtil.fileupload(conc.getBytes(), path, fileName);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Затем создаем соответствующий класс сущности, добавляем следующий путь и затем записываем его через метод операции базы данных
            biaopath = new Conclusion();
            biaopath.setPath("http://localhost:8080/" + fileName);


        }
        return conclusionRepository.save(biaopath);

    }

    private User getUserByPrincipal(Principal principal) {
        String email = principal.getName();
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found" + email));
    }
}
