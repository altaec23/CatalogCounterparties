package ru.alon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "counterparties")
public class Counterparty {

    /**
     * ID контрагента
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование, не больше 20 символов.
     */
    @Column(name = "name")
    private String name;
    /**
     * ИНН контрагента 10 или 12 цифр
     */
    @Column(name = "inn")
    private String inn;
    /**
     * КПП контрагента из 9 цифр
     */
    @Column(name = "kpp")
    private String kpp;
    /**
     * БИК банка из 9 цифр
     */
    @Column(name = "bikBank")
    private String bikBank;
    /**
     * Номер счета из 20 цифр
     */
    @Column(name = "accountNumber")
    private String accountNumber;
}
