#拷贝备份文件到report下，备份文件为空
cp -f  /project/eclipse/AppAutomationTest/File/dataExcles/测试报告.xls /project/eclipse/AppAutomationTest/target/surefire-reports/html/
#切换工作路径
cd /project/eclipse/AppAutomationTest
echo  开始执行pom文件
MVN test
# 复制生成的html 及excle 报告到报告路径下
cp -rf /project/eclipse/AppAutomationTest/target/surefire-reports/html/* /project/eclipse/AppAutomationTest/testReport/ 
echo  测试报告复制完毕.