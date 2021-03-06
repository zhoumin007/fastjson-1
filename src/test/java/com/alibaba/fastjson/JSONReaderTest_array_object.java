package com.alibaba.fastjson;

import java.io.StringReader;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.parser.JSONScanner;

public class JSONReaderTest_array_object extends TestCase {

    String text = "[{},{},{},{},{} ,{},{},{},{},{}]";

    public void test_read() throws Exception {

        JSONReader reader = new JSONReader(new StringReader(text));
        reader.startArray();

        int count = 0;
        while (reader.hasNext()) {
            reader.readObject();
            count++;
        }
        Assert.assertEquals(10, count);

        reader.endArray();
        reader.close();
    }

    public void test_read_1() throws Exception {
        JSONReader reader = new JSONReader(new JSONScanner(text));
        reader.startArray();

        int count = 0;
        while (reader.hasNext()) {
            reader.readObject();
            count++;
        }
        Assert.assertEquals(10, count);

        reader.endArray();
        reader.close();
    }
}
