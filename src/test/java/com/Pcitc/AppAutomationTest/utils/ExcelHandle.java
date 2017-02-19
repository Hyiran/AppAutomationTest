package com.Pcitc.AppAutomationTest.utils;


import org.testng.annotations.Test;

import jxl.*;   
import jxl.format.UnderlineStyle;   
import jxl.write.*;   
import jxl.write.Number;   
import jxl.write.Boolean;

import java.awt.List;
import java.io.*;   
  
/**  
* Created by IntelliJ IDEA.  
* User: xl  
* Date: 2005-7-17  
* Time: 9:33:22  
* To change this template use File | Settings | File Templates.  
*/   
public class ExcelHandle    extends GetClassMethodName
{   
//	构造函数
public ExcelHandle()   
{   
}   
  
/**  
* 读取Excel  
*  
* @param filePath  
*/   

//OutputStream 对象
static OutputStream os =null;
//excle 的file对象
static File fileWrite=null;
static Workbook rwb = null;
//可写的工作薄对象
static WritableWorkbook wwb=null;
//可写的sheet页对象
static WritableSheet ws = null;  

static File fileBefore =null;
static File fileAfter =null;

/**
 * 新增excle文件，新增时必须先执行
 * @param FilePath   文件路径
 * @param sheetNo     索引
 * @param sheetName    名称
 */
public  void addExcleFile(String FilePath)   
{   
	try {
		
	 	 fileWrite =new File(FilePath);
//			创建 OutputStream对象
			 os = new FileOutputStream(fileWrite);   
			 wwb = Workbook.createWorkbook(os); 
			fileWrite.createNewFile(); 
		
	} catch (Exception e) {
		ErrorLog.logError("ExcelHandle-excle文件新建错误错误：--"+e.toString(),GetClassMethodName());
	}
}

/**
 * 添加 sheet，执行 addExcleFile 后执行
 * @param sheetNo    对第几个sheet 操作
 * @param sheetName  Sheet 名字
 */
public  void addSheet(int sheetNo, String sheetName)   
{  
try {
	//创建Excel工作表 指定名称和位置   
	 ws = wwb.createSheet(sheetName,sheetNo);   

} catch (Exception e) {
	ErrorLog.logError("ExcelHandle-sheet新建错误错误：--"+e.toString(),GetClassMethodName());
}
}



/**
 * 更新时的文件地址
 * @param oldFilePath
 * @param newFilePath
 */
public  static String excleFilePath="";
public static String exclesheetName="";
public static void updateFile(String oldFilePath,String newFilePath)   
{ 
	try {
		excleFilePath=newFilePath;
		fileBefore =new File(oldFilePath);
		fileAfter =new File(newFilePath);
		rwb = Workbook.getWorkbook(fileBefore); 
	    wwb = Workbook.createWorkbook(fileAfter,rwb);//copy  复制文件
	} catch (Exception e) {
		// TODO: handle exception
	}	
}
/**
 * 跟新文件的sheet名字在updateFile执行后执行
 * @param sheetName sheet 明子
 */

public static void updateSheet(String sheetName)   
{ 
	try {
		exclesheetName=sheetName;
//		指定sheet
		 ws = wwb.getSheet(sheetName);   
	} catch (Exception e) {
		// TODO: handle exception
	}
}

/**
 * 新增或者更新cell数据，在addExcleFile或updateSheet 执行后执行
 * @param x
 * @param y
 * @param Data 输入数据
 */
public static String excleCell="";
public  void addCellData(int x,int y,String Data)   
{  
try {
	excleCell=Data;
	WritableFont wf = new WritableFont(WritableFont.TIMES,18,WritableFont.BOLD,true);   
	WritableCellFormat wcf = new WritableCellFormat(wf);   
	Label labelcf = new Label(y,x,Data,wcf);   
	ws.addCell(labelcf);   
//	afterExcle();
} catch (Exception e) {
	ErrorLog.logError("ExcelHandle-addCell插入或更新错误：--"+e.toString(),GetClassMethodName());
}
}

/**
 * 保存生成的数据，addCellData执行后执行
 * @throws WriteException
 */
public static void afterExcle()
{
	//写入工作表   
			try {
				wwb.write();
				wwb.close(); 
				rwb.close();
			} catch (Exception e) 
			{
				ErrorLog.logError(excleFilePath+"文件-"+exclesheetName+"sheet-"+excleCell+"-s保存excel失败,详情为："+e.toString());
				e.printStackTrace();
			}   

}



/**  已在其他类重写，其中定义输入数据类型可在完善
* 只能通过API提供的工厂方法来创建Workbook，而不能使用WritableWorkbook的构造函数，  
* 因为类WritableWorkbook的构造函数为protected类型  
* method(1)直接从目标文件中读取WritableWorkbook wwb = Workbook.createWorkbook(new File(targetfile));  
* method(2)如下实例所示 将WritableWorkbook直接写入到输出流  
 
*/   
public static void writeExcel(OutputStream os)   
{   
try   
{   

WritableWorkbook wwb = Workbook.createWorkbook(os);   
//创建Excel工作表 指定名称和位置   
WritableSheet ws = wwb.createSheet("Test Sheet 1",0);   
  
//**************往工作表中添加数据*****************   
  
//1.添加Label对象   
Label label = new Label(0,0,"哈哈32s哈哈");   
ws.addCell(label);   
  
//添加带有字型Formatting对象   
WritableFont wf = new WritableFont(WritableFont.TIMES,18,WritableFont.BOLD,true);   
WritableCellFormat wcf = new WritableCellFormat(wf);   
Label labelcf = new Label(1,0,"this is a label test",wcf);   
ws.addCell(labelcf);   
  
//添加带有字体颜色的Formatting对象   
WritableFont wfc = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,   
UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.RED);   
WritableCellFormat wcfFC = new WritableCellFormat(wfc);   
Label labelCF = new Label(1,0,"This is a Label Cell",wcfFC);   
ws.addCell(labelCF);   
  
//2.添加Number对象   
Number labelN = new Number(0,1,3.1415926);   
ws.addCell(labelN);   
  
//添加带有formatting的Number对象   
NumberFormat nf = new NumberFormat("#.##");   
WritableCellFormat wcfN = new WritableCellFormat(nf);   
Number labelNF = new jxl.write.Number(1,1,3.1415926,wcfN);   
ws.addCell(labelNF);   
  
//3.添加Boolean对象   
Boolean labelB = new jxl.write.Boolean(0,2,false);   
ws.addCell(labelB);   
  
//4.添加DateTime对象   
jxl.write.DateTime labelDT = new jxl.write.DateTime(0,3,new java.util.Date());   
ws.addCell(labelDT);   
  
//添加带有formatting的DateFormat对象   
DateFormat df = new DateFormat("dd MM yyyy hh:mm:ss");   
WritableCellFormat wcfDF = new WritableCellFormat(df);   
DateTime labelDTF = new DateTime(1,3,new java.util.Date(),wcfDF);   
ws.addCell(labelDTF);   
  
  
//添加图片对象,jxl只支持png格式图片   
//File image = new File("Users/fujiaxi/Desktop/11.png");   
//WritableImage wimage = new WritableImage(0,1,2,2,image);   
//ws.addImage(wimage);   
//写入工作表   
wwb.write();   
wwb.close();   
}   
catch(Exception e)   
{   
e.printStackTrace();   
}   
}   
  

/**  修改值，在其他类中重写 
* 拷贝后,进行修改,其中file1为被copy对象，file2为修改后创建的对象   
* 尽单元格原有的格式化修饰是不能去掉的，我们还是可以将新的单元格修饰加上去，   
* 以使单元格的内容以不同的形式表现   
* @param file1   
* @param file2   
*/   
public static void modifyExcel(File file1,File file2)   
{   
try   
{   
Workbook rwb = Workbook.getWorkbook(file1);   
WritableWorkbook wwb = Workbook.createWorkbook(file2,rwb);//copy   

WritableSheet ws = wwb.getSheet(0);   
WritableCell wc = ws.getWritableCell(0,0);   
//判断单元格的类型,做出相应的转换   
if(wc.getType() == CellType.LABEL)   
{   
Label label = (Label)wc;   
label.setString("The value has been modified");   
}   
wwb.write();   
wwb.close();   
rwb.close();   
}   
catch(Exception e)   
{   
e.printStackTrace();   
}   
}   
  
  


//@Test(description="测试新生成文件，并生成sheet，生成数据",priority = 1)
public void testWriteExcle()
{
try {
	//	添加一个文件
	addExcleFile("/project/eclipse/AndroidTest/ExcelData/jurry0001.xls");
	
//	添加三个sheet页 并依次赋值
	addSheet(0, "test1");
	addCellData(0, 0, "数据1");
	
	addSheet(1, "test2");
	addCellData(1, 0, "数据2");
	
	addSheet(2, "test3");
	addCellData(3, 0, "数据3");

	afterExcle();
} catch (Exception e) {
	// TODO: handle exception
}
}
@Test(description="测试更新数据",priority = 2)
public void testUpdateExcle()
{
	try {
		
		updateFile("/project/eclipse/AndroidTest/ExcelData/jurry0001.xls", "/project/eclipse/AndroidTest/ExcelData/jurry0001.xls");
		//如果两个参数不一致，执行后会生成一个新文件为参数二，与参数1文件相同；如修改cell值只对新生成的附件起作用
		updateSheet("test1");
		
		addCellData(0, 4, "新增测试");
//		保存生效配置
		afterExcle();
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}   