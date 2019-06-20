package com.chungfung.service.impl;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/20 14:14
 * @Version 1.0
 */
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chungfung.entity.Student;
import com.chungfung.mapper.StudentMapper;
import com.chungfung.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {
}