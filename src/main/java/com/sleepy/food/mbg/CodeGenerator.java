package com.sleepy.food.mbg;

import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;

import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        //是否支持AR模式
        gc.setActiveRecord(true)
                //设置作者
                .setAuthor("sleepy")
                //设置项目目录-官网写的是绝对路径
                .setOutputDir("src\\main\\java")
                //设置多次生成文件是否覆盖
                .setFileOverride(true)
                //设置主键自增策略
                //.setIdType(IdType.AUTO);
                //设置Service类去除I
                .setServiceName("%sService")
                //xml中生成基本的resultMap
                .setBaseResultMap(true)
                //xml中生成基本的列的集合
                .setBaseColumnList(true)
                //完成后打开输出文件夹 false为不打开
                .setOpen(false);
        mpg.setGlobalConfig(gc);

        // 2. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //设置数据库类型
        dsc.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://127.0.0.1:3306/ftc?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("root");
        mpg.setDataSource(dsc);
        // dsc.setSchemaName("public");


        // 3. 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.sleepy.food");
        //pc.setEntity("entity").setController("controller").setService("service").setMapper("mapper").setXml("mapper");
        mpg.setPackageInfo(pc);

        // 4. 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        mpg.setCfg(cfg);
        /*
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        *//*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        *//*
        cfg.setFileOutConfigList(focList);

*/
        // 5. 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        mpg.setTemplate(templateConfig);

        // 6. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //开启全局大写命名
        strategy.setCapitalMode(true)
                //数据库表映射到实体的命名策略 驼峰命名
                //.setNaming(NamingStrategy.underline_to_camel)
                //指定表名字段名是否使用 驼峰命名
                //.setColumnNaming(NamingStrategy.underline_to_camel)
                //设置表名前缀
                //.setTablePrefix("tbl_")
                //被操作的表名不设置的话在一开始输入strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
                .setInclude("user")
                //使用lombok
                .setEntityLombokModel(true)
                //使用RestController
                .setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        /*strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        // 公共父类
        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");*/
        // 7. 开始执行
        mpg.execute();
    }

}
