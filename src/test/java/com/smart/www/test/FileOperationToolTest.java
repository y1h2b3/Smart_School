package com.smart.www.test;

import com.smart.www.tools.FileOperationTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FileOperationToolTest {

    @Test
    public void testReadFile() {
        FileOperationTool tool = new FileOperationTool();
        String fileName = "Zzzzh.txt";
        String result = tool.readFile(fileName);
        assertNotNull(result);
    }

    @Test
    public void testWriteFile() {
        FileOperationTool tool = new FileOperationTool();
        String fileName = "Zzzzh.txt";
        String content = "医学养生大百科套装10册";
        String result = tool.writeFile(fileName, content);
        assertNotNull(result);
    }
}
