package com.ibm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdContaCliente implements Serializable {
    private String numeroConta;
    private String agencia;
    private LocalDate ultimaMovimentacao;
}
