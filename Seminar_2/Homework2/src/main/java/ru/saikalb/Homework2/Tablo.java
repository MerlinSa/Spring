package ru.saikalb.Homework2;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@Scope(ConfigurableListableBeanFactory.SCOPE_SINGLETON)
public class Tablo {
    private final TicketNumberGenerator ticketNumberGenerator;

    public Tablo(TicketNumberGenerator ticketNumberGenerator) {
        Objects.requireNonNull(ticketNumberGenerator);
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

  public Ticket newTicket(){
      return new Ticket(this.ticketNumberGenerator.createNewNumber(),LocalDateTime.now());
  }
}
/*
3. Класс "Табло" - бин (синглтон), у которого есть поле ticketNumberGenerator
   и метод метод newTicket(), который создает объетк класса Ticket с значениями полей:
3.1 number - результат вызова TicketNumberGenerator#createNewNumber
3.2 createdAt - LocalDateTime.now()
 */
