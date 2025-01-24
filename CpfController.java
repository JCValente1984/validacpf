package com.exemplo.validacpf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CpfController {

    @Autowired
    private ValidacaoCpfService validacaoCpfService;

    @GetMapping("/validarCpf")
    public boolean validarCpf(@RequestParam String cpf) {
        return validacaoCpfService.validarCpf(cpf);
    }
}
