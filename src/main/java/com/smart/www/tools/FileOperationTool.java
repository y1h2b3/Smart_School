package com.smart.www.tools;

import com.smart.www.constant.FileConstant;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperationTool {

    private final String FILE_DIR = FileConstant.FILE_SAVE_DIR + "/file";

    @Tool(description = "Read content from a file")
    public String readFile(@ToolParam(description = "Name of the file to read") String fileName) {
        Path filePath = Paths.get(FILE_DIR, fileName);
        try {
            if (!Files.exists(filePath)) {
                return "Error: File does not exist: " + fileName;
            }
            return Files.readString(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    @Tool(description = "Write content to a file")
    public String writeFile(
            @ToolParam(description = "Name of the file to write") String fileName,
            @ToolParam(description = "Content to write to the file") String content) {
        Path dirPath = Paths.get(FILE_DIR);
        Path filePath = dirPath.resolve(fileName);
        try {
            // 创建目录（如果不存在）
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }
            // 写入文件
            Files.writeString(filePath, content, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return "File written successfully to: " + filePath.toString();
        } catch (IOException e) {
            return "Error writing to file: " + e.getMessage();
        }
    }
}
