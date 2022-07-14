package ru.alon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alon.entity.Counterparty;
import ru.alon.repository.CounterpartyRepository;

import java.util.List;

@Service
public class CounterpartyService {

    private final CounterpartyRepository counterpartyRepository;

    @Autowired
    public CounterpartyService(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    /**
     * Метод поиска контрагента по id
     *
     * @param id поиска
     * @return контрагент
     */
    public Counterparty findById(Long id) {
        return counterpartyRepository.getById(id);
    }

    /**
     * @return список всех контрагентов
     */
    public List<Counterparty> findAll() {
        return counterpartyRepository.findAll();
    }

    /**
     * Метод сохраняющий новогоконтрагента, либо изменяющий его данные
     *
     * @param counterparty контрагент
     * @return измененный контрагент
     */
    public Counterparty saveCounterparty(Counterparty counterparty) {
        return counterpartyRepository.save(counterparty);
    }

    /**
     * Метод удаления контрагента
     *
     * @param counterparty контрагент
     */
    public void deleteCounterparty(Counterparty counterparty) {
        counterpartyRepository.delete(counterparty);
    }


}
