package net.amond.eventuate.common;

public class EventuateCommandProcessingFailedException extends EventuateClientException {
  public EventuateCommandProcessingFailedException(Throwable t) {
    super(t);
  }
}