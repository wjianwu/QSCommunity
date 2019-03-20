package com.wjianwu.qs.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ResourceBundle;

/**
 * @author wjianwu 2019/2/27 9:30
 */
public class GenUtils {

    public static void main(String[] args) {
        generator("qs_article");
    }

    public static void generator(String tableName) {

        ResourceBundle resource = ResourceBundle.getBundle("mybatis-plus");

        //1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(false)     // 是否支持AR模式
                .setAuthor("wjianwu")           // 作者
                .setOutputDir(resource.getString("outputDir"))        // 生成路径
                .setFileOverride("true".equals(resource.getString("fileOverride")))  // 文件覆盖
                .setIdType(IdType.AUTO)         // 主键策略
                .setServiceName("%sService")    // 去掉会生成 I+xx+Service
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName(resource.getString("driverClass"))
                .setUrl(resource.getString("url"))
                .setUsername(resource.getString("userName"))
                .setPassword(resource.getString("passWord"));

        //3. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)                     //全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)   // 数据库表映射到实体的命名策略
                .setTablePrefix("qs_")
                .setInclude(tableName);  // 生成的表

        //4. 包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(resource.getString("parentPackageName"))
                .setMapper("dao")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("dao");

        //5. 整合配置
        AutoGenerator auto = new AutoGenerator();
        auto.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //6. 执行
        auto.execute();
    }

}
