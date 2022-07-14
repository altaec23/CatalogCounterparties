package ru.alon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alon.entity.Counterparty;

public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {

}
