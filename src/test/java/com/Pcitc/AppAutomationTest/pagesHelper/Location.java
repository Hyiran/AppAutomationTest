package com.Pcitc.AppAutomationTest.pagesHelper;


import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidKeyCode;

public  class Location 
{	 
	/**
	 * TextView 对象，参数值为text属性
	 */
	 public  static final String TextView_Ptext="TextView_Ptext";
	 
	
	  public  static final String TextView_qualText="TextView_qualText";
	  /**
	   * text＋索引 方式定位TextView，用于同名出现多次的
	   */
	  public  static final String  TextView_Ptext_Pindex="TextView_Ptext_Pindex";
	    
	  /**
	   *  使用索引的方式定位EditText控件
	   */
	  public  static final String    EditText_Ptext="EditText_Ptext";
	/**
	 	* 使用文本的方式定位EditText控件
	 */
	  public  static final String    EditText_Pindex="EditText_Pindex";
	  
	  
	  /**
		 * 使用text属性定位Button控件
		 * 
		 */
	  public  static final String  Button_Ptext="Button_Ptext";
	  /**
		 * 使用index属性定位Button控件
		 * 
		 */
	  public  static final String  Button_Pindex="Button_Pindex";
	  /**
		 * 根据TextView属性定位同级前面的CheckBox_，如批审，数据前面的复选框
		 * @par ：TextView属性
		 * 
		 */
	  public  static final String   CheckBox_following_iblingTextView="CheckBox_following-siblingTextView";
	  /**
		 * 使用id属性定位id控件
		 * 
		 */
	  public  static final String id ="id";
	
	  /**
	   * 使用索引定位ImageView控件
	   */
	  public  static final String    ImageView_Pindex="ImageView_Pindex";
	  /**
	   * 使用索引定位TableRow_Pindex控件
	   */
	  public  static final String     TableRow_Pindex="TableRow_Pindex";
	  /**
	   * 使用文本定位TableRow_Pindex控件
	   */
	  public  static final String     TableRow_Ptext="TableRow_Ptext";
	  /**
	   * 使用text＋index属性，定位与所传TextView同级之前的TextView对象
	   */
	  public  static final String  TextView_Ptext_precedingSiblingTextView_Pindex="TextView_Ptext_preceding-siblingTextView_Pindex";
	  /**
	   * 使用text＋index属性，定位与所传TextView同级之后的TextView对象
	   */
	  public  static final String TextView_Ptext_followingSiblingTextView_Pindex="TextView_Ptext_following-siblingTextView_Pindex";
	  /**
	   * 使用text＋index属性，定位与所传TextView同级之后的EditView对象
	   */
	  public  static final String   TextView_Ptext_followingSiblingEditView_Pinde="TextView_Ptext_following-siblingEditView_Pindex";
	  /**
	   * 使用text，定位与所传TextView同级之后的TextView对象,返回是webelements
	   */
	  public  static final String  TextView_Ptext_following_sibling_TextView ="TextView_Ptext_following-siblingTextView";
	  /**
	   * 使用index ＋text属性，定位ListViewTextView下的TextView
	   */
	  public  static final String     ListViewTextView_Pindex_TextView_Ptext="ListViewTextView_Pindex_TextView_Ptext";
	  /**
	    * 使用index属性定位CheckedTextView
	    */
	  public  static final String CheckedTextView_Pindex="CheckedTextView_Pindex";
	   /**
	    * 使用文本属性定位CheckedTextView
	    */
	  public  static final String CheckedTextView_Ptext="CheckedTextView_Ptext";
	  
	  /**
	   * 定位ListView下的TextView，返回welements
	   */
	  public  static final String   ListViewTextView_Pindex="ListViewTextView_Pindex";
	  /**
	   * 定位ListView下的CheckedTextViews，返回welements
	   */
	  public  static final String  ListViewCheckedTextViews_Pindex="ListViewCheckedTextView_Pindex";
	  /**
	   * 获得单号对应到标题，p1 单号p2标题
	   */
	  public  static final String  NO_Tilte="NO_Tilte";
	  /**
	   * 获得单号对应到标题数据，p1 单号p2标题
	   */
	  public  static final String  NO_Data="NO_Data";
	  /**
	   * 获得审批列表数据集合－费用报销
	   * @par 1 第i行审批数据的索引
	   */
	  public  static final String    LinearLayout_Pindex_TextViews="LinearLayout_Pindex_TextViews";
	/**
	 * 日期控件
	 */
	  public  static final String 	  NumberPickerButten_Index="NumberPickerButten_Index";
	  public  static final String 	  NumberPickerText_Text="NumberPickerText_Text";



}	