package com.example.gm.facade;

import com.example.gm.dto.ZapisDTO;
import com.example.gm.models.Zapis;
import org.springframework.stereotype.Component;

@Component
public class ZapisFacade {

    public ZapisDTO zapisToZapisDTO(Zapis zapis){
        ZapisDTO zapisDTO = new ZapisDTO();
        zapisDTO.setId(zapis.getId());
        zapisDTO.setTime(zapis.getTime());
        zapisDTO.setDate(zapis.getDate());

        return zapisDTO;
    }
}
