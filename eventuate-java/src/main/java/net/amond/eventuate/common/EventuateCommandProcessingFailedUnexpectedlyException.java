package net.amond.eventuate.common;

public class EventuateCommandProcessingFailedUnexpectedlyException
    extends EventuateClientException {
  public EventuateCommandProcessingFailedUnexpectedlyException(ReflectiveOperationException t) {
    super(t);
  }
}