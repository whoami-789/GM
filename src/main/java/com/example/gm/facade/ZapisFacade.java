package com.example.gm.facade;

import com.example.gm.dto.ZapisDTO;
import com.example.gm.models.Zapis;
import org.springframework.stereotype.Component;

@Component
public class ZapisFacade {

    public ZapisDTO zapisToZapisDTO(Zapis zapis){
        ZapisDTO zapisDTO = new ZapisDTO();
        zapisDTO.setName(zapis.getUser().getName());
        zapisDTO.setLastname(zapis.getUser().getLastname());
        zapisDTO.setCategory(zapis.getCategory().getId());
        zapisDTO.setId(zapis.getId());
        zapisDTO.setTime(zapis.getTime());
        zapisDTO.setDate(zapis.getDate());

        return zapisDTO;
    }
}
