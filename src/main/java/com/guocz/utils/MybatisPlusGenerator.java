package com.guocz.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

/**
 * @author guocz
 * @date 2022/7/25 10:16
 */
public class MybatisPlusGenerator {

    private static final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false";

    private static final String DATASOURCE_USER = "root";

    private static final String DATASOURCE_PASS = "123456";

    /**
     * 作者
     */
    private static final String AUTHOR = "springBoot-Learning";

    public static void main(String[] args) {

        FastAutoGenerator.create(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASS)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.guocz") // 设置父包名
//                            .moduleName("shardingtest") // 设置父包模块名
                            // .service()  // 设置自定义service路径,不设置就是默认路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") +"/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")
                            // 设置自动填充的时间字段
                            .entityBuilder().addTableFills(
                                    new Column("create_time", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE))
                    ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
