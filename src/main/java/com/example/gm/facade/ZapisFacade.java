package com.example.gm.facade;

import com.example.gm.dto.ZapisDTO;
import com.example.gm.models.Zapis;
import org.springframework.stereotype.Component;

@Component
public class ZapisFacade {

    public ZapisDTO zapisToZapisDTO(Zapis zapis){
        ZapisDTO zapisDTO = new ZapisDTO();
        zapisDTO.setEmail(zapis.getUser().getEmail());
        zapisDTO.setTitle(zapis.getCategory().getTitle());
        zapisDTO.setId(zapis.getId());
        zapisDTO.setTime(zapis.getTime());
        zapisDTO.setDate(zapis.getDate());

        return zapisDTO;
    }
}
