package ;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("panlinlin");
        gc.setSwagger2(true);
        gc.setOpen(true);
        gc.setIdType(IdType.AUTO);
        gc.setFileOverride(true);
        generator.setGlobalConfig(gc);

        DataSourceConfig dsf = new DataSourceConfig();
        dsf.setDbType(DbType.MYSQL); //用的什么数据库
        dsf.setUrl("jdbc:mysql://localhost:3306/mybatisplus"); //链接
        dsf.setDriverName("com.mysql.cj.jdbc.Driver"); //驱动
        dsf.setUsername("root");
        dsf.setPassword("Shang123!");
        generator.setDataSource(dsf);

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.demo");
        generator.setPackageInfo(pc );

        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setTablePrefix(pc.getModuleName() + "_");
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        generator.setStrategy(sc);

        generator.execute();
    }


}
