package com.ricardohsd.datastreaming;

import com.ricardohsd.datastreaming.SamplerProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SampleProcessorTest {
    @Test
    public void returnsInputWhenStreamHasSameSampleSize() throws Exception {
        InputStream stream = new ByteArrayInputStream("AHB".getBytes());

        SamplerProcessor processor = new SamplerProcessor(3, stream);

        assertEquals("AHB", processor.process());
    }

    @Test
    public void returnsRandomSample() throws Exception {
        InputStream stream = new ByteArrayInputStream("AHBCDEFGH".getBytes());

        SamplerProcessor processor = new SamplerProcessor(3, stream);
        String result = processor.process();

        assertEquals(3, result.length());
        assertTrue(result.matches("^[AHBCDEFGH]{3}$"));
    }

    @Test
    public void closesInputStream() throws Exception {
        InputStream stream = new ByteArrayInputStream("AHB".getBytes());
        InputStream streamSpy = Mockito.spy(stream);

        try {
            SamplerProcessor processor = new SamplerProcessor(3, streamSpy);

            processor.process();

            Mockito.verify(streamSpy).close();
        } catch(IOException e) {
            Assert.fail("Failed to ensure input stream is closed");
        }
    }
}
