package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void addNumbers() throws Exception {
        assertThat(queryProcessor.process("e8d502f0: what is 10 plus 1"), containsString("11"));
    }

    @Test
    public void multiplyNumbers() throws Exception {
        assertThat(queryProcessor.process("e8d502f0: what is 10 multiplied by 12"), containsString("120"));
    }

    @Test
    public void minusNumbers() throws Exception {
        assertThat(queryProcessor.process("e8d502f0: what is 10 minus 12"), containsString("-2"));
    }

}
