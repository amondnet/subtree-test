import co.test.Asdf;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.msemys.esjc.EventStore;
import com.github.msemys.esjc.EventStoreBuilder;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import net.amond.eventuate.common.AggregateRepository;
import org.junit.Test;

/**
 * @author Minsu Lee
 */
public class SaveTest {
  @Test
  public void saveTest() throws ExecutionException, InterruptedException, JsonProcessingException {

    EventStore eventStore = EventStoreBuilder.newBuilder()
        .singleNodeAddress("127.0.0.1", 1113)
        .userCredentials("admin", "changeit")
        .build();

    AggregateRepository<TestAggregate> aggregateRepository =
        new AggregateRepository(TestAggregate.class, eventStore, new ObjectMapper());

    UUID aggregateId = UUID.randomUUID();
    TestAggregate testAggregate = new TestAggregate(aggregateId);
    testAggregate.ProduceEvents(20);

    aggregateRepository.save(testAggregate).get();

    System.out.println(
        new ObjectMapper().writeValueAsString(aggregateRepository.getById(aggregateId)));
  }

  public void prjectionTest()
      throws ExecutionException, InterruptedException, JsonProcessingException {
    EventStore eventStore = EventStoreBuilder.newBuilder()
        .singleNodeAddress("127.0.0.1", 1113)
        .userCredentials("admin", "changeit")
        .build();
  }


  @Test
  public void test() {

    System.out.println( Asdf.class.getName() );
    System.out.println( Asdf.class.getTypeName() );
    System.out.println( Asdf.class.getSimpleName() );

  }
}
