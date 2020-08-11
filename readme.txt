ssm-demo该项目实现以下功能：

    1.SSM三大框架的整合：web.xml——applicationContext.xml——springmvc.xml——mybatis-config.xml——jdbc.properties
               扫描加载：mybatis（mapper.xml/dao），使用别名扫描（bean）——springmvc.xml（controller）
                        ——applicationContext.xml（service）

    2.Pagehelper进行分页处理：导入Pagehelper的jar——applicationContext.xml配置分页插件——CategoryController

    3.Druid数据连接池：applicationContext.xml配置——jdbc.properties

    4.CRUD增删改查操作：bean（Category）——dao（CategoryMapper）——mapper（CategoryMapper.xml）
                        ——service（CategoryService）——impl（CategoryServiceImpl）——controller（CategoryController）

    5.TransactionManager声明式事务测试：applicationContext.xml配置开启事务——TransactionTest进行测试

    6.JSON-AJAX请求数据(前后端分离)：springmvc.xml防止Json乱码——获取后台的数据getOne/Many.html——将前端数据传入后端submit.html——JsonController

    7.Restful风格：web.xml配置还原方法——listCategory.jsp更改路径及提交方法——CategoryController

    8.session统计网页访问次数：SessionController——check.jsp

    9.图片上传下载：进入fileuser——上传upload——展示图片listfile——下载download

    10.velocity配置测试：springmvc.xml——velocity.properties——VelocityController——velocity.vm