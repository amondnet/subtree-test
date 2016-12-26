package net.amond.eventuate.common;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Minsu Lee
 */
public abstract class AbstractAggragete implements Aggregate {

  private UUID id;
  private List<Event> uncommittedEvents = new LinkedList<>();
  private int version;

  protected AbstractAggragete(UUID id) {
    this.id = id;
  }

  protected void id(UUID id) {
    this.id = id;
  }

  @Override public UUID id() {
    return id;
  }

  @Override public Collection<Event> getUncommittedEvents() {
    return uncommittedEvents;
  }

  protected void version(int version) {
    this.version = version;
  }

  @Override public int version() {
    return version;
  }

  @Override public Aggregate applyEvent(Event event) {
    version++;
    return this;
  }

  protected void raiseEvent(Event event) {
    applyEvent(event);
    uncommittedEvents.add(event);
  }
}
