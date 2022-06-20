package com.example.gm.controllers;

import com.example.gm.dto.ZapisDTO;
import com.example.gm.facade.UserZapisFacade;
import com.example.gm.facade.ZapisFacade;
import com.example.gm.models.Address;
import com.example.gm.models.Category;
import com.example.gm.models.Zapis;
import com.example.gm.payload.response.MessageResponse;
import com.example.gm.servises.ZapisService;
import com.example.gm.validators.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/zapis")
@CrossOrigin
public class ZapisController {

    @Autowired
    private ZapisFacade zapisFacade;
    @Autowired
    private UserZapisFacade userZapisFacade;
    @Autowired
    private ZapisService zapisService;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @PostMapping("/create")
    public ResponseEntity<Object> createZapis(@Valid @RequestBody ZapisDTO zapisDTO,
                                              BindingResult bindingResult,
                                              Principal principal, Long categoryId){
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        Zapis zapis = zapisService.createZapis(zapisDTO, principal, categoryId);
        ZapisDTO createdZapis = zapisFacade.zapisToZapisDTO(zapis);

        return new ResponseEntity<>(createdZapis, HttpStatus.OK);
    }
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUserZapis(@Valid @RequestBody ZapisDTO zapisDTO,
                                              BindingResult bindingResult,
                                              Principal principal, Long categoryId){
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        Zapis zapis = zapisService.createZapis(zapisDTO, principal, categoryId);
        ZapisDTO createdZapis = userZapisFacade.zapisToUserZapisDTO(zapis);

        return new ResponseEntity<>(createdZapis, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ZapisDTO>> getAllZaps(){
        List<ZapisDTO> zapisDTOList = zapisService.getAllZaps()
                .stream()
                .map(zapisFacade::zapisToZapisDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(zapisDTOList, HttpStatus.OK);
    }

    @GetMapping("/user/zaps")
    public ResponseEntity<List<ZapisDTO>> getAllZapsForUser(Principal principal){
        List<ZapisDTO> zapisDTOList = zapisService.getAllZapsForUsers(principal)
                .stream()
                .map(zapisFacade::zapisToZapisDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(zapisDTOList, HttpStatus.OK);
    }

    @PostMapping("/{zapisId}/delete")
    public ResponseEntity<MessageResponse> deleteZapis (@PathVariable("zapisId") String zapisId, Principal principal){
        zapisService.deleteZapis(Long.parseLong(zapisId), principal);

        return new ResponseEntity<>(new MessageResponse("Zapis was deleted"), HttpStatus.OK);
    }
}
