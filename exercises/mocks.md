# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.


Nos tests sont les suivants:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doAnswer;

@ExtendWith(MockitoExtension.class)
public class TLSSocketFactoryTestMocks {
	
	@Mock
	SSLSocket s;

	/**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        when(s.getSupportedProtocols()).thenReturn(null);
        when(s.getEnabledProtocols()).thenReturn(null);
        new TLSSocketFactory().prepareSocket(s);
    }
    
    @Test
    public void typical()  {
    	when(s.getSupportedProtocols()).thenReturn(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
        when(s.getEnabledProtocols()).thenReturn(new String[]{"SSLv3", "TLSv1"});
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                assertTrue(Arrays.equals((String[]) invocation.getArguments()[0], new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
                return null;
              }
          }).when(s).setEnabledProtocols(any(String[].class));
        new TLSSocketFactory().prepareSocket(s);
    }

}


```
