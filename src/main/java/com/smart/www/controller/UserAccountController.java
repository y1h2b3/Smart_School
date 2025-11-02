package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.smart.www.service.LogisticsService;
import com.smart.www.service.StudentService;
import com.smart.www.service.TeacherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@Tag(name = "账号管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class UserAccountController {
    private static final File BASEPATH = new File("D:/upload/");
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LogisticsService logisticsService;


//    @GetMapping("/studentAccount")
//    @Operation(summary = "查询所有学生账号")
//    public Result<PageDTO<Account>> findAllStudentAccount(PageQuery pageQuery) {
//        try {
//            Page<Student> Account = studentService.findAllStudent(pageQuery);
//            List<Account> accounts = Account.getRecords().stream().map(this::convertToAccount).collect(Collectors.toList());
//            PageDTO<Account> accountPageDTO = new PageDTO<>();
//            accountPageDTO.setRecords(accounts);
//            accountPageDTO.setPages((int) Account.getPages());
//            accountPageDTO.setTotal((int) Account.getTotal());
//            return Result.ok(accountPageDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(null, ResultCodeEnum.ERROR);
//        }
//    }
//
//    @GetMapping("/searchAccountStudent")
//    @Operation(summary = "根据关键字查询学生账号")
//    public Result<PageDTO<Account>> searchStudentType(PageQuery pageQuery, String key, String value) {
//        try {
//            Page<Student> Account = studentService.searchStudentType(pageQuery,key,value, name);
//            List<Account> accounts = Account.getRecords().stream().map(this::convertToAccount).collect(Collectors.toList());
//            PageDTO<Account> accountPageDTO = new PageDTO<>();
//            accountPageDTO.setRecords(accounts);
//            accountPageDTO.setPages((int) Account.getPages());
//            accountPageDTO.setTotal((int) Account.getTotal());
//            return Result.ok(accountPageDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(null, ResultCodeEnum.ERROR);
//        }
//    }
//
//    private Account convertToAccount(Student student) {
//        Account account = new Account();
//        account.setDeviceId(student.getDeviceId());
//        account.setUserId(student.getStudentId());
//        account.setUserType(student.getClazz());
//        account.setUserName(student.getName());
//        account.setPhone(student.getPhone());
//        account.setPassword(student.getPassword());
//        account.setSex(student.getSex());
//        account.setStatus(student.getStatus() == 1 ? "正常" : "禁用");
//        account.setCreateTime(student.getCreateTime());
//        account.setUpdateTime(student.getUpdateTime());
//        return account;
//    }
//
//    @GetMapping("/teacherAccount")
//    @Operation(summary = "查询所有老师账号")
//    public Result<PageDTO<Account>> findAllTeacherAccount(PageQuery pageQuery) {
//        try {
//            Page<Teacher> Account = teacherService.findAllTeacher(pageQuery);
//            List<Account> accounts = Account.getRecords().stream().map(this::convertToAccount).collect(Collectors.toList());
//            PageDTO<Account> accountPageDTO = new PageDTO<>();
//            accountPageDTO.setRecords(accounts);
//            accountPageDTO.setPages((int) Account.getPages());
//            accountPageDTO.setTotal((int) Account.getTotal());
//            return Result.ok(accountPageDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(null, ResultCodeEnum.ERROR);
//        }
//    }
//
//    @GetMapping("/searchAccountTeacher")
//    @Operation(summary = "根据关键字查询教师账号")
//    public Result<PageDTO<Account>> searchTeacherType(PageQuery pageQuery, String key, String value) {
//        try {
//            Page<Teacher> Account = teacherService.searchTeacherType(pageQuery,key,value);
//            List<Account> accounts = Account.getRecords().stream().map(this::convertToAccount).collect(Collectors.toList());
//            PageDTO<Account> accountPageDTO = new PageDTO<>();
//            accountPageDTO.setRecords(accounts);
//            accountPageDTO.setPages((int) Account.getPages());
//            accountPageDTO.setTotal((int) Account.getTotal());
//            return Result.ok(accountPageDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(null, ResultCodeEnum.ERROR);
//        }
//    }
//
//
//    private Account convertToAccount(Teacher teacher) {
//        Account account = new Account();
//        account.setDeviceId(teacher.getDeviceId());
//        account.setUserId(teacher.getTeacherId());
//        account.setUserType(teacher.getPost());
//        account.setUserName(teacher.getName());
//        account.setPhone(teacher.getPhone());
//        account.setPassword(teacher.getPassword());
//        account.setSex(teacher.getSex());
//        account.setStatus(teacher.getStatus() == 1 ? "正常" : "禁用");
//        account.setCreateTime(teacher.getCreateTime());
//        account.setUpdateTime(teacher.getUpdateTime());
//        return account;
//    }
//
//    @GetMapping("/logisticsAccount")
//    @Operation(summary = "查询所有后勤账号")
//    public Result<PageDTO<Account>> findAllLogisticsAccount(PageQuery pageQuery) {
//        try {
//            Page<Logistics> Account = logisticsService.findAllLogistics(pageQuery);
//            List<Account> accounts = Account.getRecords().stream().map(this::convertToAccount).collect(Collectors.toList());
//            PageDTO<Account> accountPageDTO = new PageDTO<>();
//            accountPageDTO.setRecords(accounts);
//            accountPageDTO.setPages((int) Account.getPages());
//            accountPageDTO.setTotal((int) Account.getTotal());
//            return Result.ok(accountPageDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(null, ResultCodeEnum.ERROR);
//        }
//    }
//
//    @GetMapping("/searchAccountLogistics")
//    @Operation(summary = " 根据关键词查询后勤账号")
//    public Result<PageDTO<Account>> searchLogisticsAccount(PageQuery pageQuery, String key, String value) {
//        try {
//            Page<Logistics> Account = logisticsService.searchLogisticsType(pageQuery,key,value);
//            List<Account> accounts = Account.getRecords().stream().map(this::convertToAccount).collect(Collectors.toList());
//            PageDTO<Account> accountPageDTO = new PageDTO<>();
//            accountPageDTO.setRecords(accounts);
//            accountPageDTO.setPages((int) Account.getPages());
//            accountPageDTO.setTotal((int) Account.getTotal());
//            return Result.ok(accountPageDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(null, ResultCodeEnum.ERROR);
//        }
//    }
//
//    private Account convertToAccount(Logistics logistics) {
//        Account account = new Account();
//        account.setDeviceId(logistics.getDeviceId());
//        account.setUserId(logistics.getLogisticsId());
//        account.setUserType(logistics.getPost());
//        account.setUserName(logistics.getName());
//        account.setPhone(logistics.getPhone());
//        account.setPassword(logistics.getPassword());
//        account.setSex(logistics.getSex());
//        account.setStatus(logistics.getStatus() == 1 ? "正常" : "禁用");
//        account.setCreateTime(logistics.getCreateTime());
//        account.setUpdateTime(logistics.getUpdateTime());
//        return account;
//    }

    // @RequestMapping注解用于映射web请求到特定的处理器函数
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(
            // @RequestParam注解用于将请求参数绑定到方法参数上
            @RequestParam(value = "fileName") MultipartFile multipartFile
    ) {
        // 获取上传文件的原始文件名
        String originalFilename = multipartFile.getOriginalFilename();

        // 提取文件扩展名（后缀）
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);

        // 生成新的文件名，使用UUID确保文件名唯一性
        String newFileName = String.valueOf(UUID.randomUUID()) + "." + suffix;

        // 构建文件存储的完整路径
        File file = new File(BASEPATH + newFileName);

        try {
            // 将上传的文件保存到指定路径
            multipartFile.transferTo(file);
        } catch (IOException e) {
            // 如果文件保存过程中发生异常，则抛出运行时异常
            throw new RuntimeException("文件保存失败: " + e.getMessage(), e);
        }

        // 返回新生成的文件名
        return newFileName;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam(value = "fileName") String fileName,
                         HttpServletResponse response) {
        // 设置响应内容类型为JPEG图片
        response.setContentType("image/jpeg");
        try {
            // 打开图片文件输入流
            FileInputStream fileInputStream = new FileInputStream(BASEPATH + fileName);
            // 获取响应输出流
            ServletOutputStream outputStream = response.getOutputStream();
            // 初始化一个字节数组用于缓冲
            int length = 0;
            byte[] bytes = new byte[1024];
            // 循环读取文件内容，并写入到响应输出流中
            while ((length = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
                // 刷新输出流，确保数据被发送到客户端
                outputStream.flush();
            }
            // 关闭文件输入流
            fileInputStream.close();
            // 关闭响应输出流
            outputStream.close();
        } catch (FileNotFoundException e) {
            // 如果文件未找到，则抛出运行时异常
            throw new RuntimeException("文件未找到: " + fileName, e);
        } catch (IOException e) {
            // 如果在文件读取或写入过程中发生I/O异常，则抛出运行时异常
            throw new RuntimeException("文件下载失败: " + fileName, e);
        }
    }
}
