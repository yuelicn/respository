package com.yl.myproject.clazz;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class GenEntityMysql {
	
	private String packageOutPath = "com.user.entity";//指定实体生成所在包的路径
	private String authorName = "封狼居胥";//作者名字
	private String tablename = "user";//表名
	private String[] colnames={"name","name1"}; // 列名数组
	private String[] colTypes={"String","String"}; //列名类型数组
	private int[] colSizes; //列名大小数组
	private String LT ="\r\n\r\n";
	private String[] imports ={"import org.apache.commons.lang.StringUtils;"+LT
			,"import org.slf4j.Logger;"+LT
			,"import org.slf4j.LoggerFactory;"+LT
			,"import com.alibaba.fastjson.JSONObject;"+LT};
	
	

	/*
	 * 构造函数
	 */
	
	public GenEntityMysql() throws IOException{
    	
			String content = parse(colnames,colTypes,colSizes);
			
				File directory = new File("");
				//System.out.println("绝对路径："+directory.getAbsolutePath());
				//System.out.println("相对路径："+directory.getCanonicalPath());
				String path=this.getClass().getResource("").getPath();
				
				System.out.println(path);
				System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );
//				String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";
				String outputPath = directory.getAbsolutePath()+ "/src/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tablename) + ".java";
				
				File file = new File(outputPath);
				if(!file.exists()) file.createNewFile();
				
				FileWriter fw = new FileWriter(outputPath);
				
				PrintWriter pw = new PrintWriter(fw);
				pw.println(content);
				pw.flush();
				pw.close();
    }

	/**
	 * 功能：生成实体类主体代码
	 * @param colnames
	 * @param colTypes
	 * @param colSizes
	 * @return
	 */
	private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();
		
		//判断是否导入工具包
		
		sb.append("package " + this.packageOutPath + ";"+LT);
		processAllImport(sb);
		sb.append("\r\n");
		//注释部分
		sb.append("   /**\r\n");
		sb.append("    * "+tablename+" 实体类\r\n");
		sb.append("    * "+new Date()+" "+this.authorName+LT);
		sb.append("    */ \r\n");
		//实体部分
		sb.append("\r\npublic class " + initcap(tablename) +" extends BaseOutputUtil " +"{"+LT);
		
		sb.append("\r\n	private static Logger LOGGER = LoggerFactory.getLogger("+initcap(tablename)+".class);\r\n");
		
		sb.append("\r\n private ResponseVO resVO;\r\n");
		
		sb.append("\r\n public XYHDUtil() {\r\n");
		sb.append("\r\n resVO = new ResponseVO();\r\n}\r\n");
		
		sb.append("@Override\r\n");
		sb.append("public ResponseVO sendOrder(RequestVO reqVO) {");
		
		
		
		
		
		processAllAttrs(sb);//属性
		processAllMethod(sb);//get set方法
		sb.append("}"+LT);
		
    	//System.out.println(sb.toString());
		return sb.toString();
	}
	/**
	 * 
	 * @Description: 生成import
	 * @param @param sb   
	 * @return void  
	 * @throws
	 * @author yue.li3
	 * @date 2016年5月19日
	 */
	private void processAllImport(StringBuffer sb){
		for (String string : imports) {
			sb.append(string);
		}
	}
	
	
	
	
	
	
	
	/**
	 * 功能：生成所有属性
	 * @param sb
	 */
	private void processAllAttrs(StringBuffer sb) {
		
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + (colTypes[i]) + " " + colnames[i] + ";\r\n");
		}
		
	}

	/**
	 * 功能：生成所有方法
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + (colTypes[i]) + " " + 
					colnames[i] + "){\r\n");
			sb.append("\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
			sb.append("\tpublic " + (colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
		
	}
	
	/**
	 * 功能：将输入字符串的首字母改成大写
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		
		char[] ch = str.toCharArray();
		if(ch[0] >= 'a' && ch[0] <= 'z'){
			ch[0] = (char)(ch[0] - 32);
		}
		
		return new String(ch);
	}

	
	
	/**
	 * 出口
	 * TODO
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		new GenEntityMysql();
		
	}

}