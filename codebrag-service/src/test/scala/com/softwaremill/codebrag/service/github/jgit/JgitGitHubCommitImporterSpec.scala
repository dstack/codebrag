import org.mockito.{ArgumentCaptor, ArgumentMatcher}
import scala.collection.JavaConversions._
    val commitArgument = ArgumentCaptor.forClass(classOf[CommitInfo])
    verify(commitInfoDaoMock, times(2)).storeCommit(commitArgument.capture())
    val capturedCommits = commitArgument.getAllValues
    capturedCommits(0).message should equal("fourth update message")
    capturedCommits(1).message should equal("third update message")
      uriBuilder),